package com.fit.composite;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SanPham sanPham1 = new SanPham("Cà phê đen", 12000L);
        SanPham sanPham2 = new SanPham("Cà phê sữa", 15000L);
        SanPham sanPham3 = new SanPham("Thuốc lá", 15000L);

        List<Component> components1 = List.of(sanPham1, sanPham2, sanPham3);
        Table table1 = new Table("Bàn 1", components1);

        List<Component> components2 = List.of(sanPham1, sanPham1);
        Table table2 = new Table("Bàn 2", components2);

        List<Component> components3 = List.of(table1, table2);
        Section section = new Section("Lầu 1", components3);

        System.out.println("Tổng tiền: " + section.totalPrice());
    }
}
