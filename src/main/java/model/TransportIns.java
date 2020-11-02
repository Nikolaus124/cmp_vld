package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import main_package.ListObj;
import main_package.MainPr;
import service.TrInsServ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.constraints.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = TransportIns.Builder.class)

public class TransportIns extends Insurance {

    @Pattern(regexp = "[A-z][a-z]*")
    private String type;

    @Pattern(regexp = "[A-z][a-z]*")
    private String fuel;

    @Min(0)
    @Max(12)
    private double engcap;

    @Pattern(regexp = "[A-z][a-z]*")
    private String brand;

    @Size(min=2, max=20)
    private String model;

    @Size(min = 20, max = 20)
    private String vin;

    //@Override
    //public int compareTo(TransportIns o) {
        //return type.compareTo(o.getType());
    //}

    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPOJOBuilder(withPrefix = "")
    public static class Builder extends Insurance.Builder<Builder> {

        private String type;
        private String fuel;
        private double engcap;
        private String brand;
        private String model;
        private String vin;

        public Builder() {}

        public Builder Type(String val) {
            type = val;
            return this;
        }

        public Builder Fuel(String val) {
            fuel = val;
            return this;
        }

        public Builder Engcap(double val) {
            engcap = val;
            return this;
        }

        public Builder Brand(String val) {
            brand = val;
            return this;
        }

        public Builder Model(String val) {
            model = val;
            return this;
        }

        public Builder VIN(String val) {
            vin = val;
            return this;
        }

        public TransportIns build() { return new TransportIns(this);

        }



    }

    protected TransportIns(Builder builder) {
        super(builder);
        type = builder.type;
        fuel = builder.fuel;
        engcap = builder.engcap;
        brand = builder.brand;
        model = builder.model;
        vin = builder.vin;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (getClass() != o.getClass()) {
            return false;
        }
        TransportIns e = (TransportIns) o;
        return (this == e);
    }

    @Override
    public String toString() {
        return "Type= " + this.type + "\n"
                + "Fuel= " + this.fuel + "\n"
                + "Engcap= " + this.engcap + "\n"
                + "Brand= " + this.brand + "\n"
                + "Model= " + this.model + "\n"
                + "VIN= " + this.vin + "\n";

    }

    @Override
    public int hashCode() {
        int result = type.hashCode();
        result = 31 * result + fuel.hashCode();
        result = (int)(31 * result + engcap);
        result = 31 * result + brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + vin.hashCode();
        return result;

    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public double getEngcap() {
        return engcap;
    }

    public void setEngcap(double engcap) {
        this.engcap = engcap;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }
}

