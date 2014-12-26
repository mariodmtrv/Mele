package org.mele.backend.dataaccess.files;

import org.mele.backend.exceptions.WrongNumberOfArgumentsException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class MultikeyResource {
    List<Property> properties;
    List<String[]> values;

    public MultikeyResource() {
        this.properties = new ArrayList<Property>();
        this.values = new ArrayList<String[]>();
    }

    public void addProperty(String propertyName, DataType dataType) {
        this.properties.add(new Property(propertyName, dataType));
    }

    public void addEntry(String[] value) throws WrongNumberOfArgumentsException {
        if (value.length != properties.size()) {
            throw new WrongNumberOfArgumentsException();
        }
        values.add(value);
    }
}
