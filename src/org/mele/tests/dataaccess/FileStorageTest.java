package org.mele.tests.dataaccess;

import com.box.sdk.BoxAPIConnection;
import com.box.sdk.BoxFolder;
import org.junit.Test;

import java.io.*;


/**
 * Created by mariodimitrov on 2/4/15.
 */
public class FileStorageTest {
    @Test
    public void testFileStorage() {
        String API_KEY = "v8w1s1l9zspdls9906pjxj3hxowe9b4v";
        BoxAPIConnection api = new BoxAPIConnection(API_KEY);
        BoxFolder rootFolder = BoxFolder.getRootFolder(api);


        FileInputStream stream = null;
        try {

            stream = new FileInputStream("testfile.txt");

            rootFolder.uploadFile(stream, "testfile.txt");
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
