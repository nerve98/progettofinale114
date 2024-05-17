package com.generation.progettofinale.controllers;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.progettofinale.Services.ServiceCasco;
import com.generation.progettofinale.models.Casco;

import lombok.Data;

@RestController
@Data
@RequestMapping("api/casco")
public class TestController {

    private final ServiceCasco cascoService;

    @PostMapping("/insert")
    public ResponseEntity<Casco> insertEntity(@RequestBody Map<String, String> map) {
        return ResponseEntity.status(HttpStatus.OK).body(cascoService.insert(map));
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updaEntity(@RequestBody Map<String, String> map) {
        return ResponseEntity.status(HttpStatus.OK).body(cascoService.update(map));
    }
}
