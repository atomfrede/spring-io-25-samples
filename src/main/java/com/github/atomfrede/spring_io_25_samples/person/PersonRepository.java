package com.github.atomfrede.spring_io_25_samples.person;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    void save(Person person);


}
