package mrvaltiel.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;
    private String surname;
    private String birthDay;
    private String login;
    private boolean isDeleted;

    public User(){}

    public User(String name, String surname, String birthDay, String login)
    {
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.login = login;
        this.isDeleted = false;
    }

    public long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getSurname()
    {
        return surname;
    }
    public String getBirthDay()
    {
        return birthDay;
    }
    public String getLogin()
    {
        return login;
    }
    public boolean getIsDeleted()
    {
        return isDeleted;
    }
}
