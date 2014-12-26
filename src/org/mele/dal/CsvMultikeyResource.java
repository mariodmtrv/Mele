package org.mele.dal;

import org.mele.backend.dataaccess.files.DataType;
import org.mele.backend.dataaccess.files.MultikeyResource;
import org.mele.backend.exceptions.WrongNumberOfArgumentsException;
import org.mele.backend.exceptions.WrongTypeException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by mariodimitrov on 12/26/14.
 */
public class CsvMultikeyResource {

    private MultikeyResource resource;

    public CsvMultikeyResource() {
        this.resource = new MultikeyResource();
    }

    public MultikeyResource getResource() {
        return resource;
    }

    public void readFile() {

        String csvFile = "resources/test/wine.csv";
        BufferedReader br = null;
        String line = "", propertyNamesLine = "", propertyTypesLine = "";
        String cvsSplitBy = ",";


        try {

            br = new BufferedReader(new FileReader(csvFile));
            propertyNamesLine = br.readLine();
            if (propertyNamesLine != null) {
                propertyTypesLine = br.readLine();
                if (propertyTypesLine != null) {
                    String[] propertyNames = propertyNamesLine.split(cvsSplitBy);
                    String[] propertyTypes = propertyTypesLine.split(cvsSplitBy);
                    createProperties(propertyNames, propertyTypes);
                    while ((line = br.readLine()) != null) {

                        // use comma as separator
                        String[] data = line.split(cvsSplitBy);
                        this.resource.addEntry(data);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WrongNumberOfArgumentsException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void createProperties(String[] propertyNames, String[] dataTypes) throws WrongNumberOfArgumentsException {

        if (propertyNames.length != dataTypes.length) {
            throw new WrongNumberOfArgumentsException("The property names and property types count do not match");
        }
        int propIndex = 0;
        for (String propertyName : propertyNames) {
            try {
                DataType dataType = DataType.getDataType(dataTypes[propIndex++]);
                this.resource.addProperty(propertyName, dataType);
            } catch (WrongTypeException e) {
                e.printStackTrace();
            }

        }
    }
}
