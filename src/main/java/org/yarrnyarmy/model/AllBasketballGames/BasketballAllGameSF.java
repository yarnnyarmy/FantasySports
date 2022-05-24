package org.yarrnyarmy.model.AllBasketballGames;

import org.yarrnyarmy.model.AllBasketballGames.AllGameBasketballPlayers;

public class BasketballAllGameSF extends AllGameBasketballPlayers {

    public BasketballAllGameSF() {
    }

    public BasketballAllGameSF(String id, String firstName, String lastName, int salary, long playerDraftKingsId, String position,
                               String team, Boolean isDisabled, double draftKingsFantasyPoints, String status) {
        super(id, firstName, lastName, salary, playerDraftKingsId, position, team, isDisabled, draftKingsFantasyPoints, status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
