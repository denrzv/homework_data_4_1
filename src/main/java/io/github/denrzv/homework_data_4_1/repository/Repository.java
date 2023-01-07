package io.github.denrzv.homework_data_4_1.repository;

import io.github.denrzv.homework_data_4_1.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;


@Data
@org.springframework.stereotype.Repository
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    public Repository() {
        var names = Arrays.asList("Антон", "Иван", "Михаил");
        var surnames = Arrays.asList("Антонов", "Иванов", "Михайлов");
        var cities = Arrays.asList("Архангельск","Борисоглебск","Воронеж");
        var random = new Random();
        IntStream.range(0, 100)
                .forEach(i -> {
                    var person = Person.builder()
                            .name(names.get(random.nextInt(names.size())))
                            .surname(surnames.get(random.nextInt(surnames.size())))
                            .age(random.nextInt(90))
                            .phoneNumber(random.nextInt())
                            .cityOfLiving(cities.get(random.nextInt(cities.size())))
                            .build();
                    entityManager.persist(person);
                });
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select * from PERSONS where city_of_living = :city order by age");
        query.setParameter("city", city);
        return query.getResultList();
    }
}
