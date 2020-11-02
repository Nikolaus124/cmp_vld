package test;


import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import comp.CustomersIdComparator;
import comp.CustomersNameComparator;
import main_package.ListObj;
import model.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.testng.annotations.AfterTest;
import service.TrInsServ;

import java.io.*;
import java.util.*;


import static org.testng.Assert.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


public class TestComp {
    @Test
    public void testComparatorCustomers() throws IOException {

        Comparator<Customers> pcomp = new CustomersNameComparator().thenComparing(new CustomersIdComparator());
        TreeSet<Customers> people = new TreeSet(pcomp);
        people.add(new Customers(1, "John", "Washington", "21-04-2001", 56464,"+38054123678",656454));
        people.add(new Customers(1, "Steven", "Jonson", "21-04-2001", 47532,"+38054123678",656454));
        people.add(new Customers(1, "John", "Smith", "21-04-2001", 65464,"+38054123678",656454));
        people.add(new Customers(1, "Anna", "Trump", "21-04-2001", 024132,"+38054123678",656454));
        people.add(new Customers(1, "Frank", "Trump", "21-04-2001", 521032,"+38054123678",656454));
        Customers p = people.first();
        assertTrue(p.getFn() == "Anna");

    }

    @Test
    public void testComparableEmployees() throws IOException {
    TreeSet<Employees> people = new TreeSet<Employees>();
        people.add(new Employees(1, "John", "Jonson", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(2, "Steven", "Washington", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(3, "Anna", "Smith", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(4, "Frank", "Trump", "2017-1-25", 55448749,"+38054123678"));
        Employees p = people.first();
        assertTrue(p.getFn() == "Anna");

    }

    @Test
    public void testServFuncForTrIns() throws IOException {
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

        List<TransportIns> lC = new ArrayList<TransportIns>();
        lC.add(trIns2);
        lC.add(trIns1);
        lC.add(trIns3);

        ListObj trIns = new ListObj();
        trIns.setTrIns(l);

        TrInsServ var = new TrInsServ();
        var.setTr(trIns);
        l = var.sortTrInsByInsType();
        assertEquals(l, lC);
    }

    @Test
    public void testServFuncForTrInsWithStrAPI() throws IOException {
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

        List<TransportIns> lC = new ArrayList<TransportIns>();
        lC.add(trIns3);
        lC.add(trIns2);
        lC.add(trIns1);

        ListObj trIns = new ListObj();
        trIns.setTrIns(l);

        TrInsServ var = new TrInsServ();
        var.setTr(trIns);
        l = var.sortTrInsByTypeWithStream();
        assertEquals(l, lC);
    }

    @Test
    public void testServFuncForLifeIns() throws IOException {
    Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464, "+38054123678", 656454);
    Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749, "+38054123678");

    LifeIns lifeIns1 = new LifeIns.Builder()
            .idi(1)
            .sn(136024)
            .cust(cus)
            .emp(emp)
            .instype("Full")
            .crd("20-03-2013")
            .term(1.5)
            .amount(2300)
            .Decl(13)
            .build();

    LifeIns lifeIns2 = new LifeIns.Builder()
            .idi(1)
            .sn(156024)
            .cust(cus)
            .emp(emp)
            .instype("Full")
            .crd("20-03-2013")
            .term(1.5)
            .amount(2300)
            .Decl(42)
            .build();

    LifeIns lifeIns3 = new LifeIns.Builder()
            .idi(1)
            .sn(116024)
            .cust(cus)
            .emp(emp)
            .instype("Full")
            .crd("20-03-2013")
            .term(1.5)
            .amount(2300)
            .Decl(10)
            .build();

    List<LifeIns> l = new ArrayList<LifeIns>();
            l.add(lifeIns1);
            l.add(lifeIns2);
            l.add(lifeIns3);
    List<LifeIns> lC = new ArrayList<LifeIns>();
        lC.add(lifeIns3);
        lC.add(lifeIns1);
        lC.add(lifeIns2);
    ListObj lIns = new ListObj();
    lIns.setlIns(l);

    service.LinsServ var = new service.LinsServ();
    var.setL(lIns);
    l = var.sortLInsByDecl();
    assertEquals(l, lC);
    }

    @Test
    public void testServFuncForLifeInsWithStrAPI() throws IOException {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464, "+38054123678", 656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749, "+38054123678");

        LifeIns lifeIns1 = new LifeIns.Builder()
                .idi(1)
                .sn(136024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Decl(13)
                .build();

        LifeIns lifeIns2 = new LifeIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Decl(42)
                .build();

        LifeIns lifeIns3 = new LifeIns.Builder()
                .idi(1)
                .sn(116024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Decl(10)
                .build();

        List<LifeIns> l = new ArrayList<LifeIns>();
        l.add(lifeIns1);
        l.add(lifeIns2);
        l.add(lifeIns3);

        List<LifeIns> lC = new ArrayList<LifeIns>();
        lC.add(lifeIns3);
        lC.add(lifeIns1);
        lC.add(lifeIns2);

        ListObj lIns = new ListObj();
        lIns.setlIns(l);

        service.LinsServ var = new service.LinsServ();
        var.setL(lIns);
        l = var.sortLInsByDeclWithStream();
        assertEquals(l, lC);
    }

    @Test
    public void testServFuncForDwellingIns() throws IOException {
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

    List<DwellingIns> lC = new ArrayList<DwellingIns>();
        lC.add(dweIns1);
        lC.add(dweIns3);
        lC.add(dweIns2);

    ListObj dIns = new ListObj();
        dIns.setdIns(l);

    service.DwInsServ var = new service.DwInsServ();
        var.setD(dIns);
        l = var.sortDInsByTypeDw();
    assertEquals(l, lC);
    }

    @Test
    public void testServFuncForDwellingInsWithStrAPI() throws IOException {
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

        List<DwellingIns> lC = new ArrayList<DwellingIns>();
        lC.add(dweIns1);
        lC.add(dweIns3);
        lC.add(dweIns2);

        ListObj dIns = new ListObj();
        dIns.setdIns(l);

        service.DwInsServ var = new service.DwInsServ();
        var.setD(dIns);
        l = var.sortDInsByTypeDwWithStream();
        assertEquals(l, lC);
    }

}
