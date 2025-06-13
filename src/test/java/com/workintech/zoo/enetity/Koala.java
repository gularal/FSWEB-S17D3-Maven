package com.workintech.zoo.entity;

public class Koala {
    private int id;
    private String name;
    private double sleepHour;
    private double weight;
    private String gender;

    public Koala() {}

    public Koala(int id, String name, double sleepHour, double weight, String gender) {
        this.id = id;
        this.name = name;
        this.sleepHour = sleepHour;
        this.weight = weight;
        this.gender = gender;
    }

    // getter-setterlar
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getSleepHour() { return sleepHour; }
    public void setSleepHour(double sleepHour) { this.sleepHour = sleepHour; }
    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }
    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }
}
