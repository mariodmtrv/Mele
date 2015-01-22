package org.mele.backend.dataaccess;

import org.mele.backend.dataaccess.files.MultikeyResource;
import org.mele.backend.dataaccess.files.Property;
import org.mele.dal.CsvMultikeyResource;
import org.mele.dal.VariableAccess;

import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class Variable {
    static UUID idGenerator;

    public void loadVariableFromFile(String variableName, String fileId, Integer ownerId) {
        CsvMultikeyResource fileResource = new CsvMultikeyResource();

        MultikeyResource resource = fileResource.getResource();

        fileResource.readFile(ownerId + File.separator + fileId);
        VariableAccess access = new VariableAccess();
        List<Property> properties = resource.getProperties();

        access.createVariable(variableName, ownerId, resource.getProperties());
        List<String[]> values = resource.getValues();
        for (String[] value : values) {
            access.addEntry(variableName, properties, value);
        }
    }
}
