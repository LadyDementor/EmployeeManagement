package net.javaguides.emsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "randevular")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "reservation_date")
    private Date reservationDate;


    @ManyToOne //(cascade = CascadeType.ALL)

    @JoinColumn(name = "employee_id")

    private Employee employee;

    @ManyToOne //(cascade = CascadeType.ALL)
    @JoinColumn(name = "seat_id")
    private Seat seat;


    @Column (name = "is_active")
    private Boolean isActive;

   /* @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "created_date")
    private Date createdDate; */



}
