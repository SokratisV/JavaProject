/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snakesandladders.v2.pkg0.Logic.Squares;

import snakesandladders.v2.pkg0.Logic.Board;
import snakesandladders.v2.pkg0.Logic.Player;
import snakesandladders.v2.pkg0.SnakesAndLaddersV20;

/**
 *
 * @author Zac
 */
public class RethrowDiceSquare extends Square {

    public RethrowDiceSquare(int number) {
        super(number);
    }

    @Override
    public void applyEffect(Player player1, Player player2, Board board, SnakesAndLaddersV20 snl) {
        
        snl.getHistory().append(player1.getName()+" stepped on a rethrow dice square");
        
        snl.getRollButton().setSelected(false);
        snl.getRollButton().setEnabled(true);
        snl.setEndTurnCondition(false);
        player1.setAppliedEffects(true);
        
    }

}
