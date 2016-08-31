package models;

public class FizzyPop implements Buyable {

  private double mPrice;
  private boolean mBogof;
  private String mName;

  public FizzyPop( String name, boolean bogof ) {
    mPrice = 1.00;
    mBogof = bogof;
    mName = name;
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