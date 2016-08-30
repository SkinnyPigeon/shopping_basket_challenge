package models;

public class Crisps implements Consumable {

  private double mPrice;
  private boolean mBogof;

  public Crisps() {
    mPrice = 0.50;
    mBogof = false;
  }
 
  public double price() {
    return mPrice;
  }

  public boolean bogof() {
    return mBogof;
  }

}