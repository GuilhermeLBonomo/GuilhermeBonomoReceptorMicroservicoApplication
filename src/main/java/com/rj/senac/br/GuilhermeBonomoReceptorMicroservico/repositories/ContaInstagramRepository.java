package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.repositories;

import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.entities.ContaInstagram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaInstagramRepository extends JpaRepository<ContaInstagram, Long> {
}
