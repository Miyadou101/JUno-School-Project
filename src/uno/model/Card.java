package uno.model ;

import uno.util.Color;


public abstract class Card {
    
    protected final Color color ; 

    public Card (Color color){
        this.color = color;
    }

    public Color getColor () {
        return color;
    }

    public abstract boolean isPlayableOn(Card topCard);

    public abstract String toString();
}