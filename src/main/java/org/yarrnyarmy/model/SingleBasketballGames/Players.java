package org.yarrnyarmy.model.SingleBasketballGames;

public class Players {
    private String name;
    private String id;
    private String position;
    private String team;
    private int salary;
    private double averagePoints;

    //Constructors
    public Players() {
    }

    public Players(String name, String id, String position, String team, int salary, double averagePoints) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.team = team;
        this.salary = salary;
        this.averagePoints = averagePoints;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public void setTeam(String team) {
        this.team = team;
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

    @Override
    public String toString() {
        return "Players{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", position='" + position + '\'' +
                ", team='" + team + '\'' +
                ", salary=" + salary +
                ", averagePoints=" + averagePoints +
                '}';
    }
}
