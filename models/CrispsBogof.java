package models;

public class CrispsBogof implements Buyable {

  private double mPrice;
  private boolean mBogof;
  private String mName;

  public CrispsBogof( String name ) {
    mName = name;
    mPrice = 0.50;
    mBogof = true;
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