package uno.model;

import uno.util.Color;

public class NumberCard extends Card  {

    private int value ;

    public NumberCard (Color color ,int value){
        super(color);
        this.value = value;

    }

    public int getValue() {
        return value;
    }


    @Override
    public boolean isPlayableOn(Card topCard) {
        if (this.color == topCard.getColor()){
            return true;
        }

        if (topCard instanceof NumberCard){
            NumberCard otherNumberCard = (NumberCard) topCard ;
            return this.value == otherNumberCard.value;
        }
        return false;
    }


    @Override
    public String toString() {
        return color + " " + value;
    }

}





