package br.com.colibri.services;

import br.com.colibri.exceptions.MyFileNotFoundException;
import br.com.colibri.models.Arquivo;
import br.com.colibri.repositories.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ArquivoService {


    @Autowired
    private ArquivoRepository arquivoRepository;

    public Arquivo storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                System.out.println("Erro, .. não esperados");
            }

            Arquivo dbFile = new Arquivo(fileName, file.getContentType(), file.getBytes());

            return arquivoRepository.save(dbFile);
        } catch (IOException ex) {
            System.out.println("IO EXCEPTION");
            return null;
        }
    }

    public Arquivo getFile(String fileId) throws MyFileNotFoundException {
        return arquivoRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
}

