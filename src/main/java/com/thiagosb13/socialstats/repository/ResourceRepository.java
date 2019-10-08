package com.thiagosb13.socialstats.repository;

import com.thiagosb13.socialstats.domain.Like;
import com.thiagosb13.socialstats.domain.Resource;
import com.thiagosb13.socialstats.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResourceRepository extends Neo4jRepository<Resource, Long> {
    Optional<Resource> findByTypeAndResourceId(String type, String resourceId);
}
