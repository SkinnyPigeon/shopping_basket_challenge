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
    mTotal += item.price();
    mItems.add( item );
  }

  public void removeAll() {
    int size = mItems.size();
    for( int i = 0; i < size; i++ ) {
      mItems.remove(0);
    }
  }

  public void remove( Consumable item ) {
    for( int i = 0; i < mItems.size(); i++ ){
      if( item == mItems.get(i) ) {
        mItems.remove( i );
        break;
      }
    }
  }


}