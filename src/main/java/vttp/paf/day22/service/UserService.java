package vttp.paf.day22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import vttp.paf.day22.model.Task;
import vttp.paf.day22.model.User;
import vttp.paf.day22.repo.Repos;

@Service
public class UserService {
    
    @Autowired
    private Repos userRepo;

    public boolean authenticate(User user) {
        boolean result = userRepo.authenticate(user);
        System.out.printf("User credential: %d\n",result);
        return result;
    }

    public boolean createUser(final User user) throws Exception{ 
        int count = userRepo.createUser(user);
        System.out.printf("Insert user count: %d\n",count);
        return count > 0;
    }

    // public boolean createTask(final Task task) throws Exception{
    //     int count = userRepo.createTask(task);
    //     System.out.printf("Insert task count: %d\n",count);
    //     return count > 0;
    // }

    // public boolean checkCredential(String username, String password){
    //     int count = userRepo.checkCredential(username,password);
    //     System.out.printf("User credential: %d\n",count);
    //     return count > 0;
    // }

}
