package io.github.denrzv.homework_data_4_1.controller;

import io.github.denrzv.homework_data_4_1.entity.Person;
import io.github.denrzv.homework_data_4_1.service.Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
public class Controller {
    private final Service service;

    @GetMapping("/persons/by-city")
    public List<Person> findAllByCityOfLivingEqualsIgnoreCase(@Valid @RequestParam String city) {
        return service.findAllByCityOfLivingEqualsIgnoreCase(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> findAllByAgeLessThanOrderByAge(@Valid @RequestParam int age) {
        return service.findAllByAgeLessThanOrderByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public List<Person> findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(@Valid @RequestParam
                                                                                              String name,
                                                                                          @Valid @RequestParam
                                                                                          String surname) {
        return service.findAllByNameEqualsIgnoreCaseAndSurnameEqualsIgnoreCase(name, surname);
    }

    @PostMapping("/persons")
    public Person addPerson(@Valid @RequestBody Person person) {
        return service.addPerson(person);
    }

    @GetMapping("/persons/update-phone")
    public Person updatePhoneNumber(@Valid @RequestParam String name, @Valid @RequestParam String surname,
                                    @Valid @RequestParam int age, @Valid @RequestParam int phoneNumber) {
        return service.updatePhone(name, surname, age, phoneNumber);
    }

    @GetMapping("/persons/delete-person")
    public void deletePerson(@Valid @RequestParam String name, @Valid @RequestParam String surname,
                                    @Valid @RequestParam int age) {
        service.deletePerson(name, surname, age);
    }
}
