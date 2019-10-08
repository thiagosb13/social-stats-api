package com.thiagosb13.socialstats.repository;

import com.thiagosb13.socialstats.domain.Like;
import com.thiagosb13.socialstats.domain.Resource;
import com.thiagosb13.socialstats.domain.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepository extends Neo4jRepository<Like, Long> {
    Optional<Like> findByUserAndResource(User user, Resource resource);
}
