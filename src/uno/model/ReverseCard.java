package uno.model;

import uno.util.ActionType;
import uno.util.Color;

public class ReverseCard extends Card implements ActionCard {

    private final ActionType ACTION = ActionType.REVERSE;
   
    public ReverseCard (Color color){
        super(color);
    }

    @Override
    public ActionType getAction() {
        return ACTION;
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || topCard instanceof ActionCard;
    }

    @Override
    public void applyEffect(Game game) {
       game.reverseDirection(); 
    }

    @Override
    public String toString() {
        return color + " REVERSE";
    }
}