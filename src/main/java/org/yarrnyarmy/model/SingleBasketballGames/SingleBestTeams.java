package org.yarrnyarmy.model.SingleBasketballGames;

import java.util.concurrent.atomic.AtomicLong;

public class SingleBestTeams{
    private static final AtomicLong count = new AtomicLong(0);
    private long teamId;
    private int salary;
    private double averagePoints;
    private String name;
    public SingleBestTeams() {
    }

    public long getTeamId() {
        return teamId;
    }

    public void setTeamId(long teamId) {

        this.teamId = count.incrementAndGet();
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public double getAveragePoints() {
        return averagePoints;
    }

    public void setAveragePoints(double averagePoints) {
        this.averagePoints = averagePoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SingleBestTeams{" +
                "teamId=" + teamId +
                ", salary=" + salary +
                ", averagePoints=" + averagePoints +
                ", name='" + name + '\'' +
                '}';
    }
}
