package Model1;

import java.security.SecureRandom;
import java.security.SecureRandomParameters;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {

        // creation of the new campus
        Campus APU = new Campus(1);

        // creation of the two use mode for individual meter
        UseMode prepay = new UseMode("pre-pay");
        UseMode postpay = new UseMode("post-pay");

        // creation of two supervisor, JEAN and LUC
        Supervisor s_jean = new Supervisor(1, "JEAN");
        Supervisor s_luc = new Supervisor(2, "LUC");

        // Assign the two supervisor in the the campus
        APU.AssignSupervisor(s_jean);
        APU.AssignSupervisor(s_luc);

        // Create two buildings with the two supervisor created above
        APU.Buildings.add(new Building(1, 5, s_jean));
        APU.Buildings.add(new Building(2, 10, s_luc));

        String students[] = {"VICTOR","ARTHUR","KARIM","IVAN","LIONEL","THOMAS"};


        // Loop for attribute at each student a new apartment
        for (int i=0; i<students.length; i++)
        {
            // create the tenant
            APU.CreateNewTenant(i,students[i]);
            // assign appartment on a building
            APU.Buildings.get(i%2).AssignAppartment(APU.Tenants.get(i), postpay);
            // top up the account of each user for the beginning
            APU.Tenants.get(i).Account.TopUp(10F);
        }


        // loop for simulate the consumption of each apartment
        for(Building building : APU.Buildings){
            for (Appartment appartment : building.Appartments){
                if(appartment.Tenant != null){
                    Random r = new Random();
                    float random = 180 + r.nextFloat() * (230 - 180);
                    appartment.Consume(random);
                }
            }
        }

        // affichage du campus
        System.out.println(APU);

        // loop for reset all meter and send the bill to the appropriate tenant
        for (Supervisor supervisor : APU.Supervisors) {
            supervisor.GlobalMeter.ResettingAllMeters();
        }

        // loop for simulate the payment of each tenant for their bills
        for (Supervisor supervisor : APU.Supervisors){
            for(Appartment appartment : supervisor.Building.Appartments){
                if(appartment.Tenant != null){
                    for (Bill bill : appartment.Tenant.Bills){
                        if(!bill.DoPayment()){
                           appartment.Meter.UseMode = prepay;
                        }
                    }
                }
            }
        }

        System.out.println(APU);
    }
}
