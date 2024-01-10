package com.driver;

public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    private int currentSpeed;
    private int currentDirection;


    public Vehicle(String name) {
        this.name = name;
    }
    public Vehicle() {
        currentSpeed = 0;
        currentDirection = 0;
    }

    public Vehicle(int currentSpeed, int currentDirection) {
        this.currentSpeed = currentSpeed;
        this.currentDirection = currentDirection;
    }

    public void steer(int direction){
        //direction is in degrees, add it to the current direction
        this.currentDirection += direction ;
        System.out.println("steer method called - The direction is changed to: " + currentDirection + " degrees");
    }

    public void move(int speed, int direction){
        //set the values of currentSpeed and currentDirection
        setCurrentSpeed(speed);
        setCurrentDirection(direction);
        System.out.println("move method called - The speed is changed to: " + currentSpeed + ", and the direction is changed to: " + currentDirection + " degrees");
    }

    public void stop(){
        setCurrentSpeed(0);
        System.out.println("stop method called - The vehicle is stopped");
    }

}
