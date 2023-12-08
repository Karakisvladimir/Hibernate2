package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Size;
@Entity
@Data
@Table(name = "clients")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    @Size(min = 3, max = 200, message = "Name must be between 3 and 200 characters")
    private String name;

}



//@Table(name = "passenger")
//@Entity
//@Data
//public class Passenger {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Id
//    private long id;
//
//    @Column
//    private String passport;
//
//    @Column
//    private String name;
//}