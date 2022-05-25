package Model1;
import java.util.*;

public class Appartment implements AppartmentBuilder {

    public Appartment(Integer _id) {
        this.Used = false;
        this.ID = _id;
        this.Meter = new IndividualMeter(200,new Date(), this.ID);
    }

    public Integer ID;
    public Tenant Tenant;
    public IndividualMeter Meter;
    public Boolean Used;


    public void Consume(Float consomation){
        if(this.Meter.IsWorking){
            this.Meter.Consumption += consomation;
            if (this.Meter.Consumption > 1000){
                Log.newLog("Meter "+this.ID + ", of " + this.Tenant.Fullname + " exceed consumption of 1000 "
                        + ", he need to be shot down", LogType.ERROR);
                this.Meter.switchOff();
            }
            else if(this.Meter.Consumption > this.Meter.MaxConsumption){
                Log.newLog("Meter "+this.ID + ", of " + this.Tenant.Fullname + " is now on excessive consumption  "
                        + ConsoleColors.RED + this.Meter.Consumption
                        + ConsoleColors.RESET +  " (+"
                        + ConsoleColors.BLUE + consomation
                        + ConsoleColors.RESET +")"
                        + ConsoleColors.RESET + " Kwh", LogType.WARNING);

            }else{
                Log.newLog("Meter "+this.ID + ", of " + this.Tenant.Fullname + " have now a consumption of "
                        + ConsoleColors.CYAN + this.Meter.Consumption
                        + ConsoleColors.RESET +  " (+"
                        + ConsoleColors.BLUE + consomation
                        + ConsoleColors.RESET +")"
                        + ConsoleColors.RESET + " Kwh", LogType.INFO);
            }
        }else{
            Log.newLog("Meter "+this.ID + ", of" + this.Tenant.Fullname +" is switched off", LogType.ERROR);
        }
    }

    @Override
    public void setTenant(Tenant _tenant) {
        this.Tenant = _tenant;
        this.Meter.setTenant(_tenant);
    }

    @Override
    public void setIsUsed(boolean _state) {
        this.Used = _state;
    }

    @Override
    public void setMeterSettings(UseMode _useMode, Date _startTime) {
        this.Meter.UseMode = _useMode;
        this.Meter.StartTime = _startTime;
        this.Meter.switchOn();
    }

    @Override
    public String toString() {
        if (this.Tenant != null ){
            return "APARTMENT "
                    + ConsoleColors.GREEN_BOLD_BRIGHT + this.ID + ConsoleColors.RESET + " | "
                    + ConsoleColors.WHITE + " Actual consumption : "+ this.Meter.Consumption + ConsoleColors.RESET + " Kwh " + this.Meter.UseMode
                    + ConsoleColors.WHITE  + " Actual period : "+ this.Meter.StartTime + ConsoleColors.RESET + " | "
                    + ConsoleColors.PURPLE + this.Tenant.Fullname + ConsoleColors.RESET + " | " + ConsoleColors.RESET ;

        }else{
            return "APARTMENT "
                    + ConsoleColors.GREEN_BOLD_BRIGHT + this.ID + ConsoleColors.RESET + " | "
                    + ConsoleColors.WHITE + "Empty apartment" + ConsoleColors.RESET ;

        }
       }
}