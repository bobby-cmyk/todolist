package vttp.batch5.ssf.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.batch5.ssf.todolist.models.Task;
import vttp.batch5.ssf.todolist.models.Tasks;

@Controller
@RequestMapping(path={"/", "index"})
public class TaskController {
    
    @GetMapping() 
    public String getIndex(Model model,
                        HttpSession sess) 
    {

        Tasks tasks = (Tasks) sess.getAttribute("tasks");
        
        if (tasks == null) {
            tasks = new Tasks();
            sess.setAttribute("tasks", tasks);
        }

        // Add task object to the model
        model.addAttribute("task", new Task());
        // Add tasks object to the model
        model.addAttribute ("tasks", tasks);

        return "index";
    }

    @PostMapping("/add")
    public String addTask(Model model,
                        HttpSession sess,
                        @ModelAttribute Task task) 
    {
        Tasks tasks = (Tasks) sess.getAttribute("tasks");

        tasks.addTask(task);

        model.addAttribute("task", new Task());

        model.addAttribute("tasks", tasks);

        return "index";
    }

    @PostMapping("/save")
    public String saveTasks(Model model,
                            HttpSession sess)
    {
        sess.invalidate();

        model.addAttribute("task", new Task());

        model.addAttribute("tasks", new Tasks());

        return "index";
    }
}
