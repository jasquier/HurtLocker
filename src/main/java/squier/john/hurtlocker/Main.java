package squier.john.hurtlocker;

import org.apache.commons.io.IOUtils;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }

    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();

        JerkSONParser parser = new JerkSONParser(output);

        List<GroceryItem> listOfGroceryItems = parser.parseJerkSON();

        JerkSONcliOutputer jerkSONcliOutputer = new JerkSONcliOutputer(listOfGroceryItems);

        jerkSONcliOutputer.printGroceryListToCLI();
    }
}
