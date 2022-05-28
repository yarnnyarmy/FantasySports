package org.yarrnyarmy.model.SingleBasketballGames;

public class SingleBestTeams{
    private String cpt;
    private String util1;
    private String util2;
    private String util3;
    private String util4;
    private String util5;

    private int salary;
    private double averagePoints;
    public SingleBestTeams() {
    }


    public String getCpt() {
        return cpt;
    }

    public void setCpt(String cpt) {
        this.cpt = cpt;
    }

    public String getUtil1() {
        return util1;
    }

    public void setUtil1(String util1) {
        this.util1 = util1;
    }

    public String getUtil2() {
        return util2;
    }

    public void setUtil2(String util2) {
        this.util2 = util2;
    }

    public String getUtil3() {
        return util3;
    }

    public void setUtil3(String util3) {
        this.util3 = util3;
    }

    public String getUtil4() {
        return util4;
    }

    public void setUtil4(String util4) {
        this.util4 = util4;
    }

    public String getUtil5() {
        return util5;
    }

    public void setUtil5(String util5) {
        this.util5 = util5;
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
        return "SingleBestTeams{" +
                "cpt='" + cpt + '\'' +
                ", util1='" + util1 + '\'' +
                ", util2='" + util2 + '\'' +
                ", util3='" + util3 + '\'' +
                ", util4='" + util4 + '\'' +
                ", util5='" + util5 + '\'' +
                ", salary=" + salary +
                ", averagePoints=" + averagePoints +
                '}';
    }
}
