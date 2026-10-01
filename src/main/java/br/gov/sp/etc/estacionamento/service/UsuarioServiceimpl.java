package br.gov.sp.etc.estacionamento.service;
import br.gov.sp.etc.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etc.estacionamento.model.Usuario;
import br.gov.sp.etc.estacionamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class UsuarioServiceimpl implements UsuarioService{

    @Autowired
    UsuarioRepository repository;

    @Override
    public String cadastrarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuario.getNome());
        usuarioEntity.setCpf(usuario.getCpf());
        usuarioEntity.setEmail(usuario.getEmail());
        usuarioEntity.setSenha(usuario.getSenha());
        usuarioEntity.setData(usuario.getData());

        repository.save(usuarioEntity);
        return "Usuario cadastrado";
    }

    @Override
    public List<Usuario> listarUsuario() {
        return List.of();
    }

    @Override
    public String atualizarUsuario(Usuario usuario) {
        return "";
    }

    @Override
    public String deletarUsuario(Long id) {
        return "";
    }

    @Override
    public Usuario buscaUsuarioPorEmail(String email) {
        UsuarioEntity entity = repository.findByEmail(email);
        if (entity == null) {
            return null;
        }
        return toUsuario(entity);
    }

    private Usuario toUsuario(UsuarioEntity entity){
        Usuario usuario = new Usuario();
        usuario.setEmail(entity.getEmail());
        usuario.setNome(entity.getNome());
        usuario.setCpf(entity.getCpf());
        usuario.setSenha(entity.getSenha());
        usuario.setData(entity.getData());
        return usuario;
    }
}
