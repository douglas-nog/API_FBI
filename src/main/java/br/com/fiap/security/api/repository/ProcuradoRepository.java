package br.com.fiap.security.api.repository;

import br.com.fiap.security.api.model.Procurado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcuradoRepository extends JpaRepository<Procurado, Long> {

    Procurado findByNome(String nome);

}
