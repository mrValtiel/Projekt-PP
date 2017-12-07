package mrvaltiel.project;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.pojo.ApiStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
@Api(name = "Users API", description = "Provides a list of methods, that manage users", stage = ApiStage.RC)
public class UsersController
{
    private UsersRepository usersRepository;

    @Autowired
    public UsersController(UsersRepository usersRepository)
    {
        this.usersRepository = usersRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiMethod(description = "Get all users from the database")
    public List<User> getAll()
    {
        return usersRepository.findByIsDeletedFalse();
    }

    @RequestMapping(value = "/deleted", method = RequestMethod.GET)
    @ApiMethod(description = "Get all the deleted users from the database")
    public List<User> getDeleted()
    {
        return usersRepository.findByIsDeletedTrue();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiMethod(description = "Create new user and save it to the database")
    public List<User> create(@RequestBody User user)
    {
        usersRepository.save(user);
        return usersRepository.findByIsDeletedFalse();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.POST)
    @ApiMethod(description = "Remove user with provided ID from the database")
    public List<User> remove(@ApiPathParam(name = "id") @PathVariable long id)
    {
        usersRepository.delete(id);
        return usersRepository.findByIsDeletedFalse();
    }
}
