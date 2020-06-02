package com.example.person;

public class Company {

    private String Bs, CatchPhrase, Name;

    public String getBs() {
        return Bs;
    }

    public void setBs(String bs) {
        Bs = bs;
    }

    public String getCatchPhrase() {
        return CatchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        CatchPhrase = catchPhrase;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Company(String bs, String catchPhrase, String name) {
        Bs = bs;
        CatchPhrase = catchPhrase;
        Name = name;
    }

    public Company() {}
}
