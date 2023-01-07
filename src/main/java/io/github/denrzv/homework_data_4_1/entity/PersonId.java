package io.github.denrzv.homework_data_4_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonId implements Serializable {
    private String name;
    private String surname;
    private int age;
}
