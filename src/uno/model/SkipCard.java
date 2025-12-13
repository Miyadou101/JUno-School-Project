package uno.model;

import uno.util.Color;

public class SkipCard extends Card implements ActionCard {


    public SkipCard (Color color){
        super(color);
    }

    @Override
    public void applyEffect(Game game) {
        game.skipNext();
        
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || 
               topCard instanceof SkipCard;
    }
    
    @Override
    public String toString() {
        return color + " SKIP";
    }
}


