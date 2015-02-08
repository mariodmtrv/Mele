package org.mele.backend.functions;

import org.mele.backend.dataaccess.DBConnection;
import org.mele.dal.VariableAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by mariodimitrov on 1/22/15.
 */
public class VariableOperations {
    Integer variableId;
    Connection connection;

    public VariableOperations(String variableName, Integer ownerId) {
        VariableAccess access = new VariableAccess();
        variableId = access.getVariableId(variableName, ownerId);
        connection = DBConnection.getConnection();
    }

    public void test(String propertyName) {

        try {
            String getPropertyStatement = "SELECT ? FROM ?";
            PreparedStatement getValuesPrepared = connection.prepareCall(getPropertyStatement);
//connection.
            getValuesPrepared.setString(1, propertyName);
            String value = "var" + variableId;
            //          getValuesPrepared.setString(2, value);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
