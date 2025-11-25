# JUno-School-Project
This project we were asked to do in our OOP class at uni , its a fully terminal-based implementation of the classic card game UNO , written in Java.  
It follows a clean object-oriented architecture with clear separation of responsibilities, use of inheritance and polymorphism, and a multi-package project structure.  
All core logic is independent from the UI layer, making the game easy to extend and maintain.

---

## Team Members
- Kasmi Mohamed Iyad
- Zaidi Amine Abderrahmane 
- Djema Mohamed Aymen  
- Benyakoub Mohamed Amine  

---


## Class Overview

### Card (abstract)

The parent class for all card types.

Attributes:
- `color: Color`

Methods:
- `isPlayableOn(Card)` — abstract  
- `applyEffect(Game)` — abstract  
- `toString()` — base textual representation used for logging

---

### NumberCard (concrete)

Represents a standard UNO card with a number.

Playable if:
- It has the same color as the top card  
- Or it has the same number  

Effects:
- Does not affect game state (`applyEffect()` is empty)

---

### ActionCard (abstract)

Parent of Skip, Reverse, and Draw Two cards.  
An action card is playable if:
- It shares the same color as the top card, or  
- Both cards are action cards (action chaining)

Concrete subclasses:

#### SkipCard
- Skips the next player's turn (`skipNext()`)

#### ReverseCard
- Reverses the direction of play (`reverseDirection()`)

#### DrawTwoCard
- Makes the next player draw 2 cards and skips their turn

---

### WildCard (concrete)

Behavior:
- Can be played on any card  
- Prompts the player to choose a new color  
- Sets the game's current color  

#### WildDrawFour
- Makes the next player draw 4 cards  
- Skips their turn  
- Then asks for a new color  

---

## Deck

Stores the game's cards using an `ArrayList<Card>`.  
Responsibilities:
- Creating the full UNO deck of 108 cards  
- Shuffling  
- Drawing cards from the top  
- Checking if the deck is empty  

---

## Player

Represents a player in the game.

Attributes:
- `name: String`
- `hand: ArrayList<Card>`

Methods:
- `draw(Deck)`  
- `playCard(int)`  
- `hasPlayable(Card)` — checks if the player has any valid move  
- `getHandSize()` — useful for detecting UNO  

---

## Game

Coordinates the entire game flow.

Main attributes:
- `players: ArrayList<Player>`
- `deck: Deck`
- `discardPile: ArrayList<Card>`
- `current: int`
- `direction: Direction`
- `currentColor: Color`

Responsibilities:
- Initializing the game: dealing cards, setting direction and starting color  
- Handling turn rotation  
- Playing cards and applying effects  
- Managing the discard pile  
- Checking for end-of-game conditions  

Internal utility methods (used by cards):
- `skipNext()`  
- `reverseDirection()`  
- `drawCards(int)`  
- `askColor()`  
- `setCurrentColor(Color)`  

---

## Notes

- The project uses `ArrayList` for dynamic card and player management.  
- The UI package is optional and does not impact game mechanics.  
- The architecture is designed for readability and extensibility.



