package com.fit;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    // No design pattern
    public static void methodNoDesignPattern() {
        System.out.println("\nNhập chức vụ: ");
        scanner.nextLine();
        String chucVu = scanner.nextLine();

        EmployeeNoDesignPattern employeeNoDesignPattern = new EmployeeNoDesignPattern();
        employeeNoDesignPattern.setChucVu(chucVu);

        System.out.println("Danh sách công việc:");
        employeeNoDesignPattern.performTasks();
    }

    // Design pattern: State
    public static void methodWithDesignPatternState() {
        System.out.println("\nNhập chức vụ: ");
        scanner.nextLine();
        String chucVu = scanner.nextLine();

        EmployeeStateDesignPattern emp = switch (chucVu) {
            case "Giam Doc" -> new EmployeeStateDesignPattern(new GiamDocState());
            case "Truong Phong" -> new EmployeeStateDesignPattern(new TruongPhongState());
            case "Nhan Vien" -> new EmployeeStateDesignPattern(new NhanVienState());
            default -> throw new IllegalStateException("Không hợp lệ: " + chucVu);
        };

        System.out.println("Danh sách công việc:");
        emp.performTask();
    }

    // Design pattern: Strategy
    public static void methodWithDesignPatternStrategy() {
        System.out.println("\nNhập chức vụ: ");
        scanner.nextLine();
        String chucVu = scanner.nextLine();

        EmployeeStrategyDesignPattern emp = new EmployeeStrategyDesignPattern();

        switch (chucVu) {
            case "Giam Doc":
                emp.setEmployeeStrategy(new GiamDocStrategy());
                break;
            case "Truong Phong":
                emp.setEmployeeStrategy(new TruongPhongStrategy());
                break;
            case "Nhan Vien":
                emp.setEmployeeStrategy(new NhanVienStrategy());
                break;
            default:
                throw new IllegalStateException("Không hợp lệ: " + chucVu);
        }

        System.out.println("Danh sách công việc:");
        emp.performTask();
    }

    // Design pattern: Decorator
     public static void methodWithDesignPatternDecorator() {
        System.out.println("\nNhập chức vụ: ");
        scanner.nextLine();
        String chucVu = scanner.nextLine();

        Employee emp = switch (chucVu) {
            case "Giam Doc" -> new GiamDoc(new NhanVien());
            case "Truong Phong" -> new TruongPhong(new NhanVien());
            case "Nhan Vien" -> new NhanVien();
            default -> throw new IllegalStateException("Không hợp lệ: " + chucVu);
        };

        System.out.println("Danh sách công việc:");
        emp.performTasks();
     }

    public static void main(String[] args) {
        // Menu
        System.out.println("1. Method No Design Pattern");
        System.out.println("2. Method With Design Pattern: State");
        System.out.println("3. Method With Design Pattern: Strategy");
        System.out.println("4. Method With Design Pattern: Decorator");
        System.out.println("5. Array sort using Decorator pattern");
        System.out.print("Enter your choice: ");

        // Get user's choice
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                methodNoDesignPattern();
                break;
            case 2:
                 methodWithDesignPatternState();
                break;
            case 3:
                 methodWithDesignPatternStrategy();
                break;
            case 4:
                 methodWithDesignPatternDecorator();
                break;
            default:
                System.out.println("Invalid choice");
        }

    }
}