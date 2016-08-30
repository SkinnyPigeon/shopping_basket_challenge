package models;

public class FoodFactory {

  public Consumable getFood( String foodStuff ) {
    if( foodStuff == null ) {
      return null;
    }

    if( foodStuff.equalsIgnoreCase( "Crisps" ) ) {
      return new Crisps();
    }

    if( foodStuff.equalsIgnoreCase( "Fizzy Pop" ) ) {
      return new FizzyPop();
    }

    return null;
  }
}