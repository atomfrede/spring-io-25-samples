package com.github.atomfrede.spring_io_25_samples.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    void save(Person person);

    Page<Person> findAllWithQuery(String q, Pageable pageable);


}
