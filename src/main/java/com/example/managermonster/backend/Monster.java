package com.example.managermonster.backend;

public class Monster {
    private String monsterName;
    private String monsterNumber;
    private String lightOlive;
    private String red;
    private String yellow;
    private String darkPurple;
    private String neonGreen;
    private String lightRed;
    private String chartreuse;
    private String thistle;
    private String notes = "";
    private String image;

    public Monster(String monsterName, String monsterNumber, String lightOlive, String red, String yellow,
                   String darkPurple, String neonGreen, String lightRed, String chartreuse, String thistle,
                   String image) {
        super();
        this.monsterName = monsterName;
        this.monsterNumber = monsterNumber;
        this.lightOlive = lightOlive;
        this.red = red;
        this.yellow = yellow;
        this.darkPurple = darkPurple;
        this.neonGreen = neonGreen;
        this.lightRed = lightRed;
        this.chartreuse = chartreuse;
        this.thistle = thistle;
        this.image = image;
    }

    public Monster() {}
    public String getMonsterName() {
        return monsterName;
    }
    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }
    public String getMonsterNumber() {
        return monsterNumber;
    }
    public void setMonsterNumber(String monsterNumber) {this.monsterNumber = monsterNumber;}
    public void setLightOlive(String lightOlive) { this.lightOlive = lightOlive;}
    public String getLightOlive() {
        return lightOlive;
    }
    public void setYellow(String yellow) {
        this.yellow = yellow;
    }
    public String getYellow() {
        return yellow;
    }
    public void setDarkPurple(String darkPurple) {
        this.darkPurple = darkPurple;
    }
    public String getDarkPurple() {
        return darkPurple;
    }
    public void setNeonGreen(String neonGreen) {
        this.neonGreen = neonGreen;
    }
    public String getNeonGreen() {
        return neonGreen;
    }
    public void setLightRed(String lightRed) {
        this.lightRed = lightRed;
    }
    public String getLightRed() {
        return lightRed;
    }
    public void setChartreuse(String chartreuse) {
        this.chartreuse = chartreuse;
    }
    public String getChartreuse() {
        return chartreuse;
    }
    public void setThistle(String thistle) {
        this.thistle = thistle;
    }
    public String getThistle() {
        return thistle;
    }
    public void setRed(String red) {
        this.red = red;
    }
    public String getRed() {
        return red;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getImage() {
        return image;
    }
    @Override
    public String toString() {
        return monsterName + " " + monsterNumber + "(" + lightOlive + " "
                + red + " " + yellow + " " + darkPurple + " " + neonGreen + " " + lightRed
                + " " + chartreuse + " " + thistle +  ")";
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
}
