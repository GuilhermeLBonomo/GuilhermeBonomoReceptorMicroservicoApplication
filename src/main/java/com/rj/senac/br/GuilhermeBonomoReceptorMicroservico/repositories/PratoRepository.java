package com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.repositories;

import com.rj.senac.br.GuilhermeBonomoReceptorMicroservico.entities.Prato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Long> {
}
