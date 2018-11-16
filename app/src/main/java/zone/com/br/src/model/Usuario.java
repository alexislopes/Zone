package zone.com.br.src.model;

import java.util.List;

public abstract class Usuario {
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    private String endereco;
    private List<Long> telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Long> getTelefone() {
        return telefone;
    }

    public void setTelefone(List<Long> telefone) {
        this.telefone = telefone;
    }
}
