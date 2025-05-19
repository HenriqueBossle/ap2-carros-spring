package com.carro.carro.repositories;

import com.carro.carro.models.Carro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class CarroRepository {
    private List<Carro> listacarros = new ArrayList<>();

    public CarroRepository() {
        listacarros.add(new Carro(1, "Ferrari", "458 Italia", 2012));
        listacarros.add(new Carro(2, "Porsche", "911", 2018));
        listacarros.add(new Carro(3, "Audi", "A8 L", 2022));
    }
    public List<Carro> getListacarros() {
        return listacarros;
    }

    public Carro getCarro(int id) {
        return listacarros
                .stream()
                .filter(item -> Objects.equals(item.getId(), id))
                .findFirst()
                .orElseThrow();
    }

    public Carro createCarro(Carro carro){
        listacarros.add(carro);
        return carro;
    }

    public Carro updateCarro(Carro carro, int id){
        Carro carroFilter = listacarros
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();
        int index = listacarros.indexOf(carroFilter);
        listacarros.set(index, carro);
        return carro;
    }

    public void deleteCarro(int id) {
        Carro carro = listacarros
                .stream()
                .filter(item -> item.getId() == id)
                .findFirst()
                .orElseThrow();
        listacarros.remove(carro);
    }




}
