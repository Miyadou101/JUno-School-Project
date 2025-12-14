package uno.model;

import uno.util.Color;

public class DrawTwoCard extends Card implements ActionCard {

    public DrawTwoCard(Color color) {
        super(color);
    }

    @Override
    public void applyEffect(Game game) {
        game.drawCards(2);
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || 
               topCard instanceof DrawTwoCard;
    }
    
    @Override
    public String toString() {
        return color + " DRAW TWO";
    }

}
