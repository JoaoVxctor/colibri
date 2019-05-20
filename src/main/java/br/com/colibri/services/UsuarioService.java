package br.com.colibri.services;

import br.com.colibri.models.Role;
import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.RoleRepository;
import br.com.colibri.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public Usuario findUsuarioByEmail(String email) {
        return usuarioRepository.findUsuarioByEmail(email);
    }

    public void saveUsuario(Usuario usuario){
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        Role userRole = roleRepository.findByRole("ALUNO");
        usuario.setRole(new HashSet<Role>(Arrays.asList(userRole)));
        usuarioRepository.save(usuario);
    }




    public UsuarioService() {
    }
}
