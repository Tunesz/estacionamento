package br.gov.sp.etc.estacionamento.controller;

import br.gov.sp.etc.estacionamento.model.Usuario;
import br.gov.sp.etc.estacionamento.service.UsuarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        return "cadastrar";
    }

    @PostMapping("/efetuar-cadastro")
    public String efetuadoCadastro(Usuario usuario) {
        log.info(usuario.toString());
        service.cadastrarUsuario(usuario);
        return "cadastro-sucess";
    }

    @PostMapping("/autenticar")
    public String autenticar(@RequestParam String email, @RequestParam String senha) {
        Usuario xpto = service.buscaUsuarioPorEmail(email);

        if (xpto != null && senha.equals(xpto.getSenha())) {
            return "painel";
        } else {
            return "erro";
        }
    }
}
