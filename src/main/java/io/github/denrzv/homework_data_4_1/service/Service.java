package io.github.denrzv.homework_data_4_1.service;

import io.github.denrzv.homework_data_4_1.entity.Person;
import io.github.denrzv.homework_data_4_1.repository.Repository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@org.springframework.stereotype.Service
public class Service {
    private final Repository repository;

    public List<Person> findAllByCityOfLivingEqualsIgnoreCase(String city) {
        return repository.findAllByCityOfLivingEqualsIgnoreCase(city);
    }

    public List<Person> findAllByAgeLessThanOrderByAge(int age) {
        return repository.findAllByAgeLessThanOrderByAge(age);
    }

    public List<Person> findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(String name, String surname) {
        return repository.findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(name, surname)
                .orElseThrow(() -> new EntityNotFoundException("Не удалось найти пользователя"));
    }

    public Person addPerson(Person person) {
        return repository.save(person);
    }

    public Person updatePhone(String name, String surname, int age, int phoneNumber) {
        return repository.setPersonPhoneNumberByNameAndSurnameAndAge(name, surname, age, phoneNumber);
    }

    public void deletePerson(String name, String surname, int age) {
        repository.deletePersonByNameAndSurnameAndAge(name, surname, age);
    }
}
