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

    public Carro getCarro(Long id) {
        return this.carroRepository.findById(id).orElseThrow();
    }

    public List<Carro> getCarros() {
        return this.carroRepository.findAll();
    }

    public Carro createCarro(Carro carro) {
        return this.carroRepository.save(carro);
    }

    public Carro updateCarro(Carro carro, long id) {
        Carro carroEntity = this.carroRepository.getReferenceById(id);
        carroEntity.setMarca(carro.getMarca());
        carroEntity.setModelo(carro.getModelo());
        carroEntity.setAno(carro.getAno());
        this.carroRepository.save(carroEntity);
        return this.carroRepository.save(carroEntity);

    }

    public void deleteCarro(Long id) {
        this.carroRepository.delete(this.carroRepository.getReferenceById(id));
    }


}
