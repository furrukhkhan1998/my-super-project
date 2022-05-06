package app.model;

import java.io.Serializable;

public class ComplexObject {

    String name;
    Integer id;
    Float balance;

    public ComplexObject() {
    }

    public ComplexObject(String name, Integer id, Float balance) {
        this.name = name;
        this.id = id;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}
