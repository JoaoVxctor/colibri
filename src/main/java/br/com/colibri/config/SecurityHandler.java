package br.com.colibri.config;

import br.com.colibri.models.Usuario;
import br.com.colibri.repositories.UsuarioRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Set;

@Component
public class SecurityHandler implements AuthenticationSuccessHandler {

    private HttpSession session;
    private UsuarioRepository usuarioRepository;

    @Autowired
    public SecurityHandler(HttpSession session, UsuarioRepository usuarioRepository) {
        this.session = session;
        this.usuarioRepository = usuarioRepository;

    }

    private static final Logger logger = LoggerFactory.getLogger(SecurityHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("Entrou no on Authentication Success");
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println("parou auqi");
        if (roles.contains("ALUNO")) {
            String usuarioId = "";
            if (authentication.getPrincipal() instanceof Principal) {
                usuarioId = ((Principal) authentication.getPrincipal()).getName();
                System.out.println(usuarioId);
            } else {
                usuarioId = ((User) authentication.getPrincipal()).getUsername();
                System.out.println(usuarioId);
            }
            System.out.println(usuarioId);
            Usuario userId =  usuarioRepository.findUsuarioByEmail(usuarioId);
//            session.setAttribute("usuarioId", userId.getId());
            request.getSession().setAttribute("usuarioId",userId.getId());
            System.out.println(userId.getEmail());
            response.sendRedirect("/index");
        }
    }
}
