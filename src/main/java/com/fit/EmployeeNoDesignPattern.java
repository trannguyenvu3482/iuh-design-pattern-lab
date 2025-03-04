package com.fit;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeNoDesignPattern {
    String chucVu;

    public void performTasks() {
        switch (chucVu) {
            case "Giam Doc":
                System.out.println("Đi tuần");
                break;
            case "Truong Phong":
                System.out.println("Gán việc cho nhân viên");
                break;
            case "Nhan Vien":
                System.out.println("Pha cà phê buổi sáng");
                break;
            default:
                System.out.println("Chức vụ không tồn tại");
        }
    }

}
