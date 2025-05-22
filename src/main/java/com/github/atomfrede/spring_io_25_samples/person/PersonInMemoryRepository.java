package com.github.atomfrede.spring_io_25_samples.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.*;

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

    public Page<Person> findAllWithQuery(String q, Pageable pageable) {
        long totalCount = persons.values().stream()
                .filter(it -> it.getName().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)) || it.getQuote().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)))
                .count();
        if (pageable.getSort().getOrderFor("name").isAscending()) {
            List<Person> items = persons.values().stream()
                    .filter(it -> it.getName().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)) || it.getQuote().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)))
                    .skip(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .sorted(Comparator.comparing(Person::getName).reversed())
                    .toList();
            return new PageImpl<>(items, pageable, totalCount);
        } else {
            List<Person> items = persons.values().stream()
                    .filter(it -> it.getName().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)) || it.getQuote().toLowerCase(Locale.ROOT).contains(q.toLowerCase(Locale.ROOT)))
                    .skip(pageable.getOffset())
                    .limit(pageable.getPageSize())
                    .sorted(Comparator.comparing(Person::getName))
                    .toList();
            return new PageImpl<>(items, pageable, totalCount);
        }

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
