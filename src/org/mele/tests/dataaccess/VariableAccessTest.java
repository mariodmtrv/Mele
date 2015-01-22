package org.mele.tests.dataaccess;

import org.junit.Test;
import org.mele.backend.dataaccess.files.DataType;
import org.mele.backend.dataaccess.files.Property;
import org.mele.dal.VariableAccess;

import java.util.ArrayList;

/**
 * Created by mariodimitrov on 1/22/15.
 */
public class VariableAccessTest {
    @Test
    public void createVariableTest() {
        VariableAccess va = new VariableAccess();
        ArrayList<Property> x = new ArrayList<Property>();
        x.add(new Property("hello", DataType.DATETIME));
        va.createVariable("data", 434, x);
    }
}
