package br.edu.famper.cadastroprojeto.reposity;

import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.famper.cadastroprojeto.model.Projeto;

public interface ProjetoReposity extends JpaRepository<Projeto, Long>{

}

