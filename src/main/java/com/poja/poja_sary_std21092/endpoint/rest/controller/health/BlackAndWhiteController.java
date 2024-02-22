package com.poja.poja_sary_std21092.endpoint.rest.controller.health;

import com.poja.poja_sary_std21092.repository.model.TransformationResult;
import com.poja.poja_sary_std21092.service.event.BlackAndWhiteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class BlackAndWhiteController {

    private final BlackAndWhiteService blackAndWhiteService;
    @PutMapping("/black-and-white/{id}")
    public ResponseEntity<Void> convertToBlackAndWhite(
            @PathVariable String id,
            @RequestBody byte[] imageBytes) {

        blackAndWhiteService.convertToBlackAndWhite(id, imageBytes);

        return ResponseEntity.ok().build();
    }
    @GetMapping("/black-and-white/{id}")
    public ResponseEntity<TransformationResult> getTransformationResult(@PathVariable String id) {
        TransformationResult result = blackAndWhiteService.fetchTransformationResult(id);

        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

