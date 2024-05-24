package net.javaguides.emsbackend.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Data
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")

public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 /*   @GenericGenerator(name = "user_name", strategy = "net.javaguides.emsbackend.config.GeneratorClass")
    @GeneratedValue(generator = "user_name")
    @Column(name ="user_name",unique = true)
    private String userName;*/

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id",unique = true)
    private String email;
  /*  @Column(name = "updated_date")
    private Date updatedDate;
    @Column(name = "created_date")
    private Date createdDate;*/
}