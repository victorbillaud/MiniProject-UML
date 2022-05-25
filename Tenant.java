package Model1;

import java.util.*;

/**
 * 
 */
public class Tenant {

    /**
     * Default constructor
     */
    public Tenant(Integer _id, String _fullname) {
        this.ID = _id;
        this.Fullname = _fullname;
        this.Account = new Account();
        this.Bills = new ArrayList<Bill>();
    }

    /**
     * 
     */
    public Integer ID;

    /**
     * 
     */
    public String Fullname;


    public Account Account;

    public List<Bill> Bills;


    /**
     * 
     */
    public void PayBill(Bill _bill) {
        _bill.DoPayment();
    }


    @Override
    public String toString() {
        return "TENANT "
                + ConsoleColors.GREEN_BOLD_BRIGHT + this.ID + ConsoleColors.RESET + " | "
                + ConsoleColors.PURPLE +  this.Fullname + ConsoleColors.RESET + " | "
                + ConsoleColors.WHITE + "Money : "  + this.Account.GetAmount()+ ConsoleColors.RESET +  " MYR | ";
    }
}