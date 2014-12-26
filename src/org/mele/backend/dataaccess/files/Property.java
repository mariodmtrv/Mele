package org.mele.backend.dataaccess.files;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class Property {
    String name;
    DataType dataType;

    public Property(String name, DataType dataType) {
        this.name = name;
        this.dataType = dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public String getName() {
        return name;
    }

    public DataType getDataType() {
        return dataType;
    }
}
