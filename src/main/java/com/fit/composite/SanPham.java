package com.fit.composite;

public class SanPham implements Component{
    private String name;
    private Long price;

    public SanPham(String name, Long price) {
        this.name = name;
        this.price = price;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Long totalPrice() {
        System.out.println("Tính tiền " + name + ":" + price);
        return price;
    }
}
