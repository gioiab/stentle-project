package com.stentle.domain.collections;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by gioiaballin on 07/11/15.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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
