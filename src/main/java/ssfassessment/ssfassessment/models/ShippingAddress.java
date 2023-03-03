package ssfassessment.ssfassessment.models;

import jakarta.validation.constraints.NotBlank;

public class ShippingAddress {
    

    @NotBlank(message = "Please input name!")
    private String name;

    @NotBlank(message = "Please input Address!")
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Delivery [name=" + name + ", address=" + address + "]";
    }


    

}
