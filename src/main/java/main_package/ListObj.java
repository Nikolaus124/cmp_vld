package main_package;

import model.DwellingIns;
import model.LifeIns;
import model.TransportIns;

import java.util.List;

public class ListObj {

    public List<TransportIns> trIns;
    public List<LifeIns> lIns;
    public List<DwellingIns> dIns;


    public List<TransportIns> getTrIns() {
        return trIns;
    }

    public void setTrIns(List<TransportIns> trIns) {
        this.trIns = trIns;
    }

    public List<LifeIns> getlIns() {
        return lIns;
    }

    public void setlIns(List<LifeIns> trIns) {
        this.lIns = trIns;
    }

    public List<DwellingIns> getdIns() {
        return dIns;
    }

    public void setdIns(List<DwellingIns> trIns) {
        this.dIns = trIns;
    }
}
