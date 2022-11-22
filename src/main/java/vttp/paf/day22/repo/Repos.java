package vttp.paf.day22.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

// import vttp.paf.day22.model.Task;
import vttp.paf.day22.model.User;
import static vttp.paf.day22.repo.Queries.*;

@Repository
public class Repos {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Integer createUser(User user) throws Exception{
        return jdbcTemplate.update(SQL_INSERT_USER, 
        user.getUsername(),
        user.getPassword(),
        user.getPhone(),
        user.getEmail(),
        user.getDob());
    }

    public boolean authenticate(User user) {
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(SQL_AUTHENTICATE_USER, 
            user.getUsername(), user.getPassword());

        if (rs.next())
            return rs.getBoolean("auth_state");

        return false;
    }
    
    // public Integer createTask(Task task){
    //     return jdbcTemplate.update(SQL_INSERT_TASK,
    //     task.getTask_id(),
    //     task.getTask_name(),
    //     task.getAssign_to(),
    //     task.getPriority().toString(),
    //     task.getCompletion_date());
    // }
}
