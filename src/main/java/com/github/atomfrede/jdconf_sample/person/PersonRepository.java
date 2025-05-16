package com.github.atomfrede.jdconf_sample.person;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

@NoRepositoryBean
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    void save(Person person);


}
