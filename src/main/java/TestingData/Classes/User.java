package TestingData.Classes;

public class User {
    private String fio;
    private String shortFio;
    private String login;
    private String pwd;


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getShortFio() {
        return shortFio;
    }

    public void setShortFio(String shortFio) {
        this.shortFio = shortFio;
    }
}
