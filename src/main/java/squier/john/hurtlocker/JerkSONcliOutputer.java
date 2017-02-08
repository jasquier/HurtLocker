package squier.john.hurtlocker;

import java.util.List;

/**
 * Created by johnsquier on 2/8/17.
 */
public class JerkSONcliOutputer {

    List<GroceryItem> groceryItemList;
    int numMilks = 0, numMilksAt3 = 0, numMilksAt1 = 0;
    int numBreads = 0;
    int numCookies = 0;
    int numApples = 0, numApplesAt25 = 0, numApplesAt23 = 0;

    public JerkSONcliOutputer(List<GroceryItem> groceryItemList) {
        this.groceryItemList =  groceryItemList;
    }

    public String printGroceryListToCLI() {
        StringBuilder sb = new StringBuilder();

        generateItemAndPriceNumbers();

        sb.append(generateMilkSection());
        sb.append(generateBreadSection());
        sb.append(generateCookiesSection());
        sb.append(generateApllesSection());
        sb.append(generateErrorSection());

        System.out.println(sb.toString());
        return sb.toString();
    }

    private void generateItemAndPriceNumbers() {
        for ( int i = 0; i < groceryItemList.size(); i++ ) {
            if ( groceryItemList.get(i).getName().equals("milk") ) {
                if ( groceryItemList.get(i).getPrice() == 3.23 ) {
                    numMilks++;
                    numMilksAt3++;
                }
                else {
                    numMilksAt1++;
                }
            }
            if ( groceryItemList.get(i).getName().equals("bread") ) {
                numBreads++;
            }
            if ( groceryItemList.get(i).getName().equals("cookies") ) {
                numCookies++;
            }
            if ( groceryItemList.get(i).getName().equals("apples") ) {
                if ( groceryItemList.get(i).getPrice() == 0.25 ) {
                    numApples++;
                    numApplesAt25++;
                }
                else {
                    numApplesAt23++;
                }
            }
        }
    }

    private String generateMilkSection() {
        StringBuilder sb = new StringBuilder();

        sb.append("name:    Milk\tseen: ").append(numMilks).append(numMilks != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("=")).append("\n");
        sb.append("Price:   3.23\tseen: ").append(numMilksAt3).append(numMilksAt3 != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("-")).append("\n");
        sb.append("Price:   1.23\tseen: ").append(numMilksAt1).append(numMilksAt1 != 1 ? " times" : " time ").append("\n");
        sb.append("\n");

        return sb.toString();
    }

    private String generateBreadSection() {
        StringBuilder sb = new StringBuilder();

        sb.append("name:   Bread\tseen: ").append(numBreads).append(numBreads != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("=")).append("\n");
        sb.append("Price:   1.23\tseen: ").append(numBreads).append(numBreads != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("-")).append("\n");
        sb.append("\n");

        return sb.toString();
    }

    private String generateCookiesSection() {
        StringBuilder sb = new StringBuilder();

        sb.append("name: Cookies\tseen: ").append(numCookies).append(numCookies != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("=")).append("\n");
        sb.append("Price:   2.25\tseen: ").append(numCookies).append(numCookies != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("-")).append("\n");
        sb.append("\n");

        return sb.toString();
    }

    private String generateApllesSection() {
        StringBuilder sb = new StringBuilder();


        sb.append("name:  Apples\tseen: ").append(numApples).append(numApples != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("=")).append("\n");
        sb.append("Price:   0.25\tseen: ").append(numApplesAt25).append(numApplesAt25 != 1 ? " times" : " time ").append("\n");
        sb.append(generateSeparationBar("-")).append("\n");
        sb.append("Price:   0.23\tseen: ").append(numApplesAt23).append(numApplesAt23!= 1 ? " times" : " time ").append("\n");
        sb.append("\n");

        return sb.toString();
    }

    private String generateErrorSection() {
        StringBuilder sb = new StringBuilder();

        sb.append("Errors       \tseen: ").append(StringNotValidJerkSON.numExceptionsThrown).append(StringNotValidJerkSON.numExceptionsThrown != 1 ? " times" : " time ").append("\n");

        return sb.toString();
    }

    private String generateSeparationBar(String separator) {
        StringBuilder sb = new StringBuilder();

        for ( int i = 0; i < 13; i++ ) {
            sb.append(separator);
        }

        sb.append("\t");

        for ( int i = 0; i < 13; i++ ) {
            sb.append(separator);
        }

        return sb.toString();
    }

}
