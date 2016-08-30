import static org.junit.Assert.*;
import org.junit.*;
import models.*;

public class BasketTest {

  Basket basket;
  FoodFactory factory;
  Consumable irnBru;
  Consumable irnBru2;
  Consumable sprite;
  Consumable walkers;
  Consumable lays;
  Consumable steak;


  @Before
  public void before() {
    basket = new Basket();
    factory = new FoodFactory();
    steak = factory.getFood( "Steak" );
    irnBru = factory.getFood( "Irn Bru" );
    irnBru2 = factory.getFood( "Irn Bru" );
    sprite = factory.getFood( "Sprite" );
    lays = factory.getFood( "Lays" );
    walkers = factory.getFood( "Walkers" );
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
    basket.bogof();
    assertEquals( 1, basket.total(), 0.01 );
  }

  @Test
  public void bogofCanBeAppliedToObjectOutOfOrder() {
    basket.add( irnBru );
    basket.add( lays );
    basket.add( irnBru );
    basket.bogof();
    assertEquals( 1.5, basket.total(), 0.01 );
  } 

  @Test
  public void bogofWillIgnoreItemsWhichAreNotBogof() {
    basket.add( irnBru );
    basket.add( lays );
    basket.add( irnBru );
    basket.add( lays );
    basket.bogof();
    assertEquals( 2, basket.total(), 0.01 );
  }

  @Test
  public void bogofWorksWithDifferentInstancesOfItems() {
    basket.add( irnBru );
    basket.add( irnBru2 );
    basket.bogof();
    assertEquals( 1, basket.total(), 0.01 );
  }

  @Test
  public void bogofWorksAcrossDifferentItemsFromSameClass() {
    basket.add( irnBru );
    basket.add( sprite );
    basket.bogof();
    assertEquals( 1, basket.total(), 0.01 );
  }

  @Test
  public void bogofOnlyWorksForPairsOfItems() {
    basket.add( irnBru );
    basket.add( irnBru );
    basket.add( sprite );
    basket.bogof();
    assertEquals( 2, basket.total(), 0.01 );
  }

  @Test
  public void bulkDiscountWorksByItself() {
    basket.add( steak );
    basket.bulkDiscount();
    assertEquals( 22.50, basket.total(), 0.01 );
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


}









