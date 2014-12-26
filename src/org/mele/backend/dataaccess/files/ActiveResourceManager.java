package org.mele.backend.dataaccess.files;

import org.mele.backend.dataaccess.DBConnection;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class ActiveResourceManager {
    static UUID idGenerator;
    String resourceId;

    public ActiveResourceManager(String resourceName, String ownerId) {
        createVariableEntry(resourceName, ownerId);
    }


    public void createVariableEntry(String resourceName, String ownerId) {


    }

    public void loadActiveResource(MultikeyResource resource) {
        List<Property> properties = resource.getProperties();
        List<String[]> resourceRows = resource.getValues();
        for (String[] value : resourceRows) {
            insertRow(properties, value);
        }
    }

    private void insertRow(List<Property> properties, String[] value) {
        for (int valIndex = 0; valIndex < properties.size(); valIndex++) {

        }
    }

    public void addEntry() {
        String statement;
    }
}
