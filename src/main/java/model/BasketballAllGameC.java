package model;

public class BasketballAllGameC extends AllGameBasketballPlayers{

    public BasketballAllGameC() {
    }

    public BasketballAllGameC(String id, String firstName, String lastName, int salary, long playerDraftKingsId, String position,
                              String team, Boolean isDisabled, double draftKingsFantasyPoints, String status) {
        super(id, firstName, lastName, salary, playerDraftKingsId, position, team, isDisabled, draftKingsFantasyPoints, status);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
