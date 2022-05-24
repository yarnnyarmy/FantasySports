package org.yarrnyarmy.model.AllBasketballGames;

public class AllGameBasketballPlayers {

    private String id;
    private String firstName;
    private String lastName;
    private int salary;
    private long playerDraftKingsId;
    private String position;
    private String team;
    private Boolean isDisabled;
    private double draftKingsFantasyPoints;
    private String status;
    //Constructors
    public AllGameBasketballPlayers() {
    }

    public AllGameBasketballPlayers(String id, String firstName,
                                    String lastName, int salary, long playerDraftKingsId,
                                    String position, String team, Boolean isDisabled,
                                    double draftKingsFantasyPoints, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.playerDraftKingsId = playerDraftKingsId;
        this.position = position;
        this.team = team;
        this.isDisabled = isDisabled;
        this.draftKingsFantasyPoints = draftKingsFantasyPoints;
        this.status = status;
    }

    //Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public long getPlayerDraftKingsId() {
        return playerDraftKingsId;
    }

    public void setPlayerDraftKingsId(long playerDraftKingsId) {
        this.playerDraftKingsId = playerDraftKingsId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Boolean getDisabled() {
        return isDisabled;
    }

    public void setDisabled(Boolean disabled) {
        isDisabled = disabled;
    }

    public double getDraftKingsFantasyPoints() {
        return draftKingsFantasyPoints;
    }

    public void setDraftKingsFantasyPoints(double draftKingsFantasyPoints) {
        this.draftKingsFantasyPoints = draftKingsFantasyPoints;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    //toString
    @Override
    public String toString() {
        return "AllGameFootballPlayers{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                ", playerDraftKingsId=" + playerDraftKingsId +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", isDisabled=" + isDisabled +
                ", draftKingsFantasyPoints=" + draftKingsFantasyPoints +
                ", status=" + status +
                '}';
    }
}
