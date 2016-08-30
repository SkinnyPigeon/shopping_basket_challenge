package models;

public class Crisps implements Consumable {

  private double mPrice;
  private boolean mBogof;
  private String mName;

  public Crisps( String name ) {
    mName = name;
    mPrice = 0.50;
    mBogof = false;
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