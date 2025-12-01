package uno.model;

import uno.util.ActionType;

public class ReverseCard implements ActionCard {

    private final ActionType ACTION = ActionType.REVERSE;
    
    @Override
    public ActionType getAction() {
        return ACTION;
    }

    @Override
    public void applyEffect(Game game) {
       game.reverseDirection(); 
    }
}