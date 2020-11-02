package service;

import main_package.ListObj;
import model.Customers;
import model.Employees;
import model.LifeIns;
import model.TransportIns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import main_package.MainPr;

public class LinsServ {

        private ListObj l;


        public ListObj getL() {
            return l;
        }

        public void setL(ListObj v) {
            this.l = v;
        }


        public List<LifeIns> sortLInsByInsTypeWithStream() {
            return l.getlIns().stream().sorted((s1, s2) -> s1.getInstype().compareTo(s2.getInstype())).collect(Collectors.toList());
        }
        public List<LifeIns> sortLInsByInsType() {
            List<LifeIns> result = new ArrayList<>();
            Collections.sort(l.getlIns(), (o1, o2) -> o1.getInstype().compareTo(o2.getInstype()));
            result = l.getlIns();
            return result;
        }

        public List<LifeIns> sortLInsBySnWithStream() {
            return l.getlIns().stream().sorted((s1, s2) -> s1.getSn()-s2.getSn()).collect(Collectors.toList());
        }
        public List<LifeIns> sortLInsBySn() {
            List<LifeIns> result = new ArrayList<>();
            Collections.sort(l.getlIns(), (o1, o2) -> o1.getSn() - o2.getSn());
            result = l.getlIns();
            return result;
        }

        public List<LifeIns> sortLInsByDeclWithStream() {
            return l.getlIns().stream().sorted((s1, s2) -> s1.getDecl()-s2.getDecl()).collect(Collectors.toList());
        }

        public List<LifeIns> sortLInsByDecl() {
            List<LifeIns> result = new ArrayList<>();
            Collections.sort(l.lIns, (o1, o2) -> o1.getDecl()-o2.getDecl());
            result = l.lIns;
            return result;
        }

        public static void main(String[] args) {
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
            //Collections.sort(l);
            for (LifeIns p : l) {

                System.out.println(p);
            }

            ListObj lIns = new ListObj();
            lIns.setlIns(l);


            //System.out.println(trIns.trIns);

            service.LinsServ var = new service.LinsServ();
            var.setL(lIns);
            System.out.println(var.sortLInsByDecl());


        }
}


