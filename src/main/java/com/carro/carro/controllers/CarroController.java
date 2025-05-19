package com.carro.carro.controllers;


import com.carro.carro.models.Carro;
import com.carro.carro.services.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getCarros() {
        return ResponseEntity.ok(this.carroService.getCarros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarro(@PathVariable int id) {
        return ResponseEntity.ok(this.carroService.getCarro(id));
    }

    @PutMapping({"/{id}"})
    public Carro updateCarro(@PathVariable int id, @RequestBody Carro carro) {
        return this.carroService.updateCarro(carro, id);
    }

    @PostMapping
    public ResponseEntity<Carro> createCarro(@RequestBody Carro carro) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(carro.getId()).toUri();
        return ResponseEntity.created(uri).body(this.carroService.createCarro(carro));
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<Void> deleteCarro(@PathVariable int id) {
        this.carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }
}
