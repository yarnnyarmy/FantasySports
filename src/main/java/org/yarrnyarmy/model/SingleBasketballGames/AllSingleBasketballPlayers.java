package org.yarrnyarmy.model.SingleBasketballGames;

import com.opencsv.bean.CsvBindByName;

public class AllSingleBasketballPlayers {

    @CsvBindByName
    private String name;
    @CsvBindByName
    private long id;
    @CsvBindByName
    private String position;
    @CsvBindByName
    private String team;
    @CsvBindByName
    private int salary;
    @CsvBindByName
    private double averageFantasyPoints;
    private int gamesPlayed;
    private int gamesStarted;

    private double minPerGame;
    private double fieldGoalsMadePerGame;
    private double fieldGoalsAttemptedPerGame;
    private double fieldGoalPercentage;
    private double threePointsAveragePerGame;
    private double threePointsAttemptedPerGame;
    private double threePointPercentagePerGame;
    private double twoPointFieldGoalsPerGame;
    private double twoPointAverageAttemptedPerGame;
    private double twoPointPercentagePerGame;
    private double freeThrowsPerGame;
    private double freeThrowsAttemptedPerGame;
    private double freeThrowPercentagePerGame;
    private double assistPerGame;
    private double reboundsPerGame;
    private double stealsPerGame;
    private double blocksPergame;
    private double turnoversPerGame;
    private double foulsPerGame;
    private double pointsPerGame;

    //Constructors
    public AllSingleBasketballPlayers() {
    }

    //Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getAverageFantasyPoints() {
        return averageFantasyPoints;
    }

    public void setAverageFantasyPoints(double averageFantasyPoints) {
        this.averageFantasyPoints = averageFantasyPoints;
    }
    public void setTeam(String team) {
        this.team = team;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getAssistPerGame() {
        return assistPerGame;
    }

    public void setAssistPerGame(double assistPerGame) {
        this.assistPerGame = assistPerGame;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesStarted() {
        return gamesStarted;
    }

    public void setGamesStarted(int gamesStarted) {
        this.gamesStarted = gamesStarted;
    }

    public double getMinPerGame() {
        return minPerGame;
    }

    public void setMinPerGame(double minPerGame) {
        this.minPerGame = minPerGame;
    }

    public double getFieldGoalsMadePerGame() {
        return fieldGoalsMadePerGame;
    }

    public void setFieldGoalsMadePerGame(double fieldGoalsMadePerGame) {
        this.fieldGoalsMadePerGame = fieldGoalsMadePerGame;
    }

    public double getFieldGoalsAttemptedPerGame() {
        return fieldGoalsAttemptedPerGame;
    }

    public void setFieldGoalsAttemptedPerGame(double fieldGoalsAttemptedPerGame) {
        this.fieldGoalsAttemptedPerGame = fieldGoalsAttemptedPerGame;
    }

    public double getFieldGoalPercentage() {
        return fieldGoalPercentage;
    }

    public void setFieldGoalPercentage(double fieldGoalPercentage) {
        this.fieldGoalPercentage = fieldGoalPercentage;
    }

    public double getThreePointsAveragePerGame() {
        return threePointsAveragePerGame;
    }

    public void setThreePointsAveragePerGame(double threePointsAveragePerGame) {
        this.threePointsAveragePerGame = threePointsAveragePerGame;
    }

    public double getThreePointsAttemptedPerGame() {
        return threePointsAttemptedPerGame;
    }

    public void setThreePointsAttemptedPerGame(double threePointsAttemptedPerGame) {
        this.threePointsAttemptedPerGame = threePointsAttemptedPerGame;
    }

    public double getThreePointPercentagePerGame() {
        return threePointPercentagePerGame;
    }

    public void setThreePointPercentagePerGame(double threePointPercentagePerGame) {
        this.threePointPercentagePerGame = threePointPercentagePerGame;
    }

    public double getTwoPointFieldGoalsPerGame() {
        return twoPointFieldGoalsPerGame;
    }

    public void setTwoPointFieldGoalsPerGame(double twoPointFieldGoalsPerGame) {
        this.twoPointFieldGoalsPerGame = twoPointFieldGoalsPerGame;
    }

    public double getTwoPointAverageAttemptedPerGame() {
        return twoPointAverageAttemptedPerGame;
    }

    public void setTwoPointAverageAttemptedPerGame(double twoPointAverageAttemptedPerGame) {
        this.twoPointAverageAttemptedPerGame = twoPointAverageAttemptedPerGame;
    }

    public double getTwoPointPercentagePerGame() {
        return twoPointPercentagePerGame;
    }

    public void setTwoPointPercentagePerGame(double twoPointPercentagePerGame) {
        this.twoPointPercentagePerGame = twoPointPercentagePerGame;
    }

    public double getFreeThrowsPerGame() {
        return freeThrowsPerGame;
    }

    public void setFreeThrowsPerGame(double freeThrowsPerGame) {
        this.freeThrowsPerGame = freeThrowsPerGame;
    }

    public double getFreeThrowsAttemptedPerGame() {
        return freeThrowsAttemptedPerGame;
    }

    public void setFreeThrowsAttemptedPerGame(double freeThrowsAttemptedPerGame) {
        this.freeThrowsAttemptedPerGame = freeThrowsAttemptedPerGame;
    }

    public double getFreeThrowPercentagePerGame() {
        return freeThrowPercentagePerGame;
    }

    public void setFreeThrowPercentagePerGame(double freeThrowPercentagePerGame) {
        this.freeThrowPercentagePerGame = freeThrowPercentagePerGame;
    }

    public double getReboundsPerGame() {
        return reboundsPerGame;
    }

    public void setReboundsPerGame(double reboundsPerGame) {
        this.reboundsPerGame = reboundsPerGame;
    }

    public double getStealsPerGame() {
        return stealsPerGame;
    }

    public void setStealsPerGame(double stealsPerGame) {
        this.stealsPerGame = stealsPerGame;
    }

    public double getBlocksPergame() {
        return blocksPergame;
    }

    public void setBlocksPergame(double blocksPergame) {
        this.blocksPergame = blocksPergame;
    }

    public double getTurnoversPerGame() {
        return turnoversPerGame;
    }

    public void setTurnoversPerGame(double turnoversPerGame) {
        this.turnoversPerGame = turnoversPerGame;
    }

    public double getFoulsPerGame() {
        return foulsPerGame;
    }

    public void setFoulsPerGame(double foulsPerGame) {
        this.foulsPerGame = foulsPerGame;
    }

    public double getPointsPerGame() {
        return pointsPerGame;
    }

    public void setPointsPerGame(double pointsPerGame) {
        this.pointsPerGame = pointsPerGame;
    }


    @Override
    public String toString() {
        return "AllSingleBasketballPlayers{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", salary=" + salary +
                ", averageFantasyPoints=" + averageFantasyPoints +
                ", gamesPlayed=" + gamesPlayed +
                ", gamesStarted=" + gamesStarted +
                ", minPerGame=" + minPerGame +
                ", fieldGoalsMadePerGame=" + fieldGoalsMadePerGame +
                ", fieldGoalsAttemptedPerGame=" + fieldGoalsAttemptedPerGame +
                ", fieldGoalPercentage=" + fieldGoalPercentage +
                ", threePointsAveragePerGame=" + threePointsAveragePerGame +
                ", threePointsAttemptedPerGame=" + threePointsAttemptedPerGame +
                ", threePointPercentagePerGame=" + threePointPercentagePerGame +
                ", twoPointFieldGoalsPerGame=" + twoPointFieldGoalsPerGame +
                ", twoPointAverageAttemptedPerGame=" + twoPointAverageAttemptedPerGame +
                ", twoPointPercentagePerGame=" + twoPointPercentagePerGame +
                ", freeThrowsPerGame=" + freeThrowsPerGame +
                ", freeThrowsAttemptedPerGame=" + freeThrowsAttemptedPerGame +
                ", freeThrowPercentagePerGame=" + freeThrowPercentagePerGame +
                ", assistPerGame=" + assistPerGame +
                ", reboundsPerGame=" + reboundsPerGame +
                ", stealsPerGame=" + stealsPerGame +
                ", blocksPergame=" + blocksPergame +
                ", turnoversPerGame=" + turnoversPerGame +
                ", foulsPerGame=" + foulsPerGame +
                ", pointsPerGame=" + pointsPerGame +
                '}';
    }
}
