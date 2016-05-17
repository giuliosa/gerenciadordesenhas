package br.aeso.gerenciadordesenhas.br.aeso.gerenciadordesenhas.domain;

/**
 * Created by giulio on 15/05/16.
 */
public class Senha {
    private Integer id;
    private String app;
    private String login;
    private String password;
    private Integer loginId;

    public Senha(){}

    public Senha(Integer id, String app, String login, String password, Integer loginId) {
        this.id = id;
        this.app = app;
        this.login = login;
        this.password = password;
        this.loginId = loginId;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getLoginId(){
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }
}
