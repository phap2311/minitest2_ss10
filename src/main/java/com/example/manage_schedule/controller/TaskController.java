package com.example.manage_schedule.controller;

import com.example.manage_schedule.model.Category;
import com.example.manage_schedule.model.Task;
import com.example.manage_schedule.repository.ICategoryRepository;
import com.example.manage_schedule.repository.ITaskRepository;
import com.example.manage_schedule.service.category.ICategoryService;
import com.example.manage_schedule.service.task.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/task")
public class TaskController {
    @Autowired
    private ITaskService iTaskService;
    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("category")
    public Iterable<Category> listCategory() {
        return iCategoryService.findAll();
    }

    @GetMapping()
    public ModelAndView listTask(@PageableDefault(size = 2) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("/task/list");
        Page<Task> tasks = iTaskService.findAll(pageable);
        modelAndView.addObject("task", tasks);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/task/create");
        modelAndView.addObject("task", new Task());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("task") Task task, RedirectAttributes attributes) {
        iTaskService.save(task);
        attributes.addFlashAttribute("success", "create new task success");
        return "redirect:/task";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        iTaskService.remove(id);
        attributes.addFlashAttribute("success", "delete task success");
        return "redirect:/task";
    }

    @GetMapping("/update/{id}")
    public ModelAndView formEdit(@PathVariable Long id) {
        Optional<Task> task = iTaskService.findById(id);
        if (task.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/task/update");
            modelAndView.addObject("task", task.get());
            return modelAndView;

        }
        return null;
    }

    @PostMapping("/update/{id}")
    public String update(@ModelAttribute("task") Task task, RedirectAttributes attributes) {
        iTaskService.save(task);
        attributes.addFlashAttribute("success", "update task success");
        return "redirect:/task";
    }

    @GetMapping("/search")
    public ModelAndView listCustomersSearch(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Task> tasks;
        if(search.isPresent()){
            tasks = iTaskService.findAllByFirstNameContaining(pageable, search.get());
        } else {
            tasks = iTaskService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/task/list");
        modelAndView.addObject("task",tasks );
        return modelAndView;
    }


}
