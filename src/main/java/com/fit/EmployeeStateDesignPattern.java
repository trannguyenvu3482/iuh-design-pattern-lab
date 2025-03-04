package com.fit;

import lombok.*;
import lombok.experimental.FieldDefaults;

interface EmployeeState {
    void performTask(EmployeeStateDesignPattern emp);
}

class GiamDocState implements EmployeeState {
    @Override
    public void performTask(EmployeeStateDesignPattern emp) {
        System.out.println("Đi tuần");
    }
}

class TruongPhongState implements EmployeeState {
    @Override
    public void performTask(EmployeeStateDesignPattern emp) {
        System.out.println("Gán việc cho nhân viên");
    }
}

class NhanVienState implements EmployeeState {
    @Override
    public void performTask(EmployeeStateDesignPattern emp) {
        System.out.println("Pha cà phê buổi sáng");
    }
}

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeStateDesignPattern {
    EmployeeState employeeState;

    public void performTask() {
        employeeState.performTask(this);
    }
}
