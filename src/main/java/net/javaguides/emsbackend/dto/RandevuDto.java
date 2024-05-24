package net.javaguides.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RandevuDto {
  //  private Long id;
    private Date reservationDate;
    private EmployeeDto employee;
    private Boolean isActive;
    private SeatDto seat;

}
