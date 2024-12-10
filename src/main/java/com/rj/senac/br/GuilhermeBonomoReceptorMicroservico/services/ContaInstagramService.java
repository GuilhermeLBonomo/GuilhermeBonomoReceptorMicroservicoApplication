package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.services;

import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.entities.ContaInstagram;
import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.repositories.ContaInstagramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
    @RabbitListener(queues = "fila-ecommerce")
    public void subscribe(ContaInstagram conta) {
        //return contaInstagramRepository.save(conta);
        ContaInstagram contaExistente = contaInstagramRepository.findById(conta.getId())
                .orElse(null);
        if (contaExistente != null) {
            contaInstagramRepository.delete(contaExistente);
        } else {
        // Caso o bilhete não seja encontrado, você pode fazer algo aqui, como logar o evento.
        System.out.println("Bilhete não encontrado para deleção.");
        }
    }
}
