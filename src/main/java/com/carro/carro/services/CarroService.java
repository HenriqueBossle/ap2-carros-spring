package com.carro.carro.services;

import com.carro.carro.models.Carro;
import com.carro.carro.repositories.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public Carro getCarro(int id) {
        return this.carroRepository.getCarro(id);
    }

    public List<Carro> getCarros() {
        return this.carroRepository.getListacarros();
    }

    public Carro createCarro(Carro carro) {
        return this.carroRepository.createCarro(carro);
    }

    public Carro updateCarro(Carro carro, int id) {
        return this.carroRepository.updateCarro(carro, id);
    }

    public void deleteCarro(int id) {
        this.carroRepository.deleteCarro(id);
    }


}
