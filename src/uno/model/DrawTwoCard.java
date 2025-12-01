package uno.model;

import uno.util.ActionType;

public class DrawTwoCard implements ActionCard {

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
}