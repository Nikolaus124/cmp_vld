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

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.*;
import java.util.*;


import static org.testng.Assert.*;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class TestVal {
        @Test
        public void TestTrIns() throws IOException {
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

            ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
            Validator validator=validatorFactory.getValidator();

            Set<ConstraintViolation<TransportIns>> validate = validator.validate(trIns1);
            assertEquals(validate.size(), 0);

            validatorFactory.close();

        }

    @Test
    public void TestDwIns() throws IOException {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464,"+38054123678",656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749,"+38054123678");
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
        assertEquals(validate.size(), 0);

        validatorFactory.close();

    }

    @Test
    public void TestLifeIns() throws IOException {
        Customers cus = new Customers(1, "Peter", "Steven", "21-04-2001", 56464,"+38054123678",656454);
        Employees emp = new Employees(1, "John", "Inc", "2017-1-25", 55448749,"+38054123678");

        LifeIns lIns1 = new LifeIns.Builder()
                .idi(1)
                .sn(5854637)
                .cust(cus)
                .emp(emp)
                .instype("Half")
                .crd("20-03-2013")
                .term(1.5)
                .amount(2300)
                .Decl(2547895)
                .build();

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator=validatorFactory.getValidator();

        Set<ConstraintViolation<LifeIns>> validate = validator.validate(lIns1);
        assertEquals(validate.size(), 0);

        validatorFactory.close();
    }
}
