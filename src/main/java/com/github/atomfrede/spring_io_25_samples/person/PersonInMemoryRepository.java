package com.github.atomfrede.spring_io_25_samples.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class PersonInMemoryRepository implements PersonRepository {

    private Map<Long, Person> persons = new HashMap<>();

    @Override
    public void save(Person person) {
        persons.putIfAbsent(person.getId(), person);
    }

    @Override
    public Iterable<Person> findAll(Sort sort) {
        return persons.values().stream().sorted(Comparator.comparing(Person::getName)).toList();
    }

    @Override
    public Page<Person> findAll(Pageable pageable) {
        if (pageable.getSort().getOrderFor("name").isAscending()) {
            List<Person> items = persons.values().stream()
                    .skip(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .sorted(Comparator.comparing(Person::getName).reversed())
                    .toList();
            return new PageImpl<>(items, pageable, persons.size());
        } else {
            List<Person> items = persons.values().stream()
                    .skip(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .sorted(Comparator.comparing(Person::getName))
                    .toList();
            return new PageImpl<>(items, pageable, persons.size());
        }
    }
}
