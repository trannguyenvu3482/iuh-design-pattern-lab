package com.fit;

import lombok.*;
import lombok.experimental.FieldDefaults;

interface EmployeeStrategy {
    void performTask();
}

class GiamDocStrategy implements EmployeeStrategy {
    @Override
    public void performTask() {
        System.out.println("Đi tuần");
    }
}

class TruongPhongStrategy implements EmployeeStrategy {
    @Override
    public void performTask() {
        System.out.println("Gán việc cho nhân viên");
    }
}

class NhanVienStrategy implements EmployeeStrategy {
    @Override
    public void performTask() {
        System.out.println("Pha cà phê buổi sáng");
    }
}

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeStrategyDesignPattern {
    EmployeeStrategy employeeStrategy;

    public void performTask() {
        employeeStrategy.performTask();
    }
}
