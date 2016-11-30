package com.ktdsuniv.admin.category.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.category.service.CategoryService;

import category.schema.CategoriesSchema;

@Controller
public class CategoryController {

	private CategoryService categoryService;
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@RequestMapping("/category/categoryPage")
	public ModelAndView viewCategoryPage() {
		
		List<CategoriesSchema> categories = categoryService.getAllCategoryList();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/category/categoryPage");
		view.addObject("categories", categories);
		
		return view;
	}
	
	@RequestMapping("/category/doAddCategory")
	public ModelAndView doAddCategoryAction(CategoriesSchema categoriesSchema) {
	
		boolean isSuccess = categoryService.addCategory(categoriesSchema);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/category/categoryPage");
		
		return view;
	}
	
	@RequestMapping("/category/doDeleteCategory/{categoryId}")
	public ModelAndView doDeleteCategoryAction(@PathVariable String categoryId) {
		
		boolean isSuccess = categoryService.deleteCategory(categoryId);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("/category/categoryPage");
		
		return view;
	}
	
}
