package com.thiagosb13.socialstats.repository;

import com.thiagosb13.socialstats.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends Neo4jRepository<User, Long> {
    List<User> findByName(String name);
}
