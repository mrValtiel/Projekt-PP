package mrvaltiel.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DatabaseSeeder implements CommandLineRunner
{
    private UsersRepository usersRepository;

    @Autowired
    public DatabaseSeeder(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    @Override
    public void run(String... strings) throws Exception
    {
        List<User> users = new ArrayList<>();

        users.add(new User("Jan", "Kowalski", "1965-02-04","jankow"));
        users.add(new User("Mariusz", "Depka", "1975-06-12", "mardep"));
        users.add(new User("Arkadiusz", "Mały", "1982-05-24", "arkmal"));

        usersRepository.save(users);
    }
}
