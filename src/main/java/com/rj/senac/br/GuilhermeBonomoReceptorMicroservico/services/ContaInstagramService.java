package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.services;

import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.entities.ContaInstagram;
import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.repositories.ContaInstagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContaInstagramService {
    private ContaInstagramRepository contaInstagramRepository;
    public ContaInstagramService(ContaInstagramRepository contaInstagramRepository){
        this.contaInstagramRepository = contaInstagramRepository;
    }
    public List<ContaInstagram> listarTodos() {
        return contaInstagramRepository.findAll();
    }

    public ContaInstagram remover(ContaInstagram conta) {
        return contaInstagramRepository.save(conta);
    }
}
