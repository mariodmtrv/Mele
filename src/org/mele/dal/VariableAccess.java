package org.mele.dal;

import org.mele.backend.dataaccess.DBConnection;
import org.mele.backend.dataaccess.files.DataType;
import org.mele.backend.dataaccess.files.Property;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
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

    public void createVariable(String variableName, String variableId, Integer ownerId, List<Property> properties) {
        String createVariableStatement = "";
        StringBuilder builder = new StringBuilder();


        try {
            System.out.println(createVariableStatement);
            PreparedStatement createPrepared = connection.prepareStatement(createVariableStatement);
            builder.append("CREATE TABLE " + variableId + " (");


            for (int ind = 0; ind < properties.size(); ind++) {
                Property property = properties.get(ind);
                builder.append(property.getName() + " " + property.getDataType().getStoreDatatype() + " NOT NULL,");
            }
            builder.deleteCharAt(builder.length() - 1);
            builder.append(")");
            createVariableStatement = builder.toString();
            createPrepared = connection.prepareStatement(createVariableStatement);
            createPrepared.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEntry(String variableId, List<Property> properties, String[] entry) {
        StringBuilder insertQuery = new StringBuilder("INSERT INTO" + variableId + " VALUES ( ?");

        for (int ind = 1; ind < properties.size(); ind++) {
            insertQuery.append(", ?");
        }
        insertQuery.append(")");
        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(insertQuery.toString());
            for (int ind = 0; ind < properties.size(); ind++) {

            }
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
}
