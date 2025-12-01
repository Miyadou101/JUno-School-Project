package uno.model;

import uno.util.Color;

public class WildDrawFour extends WildCard {

    @Override
    public void applyEffect(Game game){
        game.drawCards(4);
        game.skipNext();
    
        super.applyEffect(game);
    }




}