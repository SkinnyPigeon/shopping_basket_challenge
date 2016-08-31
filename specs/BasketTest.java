import static org.junit.Assert.*;
import org.junit.*;
import models.*;

public class BasketTest {

  Basket basket;
  Discount discount;
  ItemFactory shelf;
  Buyable irnBru;
  Buyable irnBru2;
  Buyable sprite;
  Buyable walkers;
  Buyable lays;
  Buyable steak;


  @Before
  public void before() {
    basket = new Basket();
    shelf = new ItemFactory();
    steak = shelf.getItem( "Steak" );
    irnBru = shelf.getItem( "Irn Bru" );
    irnBru2 = shelf.getItem( "Irn Bru" );
    sprite = shelf.getItem( "Sprite" );
    lays = shelf.getItem( "Lays" );
    walkers = shelf.getItem( "Walkers" );
  }

  @Test
  public void basketStartsWithZeroTotal() {
    assertEquals( 0, basket.total(), 0.01 );
  }

  @Test
  public void basketStartsWithNoItems() {
    assertEquals( 0, basket.size() );
  }

  @Test
  public void basketCanAddConsumables() {
    basket.add( irnBru );
    assertEquals( 1, basket.size() );
  }

  @Test
  public void basketCanTotalUpGoods() {
    basket.add( sprite );
    basket.add( lays );
    assertEquals( 1.5, basket.total(), 0.01 );
  }

  @Test
  public void basketCanRemoveAllItems() {
    basket.add( sprite );
    basket.add( lays );
    basket.removeAll();
    assertEquals( 0, basket.size() );
  }

  @Test
  public void basketCanRemoveSingleItem() {
    basket.add( sprite );
    basket.add( irnBru );
    basket.remove( irnBru );
    assertEquals( 1, basket.size() );
  }

  @Test
  public void basketWillOnlyRemoveTheFirstItem() {
    basket.add( irnBru );
    basket.add( irnBru );
    basket.remove( irnBru );
    assertEquals( 1, basket.size() );
  }

  @Test
  public void quickTestToSeeThatTheTotalWillIncreaseWithMultipleOfTheSameItem() {
    basket.add( lays );
    basket.add( lays );
    assertEquals( 1, basket.total(), 0.01 );
  }

  @Test
  public void basketWillReduceInTotalWhenAllItemsAreRemoved() {
    basket.add( lays );
    basket.add( lays );
    basket.removeAll();
    assertEquals( 0, basket.total(), 0.01 );
  }

  @Test
  public void basketWillReduceInTotalWhenSingleItemIsRemoved() {
    basket.add( lays );
    basket.add( lays );
    basket.remove( lays );
    assertEquals( 0.5, basket.total(), 0.01 );
  }

  @Test
  public void bogofCanBeApplied() {
    basket.add( irnBru );
    basket.add( irnBru );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 1, discount.total(), 0.01 );
  }

  @Test
  public void bogofCanBeAppliedToObjectOutOfOrder() {
    basket.add( irnBru );
    basket.add( lays );
    basket.add( irnBru );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 1.5, discount.total(), 0.01 );
  } 

  @Test
  public void bogofWillIgnoreItemsWhichAreNotBogof() {
    basket.add( irnBru );
    basket.add( lays );
    basket.add( irnBru );
    basket.add( lays );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 2, discount.total(), 0.01 );
  }

  @Test
  public void bogofWorksWithDifferentInstancesOfItems() {
    basket.add( irnBru );
    basket.add( irnBru2 );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 1, discount.total(), 0.01 );
  }

  @Test
  public void bogofWorksAcrossDifferentItemsFromSameClass() {
    basket.add( irnBru );
    basket.add( sprite );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 1, discount.total(), 0.01 );
  }

  @Test
  public void bogofOnlyWorksForPairsOfItems() {
    basket.add( irnBru );
    basket.add( irnBru );
    basket.add( sprite );
    discount = new Discount( basket.items(), basket.total() );
    discount.bogof();
    assertEquals( 2, discount.total(), 0.01 );
  }

  @Test
  public void bulkDiscountWorksByItself() {
    basket.add( steak );
    discount = new Discount( basket.items(), basket.total() );
    discount.bulkDiscount();
    assertEquals( 22.50, discount.total(), 0.01 );
  }

  @Test
  public void bulkDiscountWorksAfterBogof() {
    basket.add( irnBru );
    basket.add( steak );
    basket.add( sprite );
    basket.bogof();
    basket.bulkDiscount();
    assertEquals( 23.40, basket.total(), 0.01 );
  }

  // @Test
  // public void customerDiscountWorksByItselfIfLoyaltyCardIsPresent() {
  //   basket.add( irnBru );
  //   basket.customerDiscount( true );
  //   assertEquals( 0.98, basket.total(), 0.01 );
  // }

  // @Test
  // public void customerCanNotUseInvalidCardForDiscount() {
  //   basket.add( irnBru );
  //   basket.customerDiscount( false );
  //   assertEquals( 1, basket.total(), 0.01 );
  // }

  // @Test
  // public void allDiscountsAndBogofWorkTogether() {
  //   basket.add( irnBru );
  //   basket.add( steak );
  //   basket.discounts( true );
  //   assertEquals( 22.93, basket.total(), 0.01 );
  // }

  // @Test
  // public void discountsStillIgnoreTheFalseDiscountCards() {
  //   basket.add( irnBru );
  //   basket.add( steak );
  //   basket.discounts( false );
  //   assertEquals( 23.4, basket.total(), 0.01 );
  // }


}









