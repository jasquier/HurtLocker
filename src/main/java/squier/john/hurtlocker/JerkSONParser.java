package squier.john.hurtlocker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johnsquier on 2/8/17.
 */
public class JerkSONParser {

    String toParse;
    Pattern patten;
    Matcher matcher;

    public JerkSONParser(String toParse) {
        this.toParse = toParse;
    }

    public String[] splitStringByEntryDelimiter(String entryDelimiter) {
        return toParse.split(entryDelimiter);
    }

    private GroceryItem[] parseEntryIntoGroceryItem(String entry) {
        return null;
    }
}
