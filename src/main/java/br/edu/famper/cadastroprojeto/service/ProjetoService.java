package br.edu.famper.cadastroprojeto.service;
import br.edu.famper.cadastroprojeto.model.Projeto;
import br.edu.famper.cadastroprojeto.reposity.ProjetoReposity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {
   @Autowired
    private ProjetoReposity projetoReposity;

   public Projeto salvar(Projeto projeto){
       return projetoReposity.save(projeto);
   }
   public List<Projeto> findall() {
       return projetoReposity.findAll();
   }
   public Optional<Projeto> findById(Long id) {
       return projetoReposity.findById(id);
   }
   public Projeto update(Projeto projeto) {
       Projeto salvo = projetoReposity.findById(projeto.getCodigo())
               .orElseThrow(() ->
                       new RuntimeException("Projeto não encontrado"));

       salvo.setNome(projeto.getNome());
       salvo.setDescricao(projeto.getDescricao());
       salvo.setDataInicio(projeto.getDataInicio());
       salvo.setDataFim(projeto.getDataFim());

       return projetoReposity.save(projeto);
   }

    public void deleteById(Long id) {
       projetoReposity.deleteById(id);
    }
}
