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

        GroceryItem tempGroceryItem = null;

        for (int i = 0; i < splitByEntryDelimiter.length; i++) {
            try {
                tempGroceryItem = parseEntryIntoGroceryItem(splitByEntryDelimiter[i]);
            }
            catch ( StringNotValidJerkSON e ) {

            }

            if ( tempGroceryItem != null ) {
                groceryItemList.add(tempGroceryItem);
            }
        }

        return groceryItemList;
    }




    String[] splitStringByEntryDelimiter(String entryDelimiter) {
        return toParse.split(entryDelimiter);
    }

    GroceryItem parseEntryIntoGroceryItem(String entry) throws StringNotValidJerkSON {
        String name = parseGroceryName(entry);
        Double price = parseItemPrice(entry);
        String expirationDate = parseExpirationDate(entry);

        return new GroceryItem(name, price, expirationDate);
    }

    String parseGroceryName(String entry) throws StringNotValidJerkSON {
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
                name = "cookies";
            }

            return name;
        }
        else {
            throw new StringNotValidJerkSON();
        }
    }

    Double parseItemPrice(String entry) throws StringNotValidJerkSON {
        pattern = Pattern.compile("\\b\\d+\\.\\d+");
        matcher = pattern.matcher(entry);

        String priceAsString = null;
        Double price = null;

        if ( matcher.find() ) {
            priceAsString = matcher.group();
            price = Double.parseDouble(priceAsString);
        }

        if ( price != null ) {
            return price;
        }
        else {
            throw new StringNotValidJerkSON();
        }
    }

    String parseExpirationDate(String entry) throws StringNotValidJerkSON {
        pattern = Pattern.compile("\\d+\\/\\d+\\/\\d+");
        matcher = pattern.matcher(entry);

        String expirationDate = null;

        if ( matcher.find() ) {
            expirationDate =  matcher.group();
        }

        if ( expirationDate != null ) {
            return expirationDate;
        }
        else {
            throw new StringNotValidJerkSON();
        }
    }
}
