package uno.model;

import uno.util.ActionType;


public class SkipCard implements ActionCard {

    private final ActionType ACTION = ActionType.SKIP;

    @Override
    public ActionType getAction() {
        return ACTION;
    }
    @Override
    public void applyEffect(Game game) {
        game.skipNext();
        
    }
}

