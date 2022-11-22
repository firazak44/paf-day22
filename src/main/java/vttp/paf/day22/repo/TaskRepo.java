package vttp.paf.day22.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import vttp.paf.day22.model.Task;
import static vttp.paf.day22.repo.Queries.*;

@Repository
public class TaskRepo {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createTask(Task task){
        return jdbcTemplate.update(SQL_INSERT_TASK,
        task.getTaskId(),
        task.getTaskName(),
        task.getAssignTo(),
        task.getPriority().toString(),
        task.getCompletionDate());
    }
}
