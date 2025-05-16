package com.github.atomfrede.spring_io_25_samples.person;

import net.datafaker.Faker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import java.util.stream.IntStream;

@Service
public class PersonService {
    private final Faker faker = new Faker();
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;

        IntStream.range(1000, 2000).forEach(it -> {
            Pair<String, String> nameAndQuote = nameAndQuote(it);
            Person person = new Person((long) it, nameAndQuote.getFirst(), nameAndQuote.getSecond());
            personRepository.save(person);
        });
    }

    public Page<Person> findAll(Pageable pageable) {
        return personRepository.findAll(pageable);
    }

    private Pair<String, String> nameAndQuote(int i) {
        int modulo = i % 9;
        if (modulo == 0) {
            return Pair.of(faker.fallout().character(), faker.freshPrinceOfBelAir().quotes());
        }
        if (modulo == 1) {
            return Pair.of(faker.halfLife().character(), faker.backToTheFuture().quote());
        }
        if (modulo == 2) {
            return Pair.of(faker.backToTheFuture().character(), faker.dune().quote());
        }
        if (modulo == 3) {
            return Pair.of(faker.witcher().character(), faker.elderScrolls().quote());
        }
        if (modulo == 4) {
            return Pair.of(faker.warhammerFantasy().heros(), faker.babylon5().quote());
        }
        if (modulo == 5) {
            return Pair.of(faker.theItCrowd().characters(), faker.bigBangTheory().quote());
        }
        if (modulo == 6) {
            return Pair.of(faker.starTrek().character(), faker.starWars().quotes());
        }
        if (modulo == 7) {
            return Pair.of(faker.starWars().character(), faker.warhammerFantasy().heros());
        }
        if (modulo == 8) {
            return Pair.of(faker.harryPotter().character(), faker.buffy().quotes());
        }

        return Pair.of(faker.name().fullName(), faker.chuckNorris().fact());
    }
}
