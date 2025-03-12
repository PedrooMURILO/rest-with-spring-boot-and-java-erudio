package io.github.PedrooMURILO.repository;

import io.github.PedrooMURILO.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {}
