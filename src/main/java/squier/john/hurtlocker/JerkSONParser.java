package squier.john.hurtlocker;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by johnsquier on 2/8/17.
 */
public class JerkSONParser {

    private String toParse;
    private List<GroceryItem> groceryItemList;
    private Pattern patten;
    private Matcher matcher;

    public JerkSONParser(String toParse) {
        this.toParse = toParse;
        groceryItemList = new ArrayList<GroceryItem>();
    }

    public List<GroceryItem> parseJerkSON() {
        String[] splitByEntryDelimiter = splitStringByEntryDelimiter("##");

        GroceryItem tempGroceryItem;
        for ( int i = 0; i < splitByEntryDelimiter.length; i++ ) {
                tempGroceryItem = parseEntryIntoGroceryItem(splitByEntryDelimiter[i]);

        }

        return null;
    }

    /*default*/ String[] splitStringByEntryDelimiter(String entryDelimiter) {
        return toParse.split(entryDelimiter);
    }

    /*default*/ GroceryItem parseEntryIntoGroceryItem(String entry) {
        return null;
    }
}
