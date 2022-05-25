package Model1;

import java.util.*;
import java.util.List;

/**
 *
 */
public class GlobalMeter  {

    /**
     * Default constructor
     */
    public GlobalMeter() {
        this.Meters = new ArrayList<IndividualMeter>();
    }


    public List <IndividualMeter> Meters;

    /**
     * 
     */
    public void ResettingAllMeters() {
        for (int i = 0; i < this.Meters.size(); i++) {
            this.Meters.get(i).Reset();
        }
    }

    /**
     * 
     */
    public Float GiveTotalConsumption() {
        Float result = Float.valueOf(0);
        for (int i = 0; i < this.Meters.size(); i++) {
            result += this.Meters.get(i).Consumption;
        }
        return result;
    }

    /**
     * 
     */
    public Float GiveConsumptionOfOne(IndividualMeter _individualMeter) {
        return this.Meters.get(this.Meters.indexOf(_individualMeter)).Consumption;
    }

    /**
     * 
     */
    public void ChangeIndividualMeterMode(IndividualMeter _individualMeter, UseMode _mode) {
        this.Meters.get(this.Meters.indexOf(_individualMeter)).UseMode = _mode;
        Log.newLog("Meter of " + _individualMeter.getTenant().Fullname + " is now on " + _individualMeter.UseMode + " mode",LogType.WARNING);
    }

    /**
     * 
     */
    public void StopIndividualMeter(IndividualMeter _individualMeter) {
        this.Meters.get(this.Meters.indexOf(_individualMeter)).IsWorking = false;
    }

    /**
     * 
     */
    public void RestartIndividualMeter(IndividualMeter _individualMeter) {
        this.Meters.get(this.Meters.indexOf(_individualMeter)).Restart();
    }

    @Override
    public String toString() {
        return "GlobalMeter{" +
                "Meters=" + Meters +
                '}';
    }
}