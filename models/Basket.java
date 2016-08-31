package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Basket extends Discount{

  private ArrayList< Buyable > mItems;
  private double mTotal;

  public Basket() {
    mItems = new ArrayList< Buyable >();
    mTotal = 0;
  }

  public double total() {
    double total = ( double ) Math.round( mTotal * 100 ) / 100;
    return total;
  }

  public int size() {
    return mItems.size();
  }

  public void add( Buyable item ) {
    mTotal += item.price();
    mItems.add( item );
  }

  public void removeAll() {
    int size = mItems.size();
    for( int i = 0; i < size; i++ ) {
      mTotal = 0;
      mItems.remove(0);
    }
  }

  public void remove( Buyable item ) {
    for( int i = 0; i < mItems.size(); i++ ){
      if( item == mItems.get(i) ) {
        mTotal -= item.price();
        mItems.remove( i );
        break;
      }
    }
  }



}