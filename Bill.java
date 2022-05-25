package Model1;

import java.util.*;
import java.util.logging.Logger;

/**
 * 
 */
public class Bill {

    private static List<Bill> BILLS;

    public final Integer Bill_ID;
    public final Float BillAmount;
    public final Date BillDate;
    public final Tenant Tenant;
    public Boolean IsPayed;


    public static void initBills(){
        BILLS = new ArrayList<>();
    }

    private Bill(Integer _bill_id, Float _billAmount, Date _billDate, Tenant _tenant) {
        this.Bill_ID = _bill_id;
        this.BillAmount = _billAmount;
        this.BillDate = _billDate;
        this.Tenant = _tenant;
        this.IsPayed = false;
        BILLS.add(this);
        this.SubmitBill();
    }

    public static Bill newBill(Float _billAmount, Date _billDate, Tenant _tenant){
        Bill newBill = new Bill(BILLS.size() + 1, _billAmount, _billDate, _tenant);
        Log.newLog("bill number" + newBill.Bill_ID + " has been created", LogType.INFO);
        return newBill;
    }


    /**
     * 
     */
    public void SubmitBill() {
        this.Tenant.Bills.add(this);
    }

    /**
     * 
     */
    public Boolean DoPayment() {
        if(this.IsPayed){
            Log.newLog("Bill " + this.Bill_ID + " is already payed", LogType.INFO);
            return true;
        }else {
            if(this.Tenant.Account.GetAmount() < this.BillAmount){
                this.IsPayed = false;
                Log.newLog("Bill not payed", LogType.WARNING);
                return false;
            } else{
                this.Tenant.Account.TopUp(-this.BillAmount);
                this.IsPayed = true;
                Log.newLog("Bill payed " + this.Bill_ID, LogType.INFO);
                return true;
            }
        }
    }

    public Boolean CheckPayment(){
        return IsPayed;
    }

    public static List<Bill> getBills(){return BILLS;}

    @Override
    public String toString() {
        if(this.IsPayed){
            return "BILL "
                    + ConsoleColors.GREEN_BOLD_BRIGHT + this.Bill_ID + ConsoleColors.RESET + " | "
                    + ConsoleColors.WHITE + this.BillAmount + ConsoleColors.RESET + " MYR | "
                    + ConsoleColors.WHITE + this.BillDate + ConsoleColors.RESET + " | "
                    + ConsoleColors.PURPLE + this.Tenant.Fullname + ConsoleColors.RESET + " | "
                    + ConsoleColors.GREEN_BOLD+ this.IsPayed+ ConsoleColors.RESET + " | ";

        }
        return "BILL "
                + ConsoleColors.GREEN_BOLD_BRIGHT + this.Bill_ID + ConsoleColors.RESET + " | "
                + ConsoleColors.WHITE + this.BillAmount + ConsoleColors.RESET + " MYR | "
                + ConsoleColors.WHITE + this.BillDate + ConsoleColors.RESET + " | "
                + ConsoleColors.PURPLE + this.Tenant.Fullname + ConsoleColors.RESET + " | "
                + ConsoleColors.RED_BOLD+ this.IsPayed+ ConsoleColors.RESET + " | ";
    }
}