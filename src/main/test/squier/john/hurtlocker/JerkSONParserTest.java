package squier.john.hurtlocker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by johnsquier on 2/8/17.
 */
public class JerkSONParserTest {

    JerkSONParser parser;
    String rawData;

    @Rule
    public final ExpectedException exception =  ExpectedException.none();

    @Before
    public void setup() {
        rawData = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        parser = new JerkSONParser(rawData);
    }

    @Test
    public void splitStringByEntryDelimiterTest() {
        String[] expected = new String[28];

        expected[0]  = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        expected[1]  = "naME:BreaD;price:1.23;type:Food;expiration:1/02/2016";
        expected[2]  = "NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016";
        expected[3]  = "naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016";
        expected[4]  = "naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016";
        expected[5]  = "naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016";
        expected[6]  = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016";
        expected[7]  = "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016";
        expected[8]  = "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016";
        expected[9]  = "naMe:MilK;price:1.23;type:Food!expiration:4/25/2016";
        expected[10] = "naMe:apPles;price:0.25;type:Food;expiration:1/23/2016";
        expected[11] = "naMe:apPles;price:0.23;type:Food;expiration:5/02/2016";
        expected[12] = "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016";
        expected[13] = "naMe:;price:3.23;type:Food;expiration:1/04/2016";
        expected[14] = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        expected[15] = "naME:BreaD;price:1.23;type:Food@expiration:1/02/2016";
        expected[16] = "NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016";
        expected[17] = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016";
        expected[18] = "naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016";
        expected[19] = "naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016";
        expected[20] = "naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016";
        expected[21] = "naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016";
        expected[22] = "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016";
        expected[23] = "naMe:MilK;priCe:;type:Food;expiration:4/25/2016";
        expected[24] = "naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016";
        expected[25] = "naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016";
        expected[26] = "NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016";
        expected[27] = "naMe:;price:3.23;type:Food^expiration:1/04/2016";

        String[] actual = parser.splitStringByEntryDelimiter("##");

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void parseEntryIntoGroceryItemTestOne() {
        GroceryItem expected = new GroceryItem("milk", 3.23, "1/25/2016");

        GroceryItem actual = null;

        try {
            actual = parser.parseEntryIntoGroceryItem("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {}

        Assert.assertTrue(expected.equals(actual));
    }

    @Test
    public void parseEntryIntoGroceryItemTestTwo() {
        GroceryItem expected = new GroceryItem("bread", 1.23, "1/02/2016");

        GroceryItem actual = null;

        try {
            actual = parser.parseEntryIntoGroceryItem("naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");
        }
        catch ( StringNotValidJerkSON e ) {}

        Assert.assertTrue(expected.equals(actual));
    }

    @Test(expected = StringNotValidJerkSON.class)
    public void parseEntryIntoGroceryItemExceptionTest() throws StringNotValidJerkSON {
        parser.parseEntryIntoGroceryItem("garbage in");
    }

    @Test
    public void parseGroceryNameTestOne() {
        String expected = "milk";

        String actual = null;

        try {
            actual = parser.parseGroceryName("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseGroceryNameTestTwo() {
        String expected = "bread";

        String actual = null;

        try {
            actual = parser.parseGroceryName("naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseGroceryNameTestThree() {
        String expected = "cookies";

        String actual = null;

        try {
            actual = parser.parseGroceryName("naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseGroceryNameTestFour() {
        String expected = "cookies";

        String actual = null;

        try {
            actual = parser.parseGroceryName("naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = StringNotValidJerkSON.class)
    public void parseGroceryNameExceptionTestOne() throws StringNotValidJerkSON {
        parser.parseGroceryName("naMe:;price:3.23;type:Food;expiration:1/04/2016");
    }

    @Test(expected = StringNotValidJerkSON.class)
    public void parseGroceryNameExceptionTestTwo() throws StringNotValidJerkSON {
        parser.parseGroceryName("naMe:;price:3.23;type:Food^expiration:1/04/2016");
    }

    @Test
    public void parseItemPriceTestOne() {
        Double expected = 3.23;

        Double actual = null;

        try {
            actual = parser.parseItemPrice("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseItemPriceTestTwo() {
        Double expected = 1.23;

        Double actual = null;

        try {
            actual = parser.parseItemPrice("naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");
        }
        catch (StringNotValidJerkSON e) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseItemPriceTestThree() {
        Double expected = 2.25;

        Double actual = null;

        try {
            actual = parser.parseItemPrice("naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016");
        }
        catch (StringNotValidJerkSON e) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseItemPriceTestFour() {
        Double expected = 0.25;

        Double actual = null;

        try {
            actual = parser.parseItemPrice("naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016");
        }
        catch (StringNotValidJerkSON e) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = StringNotValidJerkSON.class)
    public void parseItemPriceTestException() throws StringNotValidJerkSON {
        parser.parseItemPrice("naMe:MilK;priCe:;type:Food;expiration:4/25/2016");
    }

    @Test
    public void parseExpirationDateTestOne() {
        String expected = "1/25/2016";
        String actual = null;

        try {
            actual = parser.parseExpirationDate("naMe:Milk;price:3.23;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseExpirationDateTestTwo() {
        String expected = "1/02/2016";
        String actual = null;

        try {
            actual = parser.parseExpirationDate("naME:BreaD;price:1.23;type:Food;expiration:1/02/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseExpirationDateTestThree() {
        String expected = "1/25/2016";
        String actual = null;

        try {
            actual = parser.parseExpirationDate("NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void parseExpirationDateTestFour() {
        String expected = "1/04/2016";
        String actual = null;

        try {
            actual = parser.parseExpirationDate("naMe:;price:3.23;type:Food^expiration:1/04/2016");
        }
        catch ( StringNotValidJerkSON e ) {

        }

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = StringNotValidJerkSON.class)
    public void parseExpirationDateTestException() throws StringNotValidJerkSON {
        parser.parseExpirationDate("garbage in");
    }
}
