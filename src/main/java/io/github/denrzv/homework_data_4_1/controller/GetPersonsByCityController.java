package io.github.denrzv.homework_data_4_1.controller;

import io.github.denrzv.homework_data_4_1.entity.Person;
import io.github.denrzv.homework_data_4_1.service.Service;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@Data
@RestController
public class GetPersonsByCityController {
    private final Service service;

    @GetMapping("/persons/by-city")
    public List<Person> getPersonsByCity(@Valid @RequestParam String city) {
        return service.findAllByCityOfLivingEqualsIgnoreCase(city);
    }
}
