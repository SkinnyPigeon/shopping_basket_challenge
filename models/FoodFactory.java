package models;

public class FoodFactory {

  public Consumable getFood( String foodStuff ) {
    if( foodStuff == null ) {
      return null;
    }

    if( foodStuff.equalsIgnoreCase( "Lays" ) ) {
      return new Crisps( "Lays" );
    }

    if( foodStuff.equalsIgnoreCase( "Walkers" ) ) {
      return new Crisps( "Walkers" );
    }

    if( foodStuff.equalsIgnoreCase( "Irn Bru" ) ) {
      return new FizzyPop( "Irn Bru" );
    }

    if( foodStuff.equalsIgnoreCase( "Sprite" ) ) {
      return new FizzyPop( "Sprite" );
    }

    return null;
  }
}