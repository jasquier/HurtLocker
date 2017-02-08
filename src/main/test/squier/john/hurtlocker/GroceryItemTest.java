package squier.john.hurtlocker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by johnsquier on 2/8/17.
 */
public class GroceryItemTest {

    GroceryItem item1, item2, item3, item1Repeated;

    @Before
    public void setup() {
        item1 = new GroceryItem("Milk", 3.23, "1/25/2016");
        item2 = new GroceryItem("Bread", 1.23, "1/02/2016");
        item3 = new GroceryItem("Bread", 1.23, "2/25/2016");
        item1Repeated =  new GroceryItem("Milk", 3.23, "1/25/2016");
    }

    @Test
    public void groceryItemsEqualTrue() {
        Assert.assertTrue(item1.equals(item1Repeated));
    }

    @Test
    public void groceryItemsEqualFalse() {
        Assert.assertFalse(item1.equals(item2));
    }
}
