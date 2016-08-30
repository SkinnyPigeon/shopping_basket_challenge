package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class Basket {

  private ArrayList< Buyable > mItems;
  private double mTotal;

  public Basket() {
    mItems = new ArrayList< Buyable >();
    mTotal = 0;
  }

  public double total() {
    double total = (double) Math.round( mTotal * 100 ) / 100;
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


}