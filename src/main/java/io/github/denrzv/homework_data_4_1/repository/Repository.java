package io.github.denrzv.homework_data_4_1.repository;

import io.github.denrzv.homework_data_4_1.entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@org.springframework.stereotype.Repository
@AllArgsConstructor
public class Repository {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Person p where p.cityOfLiving = :city order by p.age");
        query.setParameter("city", city);
        return query.getResultList();

    }

    @Transactional
    public void persist(Person person) {
        entityManager.persist(person);
    }
}
