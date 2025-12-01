package uno.model;

import uno.util.Color;

public class WildCard {

    private Color chosenColor;

    public boolean isPlayableOn(Card other){
        return true;

    }

    public void applyEffect(Game game){
        this.chosenColor = chosenColor();
        game.setCurrentColor(chosenColor);
    }

    public Color chooseColor(){
        return game.askColor();
    }


}