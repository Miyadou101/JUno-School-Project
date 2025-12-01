package uno.model;

import uno.util.Color;
import uno.util.ActionType;

public class DrawTwoCard extends Card implements ActionCard {

    public DrawTwoCard(Color color) {
        super(color);
    }

    private final ActionType ACTION = ActionType.DRAW_TWO;   
    

     @Override
    public ActionType getAction() {
        return ACTION;
    }
           
    @Override
    public void applyEffect(Game game) {
        game.drawCards(2);
        game.skipNext();
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || 
               topCard instanceof ActionCard;
    }
    
    @Override
    public String toString() {
        return color + " DRAW TWO";
    }

}