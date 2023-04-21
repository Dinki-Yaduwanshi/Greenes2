package com.example.pap;

public class dataUser {
    private String warranty;
    private String name;
    private String desc;
    private String id;
    private long bill;
    private long tgl ;
    public dataUser() {
    }

    public dataUser(String warranty, String name, String desc, String id, long bill,long tgl) {
        this.warranty = warranty;
        this.name = name;
        this.desc = desc;
        this.id = id;
        this.bill = bill;
        this.tgl=tgl;
    }

    public String getId(){
        return id;
   }
    public String getName(){
        return name;
    }

    public String getDesc(){
        return desc;
    }
    public String getWarranty(){
        return warranty;
    }

    public long getTgl() {
        return tgl;
    }

    public long getBill() {
        return bill;
    }
}
