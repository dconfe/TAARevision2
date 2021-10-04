package fr.didi.classesOneToOneSansTableAssociation;

import javax.persistence.*;

@Entity
@Table(name ="T_Users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    private String login;
    private String password;
    private int connectionNumber;

    // Pour obtenir les usersinformations à partir de cette table t8User
    // la table T_Users contiendra la clé étrangère
    // la suppression d'un utilisateur entraine celle de ses informations aussi
    // le nom de la clé étrangère dans la table T_Users s'appelera idUserInformations
    @OneToOne
    @JoinColumn(name="idInformations")
    private UserInformations userInformations;


    public User() {
    }

    public User(int idUser, String login, String password, int connectionNumber) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.connectionNumber = connectionNumber;

    }

    public int getIdUser() {
        return idUser;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public int getConnectionNumber() {
        return connectionNumber;
    }



    public UserInformations getUserInformations() {
        return userInformations;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConnectionNumber(int connectionNumber) {
        this.connectionNumber = connectionNumber;
    }

    public void setUserInformations(UserInformations userInformations) {
        this.userInformations = userInformations;
    }

    public String toString() {
        return " " + this.login + " " + this.idUser + " " + this.password + " " + this.connectionNumber;
    }
}
