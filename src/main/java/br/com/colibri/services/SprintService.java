package br.com.colibri.services;

import br.com.colibri.dao.SprintDAO;
import br.com.colibri.models.Sprint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SprintService {
    private SprintDAO sprintDao;

    @Autowired
    public SprintService(SprintDAO sprintDao) {
        this.sprintDao = sprintDao;
    }

    public Boolean cadastroSprint(Sprint sprint){
        try {
            sprintDao.cadastroSprint(sprint);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    public Boolean deleteSprint(Sprint sprint){
        try {
            sprintDao.cadastroSprint(sprint);
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }


}
