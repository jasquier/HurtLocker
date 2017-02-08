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
    private Pattern pattern;
    private Matcher matcher;

    public JerkSONParser(String toParse) {
        this.toParse = toParse;
        groceryItemList = new ArrayList<GroceryItem>();
    }

    public List<GroceryItem> parseJerkSON() {
        String[] splitByEntryDelimiter = splitStringByEntryDelimiter("##");

        GroceryItem tempGroceryItem;

        for ( int i = 0; i < splitByEntryDelimiter.length; i++ ) {
            try {
                tempGroceryItem = parseEntryIntoGroceryItem(splitByEntryDelimiter[i]);
            }
            catch ( StringNotValidJerkSON e ) {

            }

        }

        return null;
    }

    /*default*/ String[] splitStringByEntryDelimiter(String entryDelimiter) {
        return toParse.split(entryDelimiter);
    }

    /*default*/ GroceryItem parseEntryIntoGroceryItem(String entry) throws StringNotValidJerkSON {
        return null;
    }

    /*default*/ String parseGroceryName(String entry) {
        pattern = Pattern.compile("\\b[aAbBcCmM]\\w+");
        matcher = pattern.matcher(entry);

        String name = null;

        if ( matcher.find() ) {
            name = matcher.group();
            name = name.toLowerCase();
        }

        if ( name != null ) {
            pattern = Pattern.compile("[Cc]..[kK][iI][eE][sS]");
            matcher = pattern.matcher(name);


            if ( matcher.find() ) {
                name = matcher.group();
            }

            return name;
        }
        else {
            System.out.println("probs with name");
            return null; // prob throw an error here
        }
    }
}
