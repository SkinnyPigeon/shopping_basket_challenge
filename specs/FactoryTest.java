import static org.junit.Assert.*;
import org.junit.*;
import models.*;

public class FactoryTest {

  FoodFactory factory;
  Buyable irnBru;
  Buyable sprite;
  Buyable walkers;
  Buyable lays;


  @Before
  public void before() {
    factory = new FoodFactory();
    irnBru = factory.getFood( "Irn Bru" );
    sprite = factory.getFood( "Sprite" );
    lays = factory.getFood( "Lays" );
    walkers = factory.getFood( "Walkers" );
  }

  @Test
  public void foodHasName() {
    assertEquals( "Irn Bru", irnBru.name() );
  }

  @Test
  public void drinksHavePrice() {
    assertEquals( 1.00, irnBru.price(), 0.01 );
  }

  @Test
  public void crispsHavePrice() {
    assertEquals( 0.5, walkers.price(), 0.01 );
  }

  @Test
  public void crispsKnowTheyAreNotBogof() {
    assertEquals( false, lays.bogof() );
  }

  @Test
  public void drinksKnowTheyAreBogof() {
    assertEquals( true, sprite.bogof() );
  }

}








