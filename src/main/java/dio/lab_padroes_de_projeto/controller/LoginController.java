package dio.lab_padroes_de_projeto.controller;

import dio.lab_padroes_de_projeto.security.JWTObject;
import org.springframework.http.HttpStatus;
import dio.lab_padroes_de_projeto.model.Cliente;
import dio.lab_padroes_de_projeto.dtos.LoginDto;
import dio.lab_padroes_de_projeto.dtos.SessaoDto;
import dio.lab_padroes_de_projeto.security.JWTCreator;
import dio.lab_padroes_de_projeto.security.SecurityConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import dio.lab_padroes_de_projeto.repository.ClienteRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;
@RestController
public class LoginController {
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private SecurityConfig securityConfig;
    @Autowired
    private ClienteRepository repository;

    @PostMapping("/login")
    public SessaoDto logar(@RequestBody LoginDto login){
        Cliente cliente = repository.findByUsername(login.getUsername());
        if(cliente!=null) {
            boolean passwordOk =  encoder.matches(login.getPassword(), cliente.getPassword());
            if (!passwordOk) {
                throw new RuntimeException("Senha inválida para o login: " + login.getUsername());
            }
            //Estamos enviando um objeto Sessão para retornar mais informações do usuário
            SessaoDto sessao = new SessaoDto();
            sessao.setLogin(cliente.getUsername());

            JWTObject jwtObject = new JWTObject();
            jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
            jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
            jwtObject.setRoles(cliente.getRoles());
            sessao.setToken(JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));
            return sessao;
        }else {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuário ou senha inválidos");

        }
    }
}
