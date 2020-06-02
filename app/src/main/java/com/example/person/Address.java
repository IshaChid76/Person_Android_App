package com.example.person;

public class Address {

    private String City, Street, Suite, Zipcode;

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getSuite() {
        return Suite;
    }

    public void setSuite(String suite) {
        Suite = suite;
    }

    public String getZipcode() {
        return Zipcode;
    }

    public void setZipcode(String zipcode) {
        Zipcode = zipcode;
    }

    public Address(String city, String street, String suite, String zipcode) {
        City = city;
        Street = street;
        Suite = suite;
        Zipcode = zipcode;
    }

    public Address() {
    }
}
