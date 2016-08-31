package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Discount {

  private ArrayList< Buyable> mItems;
  private double mTotal;

  public Discount( ArrayList<Buyable> items, double total ) {
    mItems = items;
    mTotal = total;
  }

  public void sortBasket() {
    Collections.sort( mItems, new Comparator< Buyable >() {
      @Override
      public int compare( Buyable itemOne, Buyable itemTwo ) {
        return itemOne.name().compareToIgnoreCase( itemTwo.name() );
      }
    });
  }

  public void bogof() {
    sortBasket();
    System.out.println( mItems.toString() );
    for ( int i = 0; i < mItems.size() - 1; i++ ) {

      if( ( mItems.get(i).getClass().equals( mItems.get( i + 1 ).getClass() )
        && mItems.get(i).bogof() )) 

        mTotal -= mItems.get(i).price();
      i += 1;
    }
  }

  public void bulkDiscount() {
    if( mTotal > 20 ) {
      mTotal *= 0.9;
    }
  }

  public void customerDiscount( Boolean card ) {
    if( card ) {
      mTotal *= 0.98;
    }
  }

  public void discounts( Boolean card ) {
    bogof();
    bulkDiscount();
    customerDiscount( card );
  }

  public double total() {
    return mTotal;
  } 
}