package comp;

import model.Customers;

import java.util.Comparator;

public class CustomersIdComparator implements Comparator<Customers> {

    @Override
    public int compare(Customers o1, Customers o2) {

        if(o1.getIdcode()> o2.getIdcode())
            return 1;
        else if(o1.getIdcode()< o2.getIdcode())
            return -1;
        else
            return 0;
    }
}
