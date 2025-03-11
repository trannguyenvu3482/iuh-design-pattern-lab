package com.fit.observer;

public class SinhVien implements Observer {
    private String hoTen;
    private String mssv;

    public SinhVien(String hoTen, String mssv) {
        this.hoTen = hoTen;
        this.mssv = mssv;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Override
    public void update() {
        System.out.println("Sinh viên " + hoTen + " có mã số sinh viên " + mssv + " đã nhận thông báo");
    }
}
