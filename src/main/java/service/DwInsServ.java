package service;

import main_package.ListObj;
import model.Customers;
import model.DwellingIns;
import model.Employees;
import model.LifeIns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DwInsServ {
    private ListObj d;


    public ListObj getD() {
        return d;
    }

    public void setD(ListObj v) {
        this.d = v;
    }


    public List<DwellingIns> sortDInsByInsTypeWithStream() {
        return d.getdIns().stream().sorted((s1, s2) -> s1.getInstype().compareTo(s2.getInstype())).collect(Collectors.toList());
    }
    public List<DwellingIns> sortDInsByInsType() {
        List<DwellingIns> result = new ArrayList<>();
        Collections.sort(d.getdIns(), (o1, o2) -> o1.getInstype().compareTo(o2.getInstype()));
        result = d.getdIns();
        return result;
    }

    public List<DwellingIns> sortDInsByTypeDwWithStream() {
        return d.getdIns().stream().sorted((s1, s2) -> s1.getTypedw().compareTo(s2.getTypedw())).collect(Collectors.toList());
    }
    public List<DwellingIns> sortDInsByTypeDw() {
        List<DwellingIns> result = new ArrayList<>();
        Collections.sort(d.getdIns(), (o1, o2) -> o1.getTypedw().compareTo(o2.getTypedw()));
        result = d.getdIns();
        return result;
    }

    public List<DwellingIns> sortDInsBySqWithStream() {
        return d.getdIns().stream().sorted((s1, s2) -> (int) (s1.getSquare()-s2.getSquare())).collect(Collectors.toList());
    }

    public List<DwellingIns> sortDInsBySq() {
        List<DwellingIns> result = new ArrayList<>();
        Collections.sort(d.dIns, (o1, o2) -> (int) (o1.getSquare()-o2.getSquare()));
        result = d.dIns;
        return result;
    }

    public static void main(String[] args) {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464, "+38054123678", 656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749, "+38054123678");

        DwellingIns dweIns1 = new DwellingIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Квартира")
                .Square(125.05)
                .build();

        DwellingIns dweIns2 = new DwellingIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Half")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Дім")
                .Square(115.05)
                .build();

        DwellingIns dweIns3 = new DwellingIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Будинок")
                .Square(110.05)
                .build();

        List<DwellingIns> l = new ArrayList<DwellingIns>();
        l.add(dweIns1);
        l.add(dweIns2);
        l.add(dweIns3);
        //Collections.sort(l);
        for (DwellingIns p : l) {

            System.out.println(p);
        }
        ListObj dIns = new ListObj();
        dIns.setdIns(l);
        //System.out.println(trIns.trIns);
        service.DwInsServ var = new service.DwInsServ();
        var.setD(dIns);
        System.out.println(var.sortDInsByTypeDw());


    }
}
