package models;

public class FizzyPop implements Consumable {

  private double mPrice;
  private boolean mBogof;

  public FizzyPop() {
    mPrice = 1.00;
    mBogof = true;
  }
 
  public double price() {
    return mPrice;
  }

  public boolean bogof() {
    return mBogof;
  }

}