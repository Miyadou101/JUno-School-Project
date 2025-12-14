package uno.model;

import uno.util.Color;

import java.util.Stack;
import java.util.Scanner;

public class Game {

    Player[] players;
    Deck deck;
    Stack<Card> discardPile = new Stack<>();

    int current ,next , nextIndex ;
    int direction ;
    Color currentColor ;

    private int cardsToDraw = 0;
    private boolean skipNext = false; 

    Scanner scan = new Scanner(System.in);

    public Game(int current , int direction , Color currentColor){
        this.current = current;
        this.currentColor = currentColor;

    }

    public void start() {
        
        players = new Player[4];
        players[0] = new Player("Player 1");
        players[1] = new Player("Player 2");
        players[2] = new Player("Player 3");
        players[3] = new Player("Player 4");
        
        deck = new Deck();

        for (int i = 0; i < 7; i++) {
            for (Player player : players) {
                player.draw(deck);
            }
        }
    
        Card firstCard ;
        do {
            firstCard = deck.draw();

        } while (firstCard.getColor() == Color.WILD);

        discardPile.push(firstCard);
        currentColor = firstCard.getColor();

        current = 0;
        direction =1;
    }

   
    public void nextTurn(){
        
        if (cardsToDraw>0){
            Player nextPlayer = players[(current +direction) % players.length];
            
            for(int i=0 ; i<cardsToDraw ; i++){
                reshuffleIfNeeded();
                nextPlayer.draw(deck);
            }
            
            cardsToDraw =0;
        }

        if(skipNext){
            skipNext =false;
            current = (current+direction) % players.length;
            wrapAround();
            return;
        }

        current = (current+direction) % players.length;
        wrapAround();
    }

    
    public void playCard(int cardIndex) {
        Player currentPlayer = getCurrentPlayer();
   
        Card cardToPlay = currentPlayer.getCard(cardIndex);
        Card topCard = getTopCard();
   
        if(!cardToPlay.isPlayableOn(topCard)){
            return;
        }

        Card playedCard =currentPlayer.playCard(cardIndex);
        discardPile.push(playedCard);

        if (playedCard instanceof ActionCard) {
            ((ActionCard) playedCard).applyEffect(this);
        } 
        else if (playedCard instanceof WildCard) {
            ((WildCard) playedCard).applyEffect(this);
        }

        if (playedCard.getColor() != Color.WILD) {
            currentColor = playedCard.getColor();
        }

        nextTurn();
    }
    
    public Card getTopCard() {
        return discardPile.peek();
    }
    
    public Color getCurrentColor() {
        return currentColor;
    }
    
    public Player getCurrentPlayer() {
        return players[current];    
    }
    
    public void skipNext() {
        skipNext = true;
    }
    
    public void reverseDirection() {
        direction *= -1 ;
    }
    
    public void drawCards(int numCardDrawn) {
        cardsToDraw =numCardDrawn;
        skipNext = true;
    }

    public void wrapAround() {
        while (current<0) {
            current += players.length;
        }
        current = current % players.length;
    }
    
    public Color askColor() {
        
        while(true){
        
        System.out.println("Choose a Color : RED , BLUE , GREEN , YELLOW .");
        System.out.println("1.RED .");
        System.out.println("2.BLUE .");
        System.out.println("3.GREEN .");
        System.out.println("4.YELLOW .");

        String choice= scan.nextLine().trim();;

        switch (choice) {
            case "1" : return Color.RED;
            case "2" : return Color.BLUE;
            case "3" : return Color.GREEN;
            case "4" : return Color.YELLOW;
        
            default:
                System.out.println("Wrong Choice , Please enter either 1,2,3,4");
                break;
            }        
   
        }
    }
    
    public void setCurrentColor(Color color) {
        this.currentColor=color; 
    
    }
   
    private void reshuffleIfNeeded() {
        if (deck.isEmpty() && discardPile.size() > 1) {
            Card topCard = discardPile.pop();
            while (!discardPile.isEmpty()) {
                deck.addCard(discardPile.pop());
            }
            deck.shuffle();
            discardPile.push(topCard);
        }
    }

    public boolean isOver() {
        for (Player player : players){
            if (player.getHandSize()==0){
                return true;
            }
        }
        return false;
    }   
    
    public void printState() {
    }
}
