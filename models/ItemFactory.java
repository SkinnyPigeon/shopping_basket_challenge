package models;

public class ItemFactory {

  public Buyable getItem( String item ) {
    if( item == null ) {
      return null;
    }

    if( item.equalsIgnoreCase( "Lays" ) ) {
      return new Crisps( "Lays", false );
    }

    if( item.equalsIgnoreCase( "Walkers" ) ) {
      return new Crisps( "Walkers", false );
    }

    if( item.equalsIgnoreCase( "Irn Bru" ) ) {
      return new FizzyPop( "Irn Bru", true );
    }

    if( item.equalsIgnoreCase( "Sprite" ) ) {
      return new FizzyPop( "Sprite", true );
    }

    if( item.equalsIgnoreCase( "Steak" ) ) {
      return new Steak();
    }

    return null;
  }
}