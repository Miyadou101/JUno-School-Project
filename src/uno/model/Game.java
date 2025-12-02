package uno.model;

import uno.util.Color;

import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class Game {

    Player[] players;
    Deck deck;
    Stack<Card> discardPile = new Stack<>();

    int current ,next , nextIndex ;
    int direction ;
    Color currentColor ;

    Scanner scan = new Scanner(System.in);

    public Game(int current , int direction , Color currentColor){
        this.current = current;
        this.currentColor = currentColor;

    }

    public void start() {
    }
   
    public void nextTurn(){

        next = (current + direction ) % players.length;

        if (next < 0) {
            next = players.length + next;
        }

        current = next;

        if (hasPlayable(getTopCard())){

        }


    }
    
    public void playCard(Card card) {
    
    
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
        nextIndex = (current + direction )% players.length;

        nextTurn();
        nextTurn();

        current = nextIndex ;
        
    }
    
    public void reverseDirection() {
        direction *= -1 ;
    }
    
    public void drawCards(int numCardDrawn) {
        
        
    }
    
    public Color askColor() {
        
        while(true){
        
        System.out.print ("Choose a Color : RED , BLUE , GREEN , YELLOW .");
        System.out.print ("1.RED .");
        System.out.print ("2.BLUE .");
        System.out.print ("3.GREEN .");
        System.out.print ("4.YELLOW .");

        int choice = scan.nextInt();

        switch (choice) {
            case 1 : return Color.RED;
            case 2 : return Color.BLUE;
            case 3 : return Color.GREEN;
            case 4 : return Color.YELLOW;
        
            default:
                System.out.print("Wrong Choice , Please enter either 1,2,3,4");
                break;
            }        
   
        }
    }
    
    public void setCurrentColor(Color color) {
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