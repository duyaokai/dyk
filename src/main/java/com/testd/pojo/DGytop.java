package com.testd.pojo;


public class DGytop {

  private Integer id;
  private String times;
  private Integer money;
  private double shangzhang;

  @Override
  public String toString() {
    return "DGytop{" +
            "id=" + id +
            ", times='" + times + '\'' +
            ", money=" + money +
            ", shangzhang=" + shangzhang +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTimes() {
    return times;
  }

  public void setTimes(String times) {
    this.times = times;
  }

  public Integer getMoney() {
    return money;
  }

  public void setMoney(Integer money) {
    this.money = money;
  }

  public double getShangzhang() {
    return shangzhang;
  }

  public void setShangzhang(double shangzhang) {
    this.shangzhang = shangzhang;
  }
}
