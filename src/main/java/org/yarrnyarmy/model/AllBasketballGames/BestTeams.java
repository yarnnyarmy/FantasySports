package org.yarrnyarmy.model.AllBasketballGames;

public class BestTeams{
    private String names;
    private int totalSalary;
    private double totalFantasyPoints;

    public BestTeams() {
    }

    public BestTeams(String names, int totalSalary, double totalFantasyPoints) {
        this.names = names;
        this.totalSalary = totalSalary;
        this.totalFantasyPoints = totalFantasyPoints;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public double getTotalFantasyPoints() {
        return totalFantasyPoints;
    }

    public void setTotalFantasyPoints(double totalFantasyPoints) {
        this.totalFantasyPoints = totalFantasyPoints;
    }

    @Override
    public String toString() {
        return "BestTeams{" +
                "names='" + names + '\'' +
                ", totalSalary=" + totalSalary +
                ", totalFantasyPoints=" + totalFantasyPoints +
                '}';
    }
}
