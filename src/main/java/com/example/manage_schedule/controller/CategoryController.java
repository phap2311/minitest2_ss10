package com.example.manage_schedule.controller;

import com.example.manage_schedule.model.Category;
import com.example.manage_schedule.model.DTO.CountAmount;
import com.example.manage_schedule.model.Task;
import com.example.manage_schedule.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        Iterable<Category> categories = iCategoryService.findAll();
        modelAndView.addObject("category", categories);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView formCreate() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("category") Category category, RedirectAttributes attributes) {
        iCategoryService.save(category);
        attributes.addFlashAttribute("success", "create new category success");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        iCategoryService.remove(id);
        attributes.addFlashAttribute("success","delete category success");
        return "redirect:/category";
    }
    @GetMapping("/total")
    public ModelAndView getTotal(){
        ModelAndView modelAndView = new ModelAndView("/category/total");
        Iterable<CountAmount>countAmounts = iCategoryService.getTotal();
        modelAndView.addObject("countMount",countAmounts);
        return modelAndView;
    }


}
