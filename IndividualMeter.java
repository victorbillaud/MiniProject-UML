package Model1;

import java.util.*;

/**
 * 
 */
public class IndividualMeter {

    /**
     * Default constructor
     */
    public IndividualMeter(Integer _maxConsumption, Date _startTime, Integer _id) {
        this.ID = _id;
        this.MaxConsumption = _maxConsumption;
        this.StartTime = _startTime;
        this.Consumption = Float.valueOf(0);
        this.switchOff();
    }

    public Integer ID;
    public UseMode UseMode;
    public Integer MaxConsumption;
    public Date StartTime;
    public Float Consumption;
    public Boolean IsWorking;
    private Tenant tenant;


    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }



    /**
     *
     * @return
     */
    public Float GiveOwnConsumption() {
        return this.Consumption;
    }

    /**
     * 
     */
    public Float GiveExcess() {
        return this.Consumption - this.MaxConsumption;
    }

    /**
     * 
     */
    public Boolean CheckValidConsumption() {
        if (this.Consumption - this.MaxConsumption < 0) return true;
        else return false;
    }

    /**
     * 
     */

    public void Restart(){
        this.StartTime = new Date();
    }

    public void switchOn(){
        this.IsWorking = true;
        Log.newLog("meter " + this.ID + " is now " + ConsoleColors.GREEN + "ON" + ConsoleColors.RESET, LogType.INFO);
    }

    public void switchOff(){
        this.IsWorking = false;
        Log.newLog( "meter " + this.ID + " is now " + ConsoleColors.RED + "OFF" + ConsoleColors.RESET, LogType.INFO);
    }

    public void Reset(){
        if(this.Consumption - this.MaxConsumption > 0){
            Bill.newBill((this.Consumption-this.MaxConsumption)*0.50F,new Date(),this.tenant);
        }
        this.Consumption = Float.valueOf(0);
    }

    @Override
    public String toString() {
        return "\n\t\t\tIndividualMeter{" +
                "UseMode=" + UseMode +
                ", MaxConsumption=" + MaxConsumption +
                ", StartTime=" + StartTime +
                ", Consumption=" + Consumption +
                ", IsWorking=" + IsWorking +
                '}';
    }
}