package com.stentle.domain.collections;

/**
 * Created by gioiaballin on 07/11/15.
 */
public class Education {

    private EducationItem master;
    private EducationItem phd;

    public void setMaster(EducationItem master) {
        this.master = master;
    }

    public EducationItem getMaster() {
        return master;
    }

    public void setPhd(EducationItem phd) {
        this.phd = phd;
    }

    public EducationItem getPhd() {
        return phd;
    }

}
