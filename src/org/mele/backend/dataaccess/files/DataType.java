package org.mele.backend.dataaccess.files;

import org.mele.backend.exceptions.WrongTypeException;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public enum DataType {
    STRING("string"), DATETIME("datetime"), INTEGER("integer"), DOUBLE("double"), BOOLEAN("boolean");
    String typeName;

    DataType(String typeName) {
        this.typeName = typeName;
    }

    String getTypeName() {
        return typeName;
    }

    static DataType getDataType(String type) throws WrongTypeException {
        switch (type.toLowerCase()) {
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
