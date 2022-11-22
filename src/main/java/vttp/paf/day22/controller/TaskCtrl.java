package vttp.paf.day22.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import vttp.paf.day22.model.User;
import vttp.paf.day22.repo.TaskRepo;
import vttp.paf.day22.model.Task;
import vttp.paf.day22.service.UserService;

@Controller
@RequestMapping(path="/task")
public class TaskCtrl {

    @Autowired
    private UserService userSvc;

    @Autowired
    private TaskRepo trepo;
    
    // @GetMapping("/task")
    // public String showTaskPage() {
    //     return "task";
    // }

    @PostMapping
    public String postTask(@RequestBody MultiValueMap<String, String> form, Model model){
        // String username = form.getFirst("username");
        // String password = form.getFirst("password");
        // String task_name = form.getFirst("task_name");
        // String priority = form.getFirst("priority");
        // String completion_date = form.getFirst("completion_date");

        User user = new User();
        Task task = new Task();
        user.setUsername(form.getFirst("username"));
        user.setPassword(form.getFirst("password"));
        if (!userSvc.authenticate(user)) 
            return "auth_fail";
        task.setTaskName(form.getFirst("taskName"));
        task.setPriority(form.getFirst("priority"));
        task.setAssignTo(user);
        task.setCompletionDate(form.getFirst("completionDate"));

        // try {
        //     // if (!userSvc.createUserTask(user, task));
        //     //     System.out.println(">>> error! user not created");
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     model.addAttribute("errorMsg", e.getMessage());
        //     return "error";
        // }
        
        Integer count = trepo.createTask(task);
        System.out.printf(">>>> %s, count: %d\n", task.toString(), count);

        return "createdtask";
    }
    
}
