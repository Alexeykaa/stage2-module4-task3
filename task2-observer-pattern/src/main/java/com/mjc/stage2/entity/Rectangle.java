package com.mjc.stage2.entity;

import com.mjc.stage2.Observable;
import com.mjc.stage2.Observer;
import com.mjc.stage2.event.RectangleEvent;

import java.util.LinkedList;
import java.util.List;

public class Rectangle implements Observable {
    private int id;
    private double sideA;
    private double sideB;

    private List<Observer> observers;

    public Rectangle(int id, double sideA, double sideB) {
        this.id = id;
        this.sideA = sideA;
        this.sideB = sideB;
        observers = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
        notifyObserver();
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        RectangleEvent event = new RectangleEvent(this);
        observers.forEach(observer -> observer.handleEvent(event));
    }

    public double getSquare() {
        return sideA * sideB;
    }

    public double getPerimeter() {
        return 2 * (sideA + sideB);
    }
}
