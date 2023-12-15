package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.validation.constraints.Size;

import java.util.LinkedList;
import java.util.List;

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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ticket> tickets = new LinkedList<>();


}

