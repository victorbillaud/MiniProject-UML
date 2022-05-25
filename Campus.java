package Model1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 */
public class Campus {

    /**
     * Default constructor
     */
    public Campus(Integer _id) {
        this.ID = _id;
        this.Buildings = new ArrayList<Building>();
        this.Supervisors = new ArrayList<Supervisor>();
        this.Tenants = new ArrayList<Tenant>();
        Bill.initBills();
    }

    /**
     * 
     */
    public Integer ID;

    /**
     * 
     */
    public List <Building> Buildings;

    /**
     * 
     */
    public List <Supervisor> Supervisors;

    /**
     * 
     */
    public List <Tenant> Tenants;




    /**
     * 
     */
    public void AssignSupervisor(Supervisor _supervisor) {
        this.Supervisors.add(_supervisor);
    }

    /**
     * 
     */
    public void InvoiceTenant(Tenant _tenant, Float _amount) {
        _tenant.Bills.add(Bill.newBill(_amount , new Date(), _tenant));
    }

    /**
     * 
     */
    public void CreateNewTenant(Integer _id, String _fullname) {
        this.Tenants.add(new Tenant(_id, _fullname));
    }

    /**
     * 
     */
    public Integer CheckCapacity() {
        Integer result = 0;
        for (int i = 0; i < this.Buildings.size(); i++) {
            for (int j = 0; j < this.Buildings.get(i).Appartments.size(); j++) {
                if(this.Buildings.get(i).Appartments.get(j).Used == false){
                    result++;
                }
            }
        }
        return result;
    }

    @Override
    public String toString() {
        System.out.println(ConsoleColors.YELLOW_BRIGHT + "\nCAMPUS " + ConsoleColors.RESET);
        System.out.println(this.Buildings);
        System.out.println("\nSUPERVISORS \n");
        for (int i = 0; i < this.Supervisors.size(); i++) {
            System.out.println("\t" +this.Supervisors.get(i));
        }
        System.out.println("\nTENANTS \n");
        for (int i = 0; i < this.Tenants.size(); i++) {
            System.out.println("\t" + this.Tenants.get(i));
        }
        System.out.println("\n");
        for (int i = 0; i < Bill.getBills().size(); i++) {
            System.out.println(Bill.getBills().get(i));
        }
        return "\n";
    }
}