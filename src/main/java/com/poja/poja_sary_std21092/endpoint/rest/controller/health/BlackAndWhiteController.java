package com.poja.poja_sary_std21092.endpoint.rest.controller.health;

import com.poja.poja_sary_std21092.service.event.BlackAndWhiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlackAndWhiteController {

    private final BlackAndWhiteService blackAndWhiteService;

    @Autowired
    public BlackAndWhiteController(BlackAndWhiteService blackAndWhiteService) {
        this.blackAndWhiteService = blackAndWhiteService;
    }

    @PutMapping("/black-and-white/{id}")
    public ResponseEntity<Void> convertToBlackAndWhite(
            @PathVariable String id,
            @RequestBody byte[] imageBytes) {

        blackAndWhiteService.convertToBlackAndWhite(id, imageBytes);

        return ResponseEntity.ok().build();
    }
}

