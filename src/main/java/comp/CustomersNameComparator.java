package comp;

import model.Customers;

import java.util.Comparator;

public class CustomersNameComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers o1, Customers o2) {
        return o1.getFn().compareTo(o2.getFn());
    }
}