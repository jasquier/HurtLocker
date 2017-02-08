package squier.john.hurtlocker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by johnsquier on 2/8/17.
 */
public class JerkSONcliOutputterTest {

    JerkSONcliOutputer jerkSONcliOutputter;
    List<GroceryItem> groceryItemList;
    GroceryItem item1, item2, item3;

    @Before
    public void setup() {

        groceryItemList = new ArrayList<GroceryItem>();

        item1 = new GroceryItem("milk", 3.23, "1/25/2016");
        item2 = new GroceryItem("bread", 1.23, "1/02/2016");
        item3 = new GroceryItem("bread", 1.23, "2/25/2016");

        groceryItemList.add(item1);
        groceryItemList.add(item2);
        groceryItemList.add(item3);

        jerkSONcliOutputter = new JerkSONcliOutputer(groceryItemList);
    }

    @Test
    public void printGroceryListToCLIGetStringTest() {
        String expected = "name:    Milk\tseen: 1 time \n"
                        + "=============\t=============\n"
                        + "Price:   3.23\tseen: 1 time \n"
                        + "-------------\t-------------\n"
                        + "\n"
                        + "name:   Bread\tseen: 2 times\n"
                        + "=============\t=============\n"
                        + "Price:   1.23\tseen: 2 times\n"
                        + "-------------\t-------------\n"
                        + "\n"
                        + "Errors       \tseen: 0 times\n";

        String actual = jerkSONcliOutputter.printGroceryListToCLI();

        //Assert.assertEquals(expected, actual);
    }
}
