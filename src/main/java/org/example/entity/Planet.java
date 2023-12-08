package org.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Planet {
    @Id
    @Pattern(regexp = "[A-Z0-9]+", message = "Invalid planet ID")
    @Size(max = 10, message = "Planet ID length should be at most 10")
    private String id;

    @Column
    @NotBlank(message = "Planet name cannot be blank")
    @Size(max = 500, message = "Planet name length should be at most 500")
    private String name;

}


