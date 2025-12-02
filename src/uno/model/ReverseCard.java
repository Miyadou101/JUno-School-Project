package uno.model;


import uno.util.Color;

public class ReverseCard extends Card implements ActionCard {

    public ReverseCard (Color color){
        super(color);
    }
    
    @Override
    public boolean isPlayableOn(Card topCard) {
        return this.color == topCard.getColor() || topCard instanceof ReverseCard;
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