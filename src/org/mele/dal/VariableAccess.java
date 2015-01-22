package org.mele.dal;

import com.google.appengine.repackaged.com.google.api.client.util.DateTime;
import org.mele.backend.dataaccess.DBConnection;
import org.mele.backend.dataaccess.files.DataType;
import org.mele.backend.dataaccess.files.MultikeyResource;
import org.mele.backend.dataaccess.files.Property;

import java.sql.*;
import java.util.List;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class VariableAccess {
    Connection connection;

    String createVariableDataStatement = "";
    String insertVariableDataStatement = "";


    public VariableAccess() {
        connection = DBConnection.getConnection();
    }

    public void destroyVariable(String variableId) {
        String destroyQuery = "DROP TABLE " + variableId;
        Statement destroyStatement = null;
        try {
            destroyStatement = connection.createStatement();
            destroyStatement.executeQuery(destroyQuery);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void createVariable(String variableName, Integer ownerId, List<Property> properties) {
        String createActiveVariableStatement = "INSERT INTO activevars(varname, lastused, ownerid) VALUES (?,?,?)";
        StringBuilder builder = new StringBuilder();

        try {
            // register variable
            PreparedStatement createActiveVarPrepared = connection.prepareStatement(createActiveVariableStatement);
            createActiveVarPrepared.setString(1, "var" + variableName);

            createActiveVarPrepared.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            createActiveVarPrepared.setInt(3, ownerId);
            createActiveVarPrepared.execute();
            //get registered id

            int varId = getVariableId(variableName, ownerId);
            //create variable

            builder.append("CREATE TABLE var" + varId + " (");


            for (int ind = 0; ind < properties.size(); ind++) {
                Property property = properties.get(ind);
                builder.append(property.getName() + " " + property.getDataType().getStoreDatatype() + " NOT NULL,");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
            String createActiveVariableTable = builder.toString();
            PreparedStatement createActiveVarTable = connection.prepareStatement(createActiveVariableTable);
            createActiveVarTable.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addEntry(String variableId, List<Property> properties, String[] entry) {
        StringBuilder insertQuery = new StringBuilder("INSERT INTO " + variableId + " VALUES ( ?");

        for (int ind = 1; ind < properties.size(); ind++) {
            insertQuery.append(", ?");
        }
        insertQuery.append(")");
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insertQuery.toString());
            for (int ind = 0; ind < properties.size(); ind++) {
                addPropertyToStatement(statement, ind + 1, properties.get(ind), entry[ind]);
            }
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addPropertyToStatement(PreparedStatement statement, int index, Property property, String value) {
        DataType type = property.getDataType();
        if (type == DataType.INTEGER) {
            try {
                statement.setInt(index, Integer.parseInt(value));
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (type == DataType.BOOLEAN) {
            try {
                statement.setBoolean(index, Boolean.parseBoolean(value));
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (type == DataType.DOUBLE) {
            try {
                statement.setDouble(index, Double.parseDouble(value));
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
            }
        } else if (type == DataType.STRING) {
            try {
                statement.setString(index, value);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        // TODO Add other data types here
    }

    public int getVariableId(String variableName, Integer ownerId) {
        PreparedStatement variableIdQuery = null;
        Statement getStatement = null;
        try {
            variableIdQuery = connection.prepareStatement("SELECT varid FROM activevars WHERE varname=? AND ownerid=?");

            variableIdQuery.setString(1, "var" + variableName);
            variableIdQuery.setInt(2, ownerId);
            ResultSet result = variableIdQuery.executeQuery();
            result.next();
            return result.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}