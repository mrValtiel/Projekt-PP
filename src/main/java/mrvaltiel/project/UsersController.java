package mrvaltiel.project;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UsersController
{
    private List<User> users;

    public UsersController()
    {
        users = new ArrayList<>();

        users.add(new User(1, "Jan", "Kowalski", "1965-02-04","jankow"));
        users.add(new User(2, "Mariusz", "Depka", "1975-06-12", "mardep"));
        users.add(new User(3, "Arkadiusz", "Mały", "1982-05-24", "arkmal"));
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAll()
    {
        return users;
    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    public List<User> getDeleted()
    {
        return users.stream().filter(x -> x.getIsDeleted() == true).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<User> create(@RequestBody User user)
    {
        users.add(user);
        return users;
    }
}
