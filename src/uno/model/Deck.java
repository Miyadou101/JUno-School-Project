package uno.model;

import java.util.Stack;
import java.util.Collections;
import uno.util.Color;


public class Deck {
    private Stack<Card> cards;
    
    public Deck(){
        cards = new Stack<Card>();
    
        createDeck();
        
    }
    
    
    private void createDeck(){
        for(Color color : Color.values()){
            if (color != Color.WILD){
                cards.push(new NumberCard(color , 0));

                for (int value = 1 ; value <= 9 ;value++){
                    cards.push(new NumberCard(color , value));
                    cards.push(new NumberCard(color , value));
                }
            }

        }

        for(Color color : Color.values()){
            if (color != Color.WILD){
                
                for (int i = 0 ; i < 2 ; i++){

                    cards.push(new SkipCard(color));
                    cards.push(new ReverseCard(color));
                    cards.push(new DrawTwoCard(color));
                }
        }
    }
    
        for(int i = 0; i < 4; i++){
            cards.push(new WildCard());      
            cards.push(new WildDrawFour()); 
        }

        shuffle();
    }

    public void addCard(Card card){
        cards.push(card);
    }
    
    public void shuffle (){
        Collections.shuffle(cards);
    }

    public boolean isEmpty(){
        return cards.isEmpty();
    }

    public Card draw (){
        if (cards.isEmpty()){
            return null;
            }

        return cards.pop();
    }

    public int size() {
        return cards.size();
    }

}

