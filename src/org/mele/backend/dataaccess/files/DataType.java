package org.mele.backend.dataaccess.files;

import org.mele.backend.exceptions.WrongTypeException;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public enum DataType {
    STRING("string", "VARCHAR(50)"), DATETIME("datetime", "TIMESTAMP"), INTEGER("integer", "INTEGER"), DOUBLE("double", "REAL"), BOOLEAN("boolean", "BYTEA");
    String typeName;
    String storeDatatype;

    DataType(String typeName, String storeDatatype) {
        this.typeName = typeName;
        this.storeDatatype = storeDatatype;
    }

    public String getStoreDatatype() {
        return storeDatatype;
    }

    public String getTypeName() {
        return typeName;
    }

    public static DataType getDataType(String type) throws WrongTypeException {
        String typeClear = type.trim().toLowerCase();
        switch (typeClear) {
            case "string": {
                return DataType.STRING;
            }
            case "datetime": {
                return DataType.DATETIME;

            }
            case "integer": {
                return DataType.INTEGER;
            }
            case "int": {
                return DataType.INTEGER;
            }
            case "double": {
                return DataType.DOUBLE;
            }
            case "boolean": {
                return DataType.BOOLEAN;
            }
            case "bool": {
                return DataType.BOOLEAN;
            }
            default: {
                throw new WrongTypeException("The given type is unknown");
            }
        }
    }
}
