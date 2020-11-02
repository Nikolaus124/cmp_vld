package service;

import main_package.ListObj;
import model.Customers;
import model.Employees;
import model.TransportIns;
import org.testng.reporters.jq.Main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import main_package.MainPr;

public class TrInsServ {
    private ListObj tr;


    public ListObj getTr() {
        return tr;
    }

    public void setTr(ListObj v) {
        this.tr = v;
    }


    public List<TransportIns> sortTrInsByInsTypeWithStream() {
        return tr.getTrIns().stream().sorted((s1, s2) -> s1.getInstype().compareTo(s2.getInstype())).collect(Collectors.toList());
    }
    public List<TransportIns> sortTrInsByInsType() {
        List<TransportIns> result = new ArrayList<>();
        Collections.sort(tr.getTrIns(), (o1, o2) -> o1.getInstype().compareTo(o2.getInstype()));
        result = tr.getTrIns();
        return result;
    }

    public List<TransportIns> sortTrInsByTypeWithStream() {
        return tr.getTrIns().stream().sorted((s1, s2) -> s1.getType().compareTo(s2.getType())).collect(Collectors.toList());
    }
    public List<TransportIns> sortTrInsByType() {
        List<TransportIns> result = new ArrayList<>();
        Collections.sort(tr.getTrIns(), (o1, o2) -> o1.getType().compareTo(o2.getType()));
        result = tr.getTrIns();
        return result;
    }

    public List<TransportIns> sortTrInsByBrandWithStream() {
        return tr.getTrIns().stream().sorted((s1, s2) -> s1.getBrand().compareTo(s2.getBrand())).collect(Collectors.toList());
    }

    public List<TransportIns> sortTrInsByBrand() {
        List<TransportIns> result = new ArrayList<>();
        Collections.sort(tr.trIns, (o1, o2) -> o1.getBrand().compareTo(o2.getBrand()));
        result = tr.trIns;
        return result;
    }

    public static void main(String[] args) {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464, "+38054123678", 656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749, "+38054123678");
        TransportIns trIns1 = new TransportIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Half")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Type("truck")
                .Fuel("Diesel")
                .Engcap(3.5)
                .Brand("KAMAZ")
                .Model("15")
                .VIN("WWAUZ354VAND")
                .build();

        TransportIns trIns2 = new TransportIns.Builder()
                .idi(1)
                .sn(111024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Type("sportcar")
                .Fuel("Diesel")
                .Engcap(3.5)
                .Brand("BMW")
                .Model("132")
                .VIN("WWAUZ354VAND")
                .build();

        TransportIns trIns3 = new TransportIns.Builder()
                .idi(1)
                .sn(145024)
                .cust(cus)
                .emp(emp)
                .instype("Half")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Type("car")
                .Fuel("Diesel")
                .Engcap(3.5)
                .Brand("Audi")
                .Model("125")
                .VIN("WWAUZ354VAND")
                .build();

        List<TransportIns> l = new ArrayList<TransportIns>();
        l.add(trIns1);
        l.add(trIns2);
        l.add(trIns3);
        //Collections.sort(l);
        for (TransportIns p : l) {

            System.out.println(p);
        }

        ListObj trIns = new ListObj();
        trIns.setTrIns(l);


        //System.out.println(trIns.trIns);

        TrInsServ var = new TrInsServ();
        var.setTr(trIns);
        System.out.println(var.sortTrInsByTypeWithStream());


    }
}
