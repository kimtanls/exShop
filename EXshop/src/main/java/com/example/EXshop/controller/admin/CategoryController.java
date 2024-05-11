package com.example.EXshop.controller.admin;

import com.example.EXshop.models.Category;
import com.example.EXshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.cache.SpringCacheBasedUserCache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/category")
    public String admin(Model model){
        List<Category> categoryList = this.categoryService.getAll();
        model.addAttribute("categoryList",categoryList);
        return "admin/category/index";
    }

    @GetMapping("/add-category")
    public String add(Model model){
        Category category = new Category();
        category.setCategoryStatus(true);
        model.addAttribute("category",category);
        return "admin/category/add";
    }

    @PostMapping("/add-category")
    public String save(@ModelAttribute("category") Category category){
        if (this.categoryService.create(category)){
            return "redirect:/admin/category";
        }else {
            return "admin/category/add";
        }
    }

    @GetMapping("/edit-category/{id}")
    public String edit(Model model, @PathVariable("id") Integer id){
        Category category = this.categoryService.findById(id);
        model.addAttribute("category" , category);
        return "admin/category/edit";
    }

    @PostMapping("/edit-category")
    public String update(@ModelAttribute("category") Category category){
        if (this.categoryService.update(category)){
            return "redirect:/admin/category";
        }else {
            return "admin/category/edit";
        }
    }

    @GetMapping("/delete-category/{id}")
    public String delete(@PathVariable("id") Integer id){
        if (this.categoryService.delete(id)){
            return "redirect:/admin/category";
        }else {
            return "redirect:/admin/category";
        }
    }
}
