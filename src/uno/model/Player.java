package uno.model;

import java.util.ArrayList;


public class Player {
private String name;
private Card[] hand;
private static final int max = 20;
public Player (String name,Card[] hand){
this.name = name;
this.hand = new Card[max];
}
private int firstEmptyIndex() {
for (int i = 0; i < max; i++) {
if (hand[i] == null) return i;
}
return -1;
}
public Card draw(Deck deck) {
int index = firstEmptyIndex();
if (index == -1) return null;
Card c = deck.draw();
if (c != null) {
hand[index] = c;
}
return c;
}
public Card playCard(int index) {
if (index < 0 || index >= max || hand[index] == null)
return null;
Card played = hand[index];int i = index;
while (i < max - 1 && hand[i] != null) {
hand[i] = hand[i + 1];
i++;
}
hand[max - 1] = null;
return played;
}
public boolean hasPlayable(Card top) {
int i = 0;
while (i < max && hand[i] != null) {
Card c = hand[i];
if (c.isPlayableOn(top)) {
return true;
}
i++;
}
return false;
}
public int getHandSize() {
int size = 0;
while (size < max && hand[size] != null) {
size++;
}
return size;
}
@Override
public String toString() {
return "Player{" + "name=" + name + ", hand=" + hand + '}';
}
}