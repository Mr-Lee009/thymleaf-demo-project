package com.thymeleaf.demo.TEST;

public class Main {

  public static long LUONG_CB_HR = 1000;
  public static long LUONG_CB_DEV = 2000;
  public static long LUONG_CB_PM = 5000;
  public static long LUONG_OT_DU_AN = 1000;
  public static void main(String[] args) {

    Employee hr1 = new HR(1,LUONG_CB_HR,LUONG_OT_DU_AN,100d,100d,true,true,true);
    Employee hr2 = new HR(2,LUONG_CB_HR,LUONG_OT_DU_AN,100d,100d,false,false,true);
    Employee dev = new DEV(3,LUONG_CB_DEV,LUONG_OT_DU_AN,100d,100d,false,false,false);
    Employee pm = new PM(4,LUONG_CB_PM,LUONG_OT_DU_AN,100d,100d,false,false,false);

    System.out.printf("\nluong cua hr1 "+ hr1.tinhLuong());
    System.out.printf("\nluong cua hr2 "+ hr2.tinhLuong());

    System.out.printf("\nluong cua dev "+ dev.tinhLuong());
    System.out.printf("\nluong cua pm "+ pm.tinhLuong());
  }
}

abstract class Employee{
  public int id;
  public double luongCB;
  public double luongOT;
  public double luongGiai;
  public double luongThuong;
  public boolean OTFlag;
  public boolean GiaiFlag;
  public boolean ThuongFlag;
  public abstract double tinhLuongOT();
  public abstract double tinhLuongThuong();
  public abstract double tinhLuongGiai();

  public Employee(int id, double luongCB, double luongOT, double luongGiai, double luongThuong,
      boolean OTFlag, boolean giaiFlag, boolean thuongFlag) {
    this.id = id;
    this.luongCB = luongCB;
    this.luongOT = luongOT;
    this.luongGiai = luongGiai;
    this.luongThuong = luongThuong;
    this.OTFlag = OTFlag;
    GiaiFlag = giaiFlag;
    ThuongFlag = thuongFlag;
  }

  public double tinhLuong(){
    return this.luongCB + this.tinhLuongOT() + this.tinhLuongGiai() + this.tinhLuongThuong();
  }
}

class HR extends Employee{

  public HR(int id, double luongCB, double luongOT, double luongGiai, double luongThuong,
      boolean OTFlag, boolean giaiFlag, boolean thuongFlag) {
    super(id, luongCB, luongOT, luongGiai, luongThuong, OTFlag, giaiFlag, thuongFlag);
  }

  @Override
  public double tinhLuongOT() {
    if(this.OTFlag)
      return 0;
    return 0.1 * this.luongOT;
  }

  @Override
  public double tinhLuongThuong() {
    if(this.ThuongFlag)
      return 0;
    return 0.1 * this.luongThuong;
  }

  @Override
  public double tinhLuongGiai() {
    if(this.GiaiFlag)
      return 0;
    return 0.1 * this.luongGiai;
  }
}

class PM extends Employee{

  public PM(int id, double luongCB, double luongOT, double luongGiai, double luongThuong,
      boolean OTFlag, boolean giaiFlag, boolean thuongFlag) {
    super(id, luongCB, luongOT, luongGiai, luongThuong, OTFlag, giaiFlag, thuongFlag);
  }

  @Override
  public double tinhLuongOT() {
    if(this.OTFlag)
      return 0;
    return 0.5 * this.luongOT;
  }

  @Override
  public double tinhLuongThuong() {
    if(this.ThuongFlag)
      return 0;
    return 0.5 * this.luongThuong;
  }

  @Override
  public double tinhLuongGiai() {
    if(this.GiaiFlag)
      return 0;
    return 0.5 * this.luongGiai;
  }
}

class DEV extends Employee{
  public DEV(int id, double luongCB, double luongOT, double luongGiai, double luongThuong,
      boolean OTFlag, boolean giaiFlag, boolean thuongFlag) {
    super(id, luongCB, luongOT, luongGiai, luongThuong, OTFlag, giaiFlag, thuongFlag);
  }

  @Override
  public double tinhLuongOT() {
    if(this.OTFlag)
      return 0;
    return 0.2 * this.luongOT;
  }

  @Override
  public double tinhLuongThuong() {
    if(this.ThuongFlag)
      return 0;
    return 0.2 * this.luongThuong;
  }

  @Override
  public double tinhLuongGiai() {
    if(this.GiaiFlag)
      return 0;
    return 0.2 * this.luongGiai;
  }
}
