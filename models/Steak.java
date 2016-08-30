package models;

public class Steak implements Consumable {

  private double mPrice;
  private boolean mBogof;
  private String mName;

  public Steak() {
    mPrice = 25.00;
    mBogof = false;
    mName = "Steak";
  }

  public String name() {
    return mName;
  }

  public double price() {
    return mPrice;
  }

  public boolean bogof() {
    return mBogof;
  }

}