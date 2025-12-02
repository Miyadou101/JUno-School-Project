package uno.model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }
   
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public int getHandSize() {
        return hand.size();
    }
 
    public Card getCard(int index) {
        if (index < 0 || index >= hand.size()) {
            return null;
        }
        return hand.get(index);
    }
    
    public Card draw(Deck deck) {
        Card card = deck.draw();
        if (card != null) {
            hand.add(card);
        }
        return card;
    }
    
    public Card playCard(int index) {
        if (index < 0 || index >= hand.size()) {
            return null; 
        }
        return hand.remove(index); 
    }
    
    public boolean hasPlayable(Card top) {
        for (Card card : hand) {
            if (card.isPlayableOn(top)) {
                return true;
            }
        }
        return false;
    }
   
    @Override
    public String toString() {
        return name + " (Cards: " + hand.size() + ")";
    }
}