package com.balekiss.test.data;

import com.balekiss.test.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface PersonDAO extends JpaRepository<Person, Long> {
}
