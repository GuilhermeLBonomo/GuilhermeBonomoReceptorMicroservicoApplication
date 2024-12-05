package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.services;

import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.entities.Prato;
import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.repositories.PratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PratoService {
    private PratoRepository pratoRepository;
    public PratoService(PratoRepository pratoRepository){
        this.pratoRepository = pratoRepository;
    }
    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public Prato adicionar(Prato medidor) {
        return pratoRepository.save(medidor);
    }
}
