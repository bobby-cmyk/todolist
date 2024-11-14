package vttp.batch5.ssf.todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
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
                        @Valid Task task,
                        BindingResult binding) 
    {   
        
        Tasks tasks = (Tasks) sess.getAttribute("tasks");

        // After "/save", there will not be tasks in the session
        if (tasks == null) {
            tasks = new Tasks();
            sess.setAttribute("tasks", tasks);
        }

        // If there are syntax error, return index
        if (binding.hasErrors()) {
            
            model.addAttribute("tasks", tasks);

            return "index";
        }

        // Only allow at most three tasks for free tier users - 
        if (tasks.getNumberOfTasks() == 3) {

            ObjectError err = new ObjectError("globalError", "You have reached the maximum number of tasks. Upgrade to Premium to continue using!");
            binding.addError(err);

            model.addAttribute("tasks", tasks);

            return "index";
        }



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

         // This is just for the page to load properly by ensuring that tasks is not null
         model.addAttribute("task", new Task());
         model.addAttribute("tasks", new Tasks());

        return "index";
    }

}
