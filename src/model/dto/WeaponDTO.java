package model.dto;

import java.io.Serializable;

public class WeaponDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private double cost;
    private String type;

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
