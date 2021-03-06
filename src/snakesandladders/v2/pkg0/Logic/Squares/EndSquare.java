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
public class EndSquare extends Square {

    public EndSquare() {
        super(100);
    }

    @Override
    public void applyEffect(Player player1, Player player2, Board board, SnakesAndLaddersV20 snl) {
        System.out.println("GAME FINISHED");
        snl.getHistory().append(player1.getName()+" Wins!");
        snl.setEndGameCondition(true);
        player1.setAppliedEffects(true);
    }

}
