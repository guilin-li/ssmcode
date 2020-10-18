package com.lgl.domain;

public class Department {
    private Integer did;
    private String dname;

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", dname='" + dname + '\'' +
                '}';
    }

    public Department() {
    }

    public Department(String dname) {
        this.did = did;
        this.dname = dname;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
