package br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain;

/**
 * Created by giulio on 15/05/16.
 */
public class Login {
    private Integer id;
    private String usuario;
    private Integer senha;

    public Login(){}

    public Login(Integer id, String usuario, Integer senha) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Integer getSenha() {
        return senha;
    }

    public void setSenha(Integer senha) {
        this.senha = senha;
    }
}
