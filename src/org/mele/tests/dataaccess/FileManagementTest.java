package org.mele.tests.dataaccess;

import org.junit.Test;
import org.mele.dal.CsvMultikeyResource;
import org.mele.backend.dataaccess.files.MultikeyResource;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class FileManagementTest {
    @Test
    public void testReadProperties() {
        CsvMultikeyResource csvresource = new CsvMultikeyResource();
        csvresource.readFile("");
        MultikeyResource x = csvresource.getResource();
        assertEquals(x.getProperties().size(), 7);
        assertEquals(x.getValues().size(), 25);
    }
}
