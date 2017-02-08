package squier.john.hurtlocker;

/**
 * Created by johnsquier on 2/8/17.
 */
public class StringNotValidJerkSON extends Exception {

    public static int numExceptionsThrown = 0;

    public StringNotValidJerkSON() {
        numExceptionsThrown++;
    }
}
