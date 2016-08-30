import static org.junit.Assert.*;
import org.junit.*;
import models.*;

public class BasketTest {

  Basket basket;
  FoodFactory factory;
  Consumable irnBru;
  Consumable sprite;
  Consumable walkers;
  Consumable lays;


  @Before
  public void before() {
    basket = new Basket();
    factory = new FoodFactory();
    irnBru = factory.getFood( "Fizzy Pop" );
    sprite = factory.getFood( "Fizzy Pop" );
    lays = factory.getFood( "Crisps" );
    walkers = factory.getFood( "Crisps" );
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


}









