import static org.junit.Assert.*;
import org.junit.*;
import models.*;

public class FactoryTest {

  FoodFactory factory;
  Consumable irnBru;
  Consumable sprite;
  Consumable walkers;
  Consumable lays;


  @Before
  public void before() {
    factory = new FoodFactory();
    irnBru = factory.getFood( "Fizzy Pop" );
    sprite = factory.getFood( "Fizzy Pop" );
    lays = factory.getFood( "Crisps" );
    walkers = factory.getFood( "Crisps" );
  }

  @Test
  public void drinksAreBeingMade() {
    assertEquals( 1.00, irnBru.price(), 0.01 );
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








