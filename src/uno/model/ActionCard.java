package uno.model;

import uno.util.ActionType;


public interface ActionCard {
    
   void applyEffect(Game game); 
   ActionType getAction();

}