package mrvaltiel.project;

public class User
{
    private int id;
    private String name;
    private String surname;
    private String birthDay;
    private String login;
    private boolean isDeleted;

    public User(){}

    public User(int id, String name, String surname, String birthDay, String login)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthDay = birthDay;
        this.login = login;
        this.isDeleted = false;
    }

    public int getId()
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
