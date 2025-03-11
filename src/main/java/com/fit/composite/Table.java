package com.fit.composite;

import java.util.List;

public class Table implements Component {
    private String name;
    private List<Component> components;

    public Table(String name, List<Component> components) {
        this.name = name;
        this.components = components;
    }

    public String getName() {
        return name;
    }

    public List<Component> getComponents() {
        return components;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    @Override
    public Long totalPrice() {
        Long total = 0L;
        for (Component component : components) {
            total += component.totalPrice();
        }
        System.out.println("Tính tiền " + name + ":" + total);
        return total;
    }
}
