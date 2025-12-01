package uno.model;

import uno.util.Color;

public class WildCard extends Card {

    private Color chosenColor;

    public WildCard (){
        super(Color.WILD)
    }

    public boolean isPlayableOn(Card other){
        return true;

    }

    public void applyEffect(Game game){
        this.chosenColor = chooseColor(game);
        game.setCurrentColor(chosenColor);
    }

    public Color chooseColor(Game game){
        return game.askColor();
    }

    @Override
    public String toString() {
        return "WILD" + (chosenColor != null ? " (" + chosenColor + ")" : "");
    }
}