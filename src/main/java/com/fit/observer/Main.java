package com.fit.observer;

public class Main {
    public static void main(String[] args) {
        LopHoc lopHoc = new LopHoc("DHKTPM17C");
        SinhVien sv1 = new SinhVien("Nguyễn Văn A", "21088201");
        SinhVien sv2 = new SinhVien("Nguyễn Văn B", "23141513");
        SinhVien sv3 = new SinhVien("Nguyễn Văn C", "22143109");

        lopHoc.attach(sv1);
        lopHoc.attach(sv2);
        lopHoc.attach(sv3);

        lopHoc.notifyObservers();
    }
}