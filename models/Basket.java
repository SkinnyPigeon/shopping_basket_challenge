package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
      mTotal = 0;
      mItems.remove(0);
    }
  }

  public void remove( Consumable item ) {
    for( int i = 0; i < mItems.size(); i++ ){
      if( item == mItems.get(i) ) {
        mTotal -= item.price();
        mItems.remove( i );
        break;
      }
    }
  }

  public void sortBasket() {
    Collections.sort(mItems, new Comparator<Consumable>() {
        @Override
        public int compare(Consumable foodOne, Consumable foodTwo) {
            return foodOne.name().compareToIgnoreCase(foodTwo.name());
        }
    });
  }

  public void bogof() {
    sortBasket();
     for ( int i = 0; i < mItems.size() - 1; i++ ) {
       if( mItems.get(i) == mItems.get( i + 1 )) {
        mTotal -= mItems.get(i).price();
        i += 1;
      }
    }
  }


}