package br.com.colibri.services;

import br.com.colibri.dao.TarefaDAO;
import br.com.colibri.models.Tarefa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TarefaService {
    private TarefaDAO tarefaDAO;

    @Autowired
    public TarefaService(TarefaDAO tarefaDAO) {
        this.tarefaDAO = tarefaDAO;
    }

    public boolean  cadastraTarefa(Tarefa tarefa){
        try{
            tarefaDAO.cadastrarTarefa(tarefa);

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean deletaTarefa(Tarefa tarefa){
        try{
            tarefaDAO.excluirTarefa(tarefa);

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }

    public boolean finalizaTarefa(Tarefa tarefa){
        try{
            tarefaDAO.finalizaTarefa(tarefa);

        }catch (Exception e){
            System.out.println(e);
            return false;
        }

        return true;
    }
}
