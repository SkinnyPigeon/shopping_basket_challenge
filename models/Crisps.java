package models;

public class Crisps implements Buyable {

  private double mPrice;
  private boolean mBogof;
  private String mName;

  public Crisps( String name, boolean bogof ) {
    mName = name;
    mPrice = 0.50;
    mBogof = bogof;
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