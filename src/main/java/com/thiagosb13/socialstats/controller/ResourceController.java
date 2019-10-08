package com.thiagosb13.socialstats.controller;

import com.thiagosb13.socialstats.controller.dto.LikeRequest;
import com.thiagosb13.socialstats.domain.Like;
import com.thiagosb13.socialstats.domain.Resource;
import com.thiagosb13.socialstats.service.ResourceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/resources")
public class ResourceController {
    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @GetMapping("/{resourceId}/types/{type}")
    public Resource findByTypeAndId(@PathVariable String resourceId, @PathVariable String type) {
        return resourceService.findByTypeAndResourceId(type, resourceId);
    }

    @PostMapping("/{resourceId}/types/{type}/like")
    @ResponseStatus(CREATED)
    public Like like(@PathVariable String resourceId, @PathVariable String type, @RequestBody LikeRequest likeRequest) {
        return resourceService.like(type, resourceId, likeRequest);
    }
}
