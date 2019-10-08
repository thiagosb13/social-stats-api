package com.thiagosb13.socialstats.service;

import com.thiagosb13.socialstats.controller.dto.LikeRequest;
import com.thiagosb13.socialstats.domain.Like;
import com.thiagosb13.socialstats.domain.Resource;
import com.thiagosb13.socialstats.domain.User;
import com.thiagosb13.socialstats.repository.LikeRepository;
import com.thiagosb13.socialstats.repository.ResourceRepository;
import com.thiagosb13.socialstats.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceService {
    private final UserRepository userRepository;
    private final ResourceRepository resourceRepository;
    private final LikeRepository likeRepository;

    public ResourceService(UserRepository userRepository, ResourceRepository resourceRepository, LikeRepository likeRepository) {
        this.userRepository = userRepository;
        this.resourceRepository = resourceRepository;
        this.likeRepository = likeRepository;
    }

    public Like like(String resourceType, String resourceId, LikeRequest likeRequest) {
        var user = userRepository.findByUserId(likeRequest.getUserId())
                                 .orElseGet(() -> {
                                     var newUser = new User(likeRequest.getUserId(), likeRequest.getUserName());
                                     userRepository.save(newUser);
                                     return newUser;
                                 });

        var resource = resourceRepository.findByTypeAndResourceId(resourceType, resourceId)
                                         .orElseGet(() -> {
                                             var newResource = new Resource(resourceType, resourceId);
                                             resourceRepository.save(newResource);
                                             return newResource;
                                         });

        var like = new Like();
        like.setLiked(likeRequest.getLiked());
        like.setResource(resource);
        like.setUser(user);
        likeRepository.save(like);
        return like;
    }

    public Resource findByTypeAndResourceId(String type, String resourceId) {
        return resourceRepository.findByTypeAndResourceId(type, resourceId)
                                 .orElseThrow(() -> new RuntimeException("Resource was not found."));
    }
}