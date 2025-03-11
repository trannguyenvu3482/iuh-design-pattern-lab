package com.fit.observer;

import java.util.ArrayList;
import java.util.List;

public class LopHoc implements Subject {
    private String tenLop;
    private List<Observer> observers = new ArrayList<>();

    public LopHoc(String tenLop) {
        this.tenLop = tenLop;
    }

    @Override
    public void attach(Observer observer) {
        if (!observers.contains(observer)) {
            observers.add(observer);
        }
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        System.out.println("Thông báo đến tất cả sinh viên trong lớp " + tenLop);
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
