package model;


public class LoginModel {
    private int idLogin;
    private String user;
    private String password;
    private String nameUser;
    private int situacao;
    private int perfilUsuario;
    private int compAerea;

    public int getIdLogin() {
        return idLogin;
    }

    public void setIdLogin(int idLogin) {
        this.idLogin = idLogin;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    /**
     * @return the situacao
     */
    public int getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(int situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the perfilUsuario
     */
    public int getPerfilUsuario() {
        return perfilUsuario;
    }

    /**
     * @param perfilUsuario the perfilUsuario to set
     */
    public void setPerfilUsuario(int perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }

    /**
     * @return the compAerea
     */
    public int getCompAerea() {
        return compAerea;
    }

    /**
     * @param compAerea the compAerea to set
     */
    public void setCompAerea(int compAerea) {
        this.compAerea = compAerea;
    }
    
    
}
