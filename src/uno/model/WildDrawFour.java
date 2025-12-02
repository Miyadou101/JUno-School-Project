package uno.model;


public class WildDrawFour extends WildCard {

    public WildDrawFour (){
        super();
    }

    @Override
    public void applyEffect(Game game){
        game.drawCards(4);
        game.skipNext();
    
        super.applyEffect(game);
    }




}