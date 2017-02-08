package squier.john.hurtlocker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johnsquier on 2/8/17.
 */
public class Parser {

    String toParse;
    Pattern patter;
    Matcher matcher;

    public Parser(String toParse) {
        this.toParse = toParse;
    }
}
