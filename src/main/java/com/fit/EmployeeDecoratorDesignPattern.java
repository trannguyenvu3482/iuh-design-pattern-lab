package com.fit;

import lombok.*;
import lombok.experimental.FieldDefaults;

interface Employee {
    void performTasks();
}

class NhanVien implements Employee {
    @Override
    public void performTasks() {
        System.out.println("Pha cà phê buổi sáng");
    }
}

abstract class EmployeeDecorator implements Employee {
    protected Employee employee;

    public EmployeeDecorator(Employee employee) {
        this.employee = employee;
    }

    @Override
    public void performTasks() {
        employee.performTasks();
    }
}

class TruongPhong extends EmployeeDecorator {
    public TruongPhong(Employee employee) {
        super(employee);
    }

    @Override
    public void performTasks() {
        super.performTasks();
        System.out.println("Gán việc cho nhân viên");
    }
}

class GiamDoc extends EmployeeDecorator {
    public GiamDoc(Employee employee) {
        super(employee);
    }

    @Override
    public void performTasks() {
        super.performTasks();
        System.out.println("Đi tuần");
    }
}