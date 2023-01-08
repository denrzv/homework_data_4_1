package io.github.denrzv.homework_data_4_1.service;

import io.github.denrzv.homework_data_4_1.entity.Person;
import io.github.denrzv.homework_data_4_1.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public List<Person> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }
}
