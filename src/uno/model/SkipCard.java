package uno.model;

import uno.util.ActionType;
import uno.util.Color;

public class SkipCard extends Card implements ActionCard {

    private final ActionType ACTION = ActionType.SKIP;

    public SkipCard (Color color){
        super(color);
    }

    @Override
    public ActionType getAction() {
        return ACTION;
    }
    @Override
    public void applyEffect(Game game) {
        game.skipNext();
        
    }

    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || 
               topCard instanceof ActionCard;
    }
    
    @Override
    public String toString() {
        return color + " SKIP";
    }
}

