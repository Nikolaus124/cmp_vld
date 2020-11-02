package main_package;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import comp.CustomersIdComparator;
import comp.CustomersNameComparator;
import model.*;
import serialize.*;
import service.TrInsServ;

import javax.validation.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.util.*;

import static org.testng.Assert.assertEquals;

public class MainPr {



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464,"+38054123678",656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749,"+38054123678");
        TransportIns trIns1 = new TransportIns.Builder()
                .idi(1)
                .sn(5854637)
                .cust(cus)
                .emp(emp)
                .instype("Half")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Type("Truck")
                .Fuel("Diesel")
                .Engcap(3.5)
                .Brand("Kamaz")
                .Model("125")
                .VIN("WWAUZ354VANDFR09K8O4")
                .build();

/*

        System.out.println(trIns1);
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        Set<ConstraintViolation<TransportIns>> validate = validator.validate(trIns1);
        if(validate.size()>0){
            System.out.println("Error");
        }
        for(ConstraintViolation<TransportIns> violation: validate){
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }


        validatorFactory.close();


        DwellingIns dweIns1 = new DwellingIns.Builder()
                .idi(1)
                .sn(1560240)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Apartment")
                .Square(125)
                .build();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        Set<ConstraintViolation<DwellingIns>> validate = validator.validate(dweIns1);
        for(ConstraintViolation<DwellingIns> violation: validate){
            System.out.println(violation.getMessage());
            System.out.println(violation.getInvalidValue());
        }

        validatorFactory.close();


 */
/*
        DwellingIns dweIns1 = new DwellingIns.Builder()
                .idi(1)
                .sn(156024)
                .cust(cus)
                .emp(emp)
                .instype("Full")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Typedw("Apartment")
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
                .Typedw("House")
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
                .Typedw("House")
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

 */

/*
        Comparator<Customers> pcomp = new CustomersNameComparator().thenComparing(new CustomersIdComparator());
        TreeSet<Customers> people = new TreeSet(pcomp);
        people.add(new Customers(1, "John", "Washington", "21-04-2001", 56464,"+38054123678",656454));
        people.add(new Customers(1, "Steven", "Jonson", "21-04-2001", 47532,"+38054123678",656454));
        people.add(new Customers(1, "John", "Smith", "21-04-2001", 65464,"+38054123678",656454));
        people.add(new Customers(1, "Anna", "Trump", "21-04-2001", 024132,"+38054123678",656454));
        people.add(new Customers(1, "Frank", "Trump", "21-04-2001", 521032,"+38054123678",656454));
        for(Customers  p : people){

            System.out.println(p.getFn() + " " + p.getIdcode());
        }
*/

/*
        TreeSet<Employees> people = new TreeSet<Employees>();
        people.add(new Employees(1, "John", "Jonson", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(2, "Steven", "Washington", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(3, "Anna", "Smith", "2017-1-25", 55448749,"+38054123678"));
        people.add(new Employees(4, "Frank", "Trump", "2017-1-25", 55448749,"+38054123678"));

        for(Employees  p : people){

            System.out.println(p.getFn());
        }

*/

/*

        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ Customers

        JsonSerializer serj = new JsonSerializer<>(Customers.class);
        serj.toFile(cus, new File("files/cust.json"));
        Customers ins1 = (Customers) serj.fromFile(new File("src/cust.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(Customers.class);
        serx.toFile(cus, new File("files/cust.xml"));
        System.out.println(serx.toString(cus));
        Customers ins = (Customers) serx.fromFile(new File("src/cust.xml"));
        System.out.println(ins);


        CustSerTxt serc = new CustSerTxt(Customers.class);
        serc.toFile(cus, new File("files/cust.txt"));
        Customers desCus = (Customers) serc.fromFile(new File("src/cust.txt"));
        System.out.println(desCus.getFn());
        System.out.println(desCus.getLn());




        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ Employees

        JsonSerializer serj = new JsonSerializer<>(Employees.class);
        serj.toFile(emp, new File("files/emp.json"));
        Employees desEmpj = (Employees) serj.fromFile(new File("src/emp.json"));
        System.out.println(desEmpj);


        XmlSerializer serx = new XmlSerializer<>(Employees.class);
        serx.toFile(emp, new File("files/emp.xml"));
        Employees desEmpx = (Employees) serx.fromFile(new File("src/emp.xml"));
        System.out.println(desEmpx);


        EmSerTxt sert = new EmSerTxt(Employees.class);
        sert.toFile(emp, new File("files/emp.txt"));
        Employees desEmpt = (Employees) sert.fromFile(new File("src/emp.txt"));
        System.out.println(desEmpt);




        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ TransportIns

        JsonSerializer serj = new JsonSerializer(TransportIns.class);
        serj.toFile(trIns, new File("files/trins.json"));
        TransportIns ins1 = (TransportIns) serj.fromFile(new File("src/trins.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(TransportIns.class);
        serx.toFile(trIns, new File("files/trins.xml"));
        TransportIns desEmpx = (TransportIns) serx.fromFile(new File("src/trins.xml"));
        System.out.println(desEmpx);


        TrInsSerTxt ser = new TrInsSerTxt(TransportIns.class);
        ser.toFile(trIns, new File("files/trins.txt"));
        TransportIns desIns = (TransportIns) ser.fromFile(new File("src/trins.txt"));
        System.out.println(desIns);



        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ LifeIns

        JsonSerializer serj = new JsonSerializer(LifeIns.class);
        serj.toFile(lifeIns, new File("files/ls.json"));
        LifeIns ins1 = (LifeIns) serj.fromFile(new File("src/ls.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(LifeIns.class);
        serx.toFile(lifeIns, new File("files/ls.xml"));
        LifeIns desEmpx = (LifeIns) serx.fromFile(new File("src/ls.xml"));
        System.out.println(desEmpx);


        LifeInsTxt serLins = new LifeInsTxt(LifeIns.class);
        serLins.toFile(lifeIns, new File("files/ls.txt"));
        LifeIns desL = (LifeIns) serLins.fromFile(new File("src/ls.txt"));
        System.out.println(desL);



        //СЕРІАЛІЗАЦІЯ/ДЕСЕРІАЛІЗАЦІЯ КЛАСУ DwellingIns

        JsonSerializer serj = new JsonSerializer(DwellingIns.class);
        serj.toFile(dweIns, new File("files/ds.json"));
        DwellingIns ins1 = (DwellingIns) serj.fromFile(new File("src/ds.json"));
        System.out.println(ins1);


        XmlSerializer serx = new XmlSerializer<>(DwellingIns.class);
        serx.toFile(dweIns, new File("files/ds.xml"));
        DwellingIns desEmpx = (DwellingIns) serx.fromFile(new File("src/ds.xml"));
        System.out.println(desEmpx);


        DwellingInsTxt serDins = new DwellingInsTxt(DwellingIns.class);
        serDins.toFile(dweIns, new File("files/ds.txt"));
        DwellingIns desD = (DwellingIns) serDins.fromFile(new File("src/ds.txt"));
        System.out.println(desD);

        */



    }


}
