package com.poja.poja_sary_std21092.repository.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransformationResult {
    private String originalUrl;
    private String transformedUrl;
}