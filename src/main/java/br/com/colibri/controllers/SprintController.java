package br.com.colibri.controllers;

import br.com.colibri.models.Projeto;
import br.com.colibri.models.Sprint;
import br.com.colibri.services.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("sprint")
public class SprintController {
        private SprintService sprintService;

        @Autowired
        public SprintController(SprintService sprintService) {
                this.sprintService = sprintService;
        }

        @PostMapping("/novo")
        public String novoSprint(Sprint sprint, RedirectAttributes redirectAttributes){
                if(sprintService.cadastroSprint(sprint)){
                        redirectAttributes.addFlashAttribute("msg", "Sprint cadastrada com sucesso");
                }else{
                        redirectAttributes.addFlashAttribute("msg", "Algo de errado aconteceu");

                }
                return "redirect:/projeto/"+sprint.getProjeto();

        }

        @DeleteMapping("/delete")
        public String deleteSprint(Sprint sprint, RedirectAttributes redirectAttributes){
                if(sprintService.cadastroSprint(sprint)){
                        redirectAttributes.addFlashAttribute("msg", "Sprint deletada com sucesso");
                }else{
                        redirectAttributes.addFlashAttribute("msg", "Algo de errado aconteceu");

                }
                return "redirect:/projeto/"+sprint.getProjeto();

        }
}
