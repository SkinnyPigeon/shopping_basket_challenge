package models;

import java.util.ArrayList;
import java.util.Collections;

public class Basket {

  private ArrayList< Consumable > mItems;
  private double mTotal;

  public Basket() {
    mItems = new ArrayList< Consumable >();
    mTotal = 0;
  }

  public double total() {
    return mTotal;
  }

  public int size() {
    return mItems.size();
  }

  public void add( Consumable item ) {
    mItems.add( item );
  }


}