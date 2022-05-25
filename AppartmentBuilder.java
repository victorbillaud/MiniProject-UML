package Model1;

import java.util.Date;

public interface AppartmentBuilder {
    void setTenant(Tenant _tenant);
    void setIsUsed(boolean _state);
    void setMeterSettings(UseMode _useMode, Date _startTime);
}
