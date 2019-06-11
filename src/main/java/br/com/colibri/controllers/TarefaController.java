package br.com.colibri.controllers;

import br.com.colibri.models.Tarefa;
import br.com.colibri.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/tarefa")
public class TarefaController {


    TarefaService tarefaService;

    @Autowired
    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping("/novo")
    public String adicionaTarefa(Tarefa tarefa, RedirectAttributes redirectAttributes) {
        if (tarefaService.cadastraTarefa(tarefa)) {
            redirectAttributes.addFlashAttribute("msg", "Tarefa Cadastrada com sucesso");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Algo deu errado");
        }
        return "Redirect:/projeto/" + tarefa.getSprint().getProjeto().getId();
    }

    @PutMapping("/finaliza")
    public String finalizaTarefa(Tarefa tarefa, RedirectAttributes redirectAttributes) {
        if (!tarefaService.cadastraTarefa(tarefa)) {
            redirectAttributes.addFlashAttribute("msg", "Algo deu errado");
        }
        return "Redirect:/projeto/" + tarefa.getSprint().getProjeto().getId();
    }

    @DeleteMapping("/novo")
    public String deleteTarefa(Tarefa tarefa, RedirectAttributes redirectAttributes) {
        if (tarefaService.cadastraTarefa(tarefa)) {
            redirectAttributes.addFlashAttribute("msg", "Tarefa Deletada com sucesso");
        } else {
            redirectAttributes.addFlashAttribute("msg", "Algo deu errado");
        }
        return "Redirect:/projeto/" + tarefa.getSprint().getProjeto().getId();
    }
}
