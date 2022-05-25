package Model1;
import java.util.*;

/**
 * 
 */
public class Account {

    /**
     * Default constructor
     */
    public Account() {
        this.Amount = Float.valueOf(0);
    }

    /**
     * 
     */
    private Float Amount;


    /**
     * 
     */
    public void TopUp(Float amount) {
        this.Amount += amount;
    }

    /**
     * 
     */
    public Float GetAmount() {
        return this.Amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Amount=" + Amount +
                '}';
    }
}