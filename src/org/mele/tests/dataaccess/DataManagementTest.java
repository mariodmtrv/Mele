package org.mele.tests.dataaccess;

import org.junit.Test;
import org.mele.dal.CsvMultikeyResource;
import org.mele.backend.dataaccess.files.MultikeyResource;
import org.mele.dal.VariableAccess;

import static junit.framework.Assert.fail;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class DataManagementTest {
    // @Test
    public void testCreateVariable() {
        CsvMultikeyResource fileResource = new CsvMultikeyResource();
        fileResource.readFile();
        MultikeyResource resource = fileResource.getResource();
        VariableAccess access = new VariableAccess();
        access.createVariable("x", "sdfasdf34das", 1, resource.getProperties());
    }

    @Test
    public void testDeleteInactiveVariables() {
        VariableAccess access = new VariableAccess();
        access.destroyVariable("sdfasdf34das");
    }

    // @Test
    public void testCreateUserFile() {
        fail("Not implemented");
    }

    // @Test
    public void testCreateUserDir() {
        fail("Not implemented");
    }

    // @Test
    public void testGetVariableProperties() {
        fail("Not implemented");
    }

    // @Test
    public void testCreateFileTree() {
        fail("Not implemented");
    }
}
