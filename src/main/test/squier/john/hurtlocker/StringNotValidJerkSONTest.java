package squier.john.hurtlocker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by johnsquier on 2/8/17.
 */
public class StringNotValidJerkSONTest {

    StringNotValidJerkSON e1, e2, e3, e4;

    @Before
    public void setup() {
        e1 = new StringNotValidJerkSON();
        e2 = new StringNotValidJerkSON();
        e3 = new StringNotValidJerkSON();
        e4 = new StringNotValidJerkSON();
    }

    @Test
    public void doesNumberThrownCounterIncrementTest() {
        int expected = 4;

        int actual = StringNotValidJerkSON.numExceptionsThrown;

        Assert.assertEquals(expected, actual);
    }
}

