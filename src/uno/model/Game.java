package uno.model;

import uno.util.Color;
import uno.util.Direction;

import java.util.Stack;
import java.util.Arrays;


public class Game {

    Player[] players;
    Deck deck;
    Stack<Card> discardPile = new Stack<>();

    int current ;
    Direction direction ;
    Color currentColor ;

    public Game(int current , Direction direction , Color currentColor){
        this.current = current;
        direction = CLOCK ;
        this.currentColor = currentColor;

    }

    public void start() {



    }








}