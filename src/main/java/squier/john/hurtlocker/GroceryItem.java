package squier.john.hurtlocker;

/**
 * Created by johnsquier on 2/8/17.
 */
public class GroceryItem {

    private String name;
    private double price;
    private GroceryType type;
    private String expirationDate;

    public GroceryItem(String name, double price, String expirationDate) {
        this.name = name;
        this.price = price;
        this.type = GroceryType.FOOD;
        this.expirationDate = expirationDate;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean equals(GroceryItem other) {
        if ( this.name.equals(other.name)
                && this.price == other.price
                && this.type.equals(other.type)
                && this.expirationDate.equals(other.expirationDate) ) {

            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "" + name + ":" + price + ":" + type + ":" + expirationDate;
    }
}
