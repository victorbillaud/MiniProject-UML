package Model1;

import java.util.*;
import java.util.ArrayList;

/**
 * 
 */
public class Building {

    /**
     * Default constructor
     */
    public Building(Integer _id, Integer _size, Supervisor _supervisor) {
        this.ID = _id;
        this.Supervisor = _supervisor;
        GlobalMeter gM = new GlobalMeter();
        this.Appartments = new ArrayList<Appartment>(){
            {
                for (int i = 0; i < _size; i++) {
                    Appartment ap = new Appartment(_id*10 +  i);
                    add(ap);
                    gM.Meters.add(ap.Meter);
                }
            }
        };
        this.Size = _size;
        this.Occuped = 0;
        Supervisor.GlobalMeter = gM;
        Supervisor.Building = this;
    }

    /**
     * 
     */
    public Integer ID;

    /**
     * 
     */
    public Supervisor Supervisor;

    /**
     * 
     */
    public List <Appartment> Appartments;

    public Integer Size;
    public Integer Occuped;

    /**
     * 
     */
    public void AssignAppartment(Tenant _tenant, UseMode _mode) {
        for (int i = 0; i < this.Appartments.size(); i++) {
            if (!this.Appartments.get(i).Used){
                this.Occuped++;
                this.Appartments.get(i).setTenant(_tenant);
                this.Appartments.get(i).setIsUsed(true);
                this.Appartments.get(i).setMeterSettings(_mode,new Date());
                Log.newLog(_tenant.Fullname + " has been assigned to a new appartment in building " + this.ID, LogType.INFO);
                return;
            }
        }
    }


    @Override
    public String toString() {
        System.out.println("\nBUILDING "
                + ConsoleColors.GREEN_BOLD_BRIGHT + this.ID + ConsoleColors.RESET + " | "
                + ConsoleColors.WHITE + " Supervisor : "+ this.Supervisor.Fullname + ConsoleColors.RESET + " | "
                + ConsoleColors.WHITE  + this.Occuped + "/" + this.Size + ConsoleColors.RESET +  " slots | \n");
        for (int i = 0; i < this.Appartments.size(); i++) {
            System.out.println("\t" + this.Appartments.get(i));
        }
        return "";
    }
}