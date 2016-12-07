package com.ktdsuniv.admin.category.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ktdsuniv.admin.category.service.CategoryService;

import category.schema.CategoriesSchema;

@Controller
public class CategoryController {

	private CategoryService categoryService;
	private Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping("/category/categoryPage")
	public ModelAndView viewCategoryPage() {
		List<CategoriesSchema> categories = categoryService.getAllCategoryList();
		
		ModelAndView view = new ModelAndView();
		view.setViewName("category/categoryPage");
		view.addObject("categories", categories);
		
		return view;
	}
	
	@RequestMapping("/category/getAllCategory")
	@ResponseBody
	public List<CategoriesSchema> getAllCategoryAction() {
		List<CategoriesSchema> categories = categoryService.getAllCategoryList();
		return categories;
	}
	
	@RequestMapping("/category/doAddCategory")
	@ResponseBody
	public CategoriesSchema doAddCategoryAction(CategoriesSchema categoriesSchema) {
		categoryService.addCategory(categoriesSchema);
		return categoryService.getCategoryByName(categoriesSchema.getCategoryName());
	}

	@RequestMapping("/category/doDeleteCategory/{categoryId}")
	@ResponseBody
	public boolean doDeleteCategoryAction(@PathVariable String categoryId) {
		
		boolean isExistChild = categoryService.checkExistChild(categoryId);
		if ( !isExistChild ) {
			return categoryService.deleteCategory(categoryId);
		}
		else {
			return false;
		}
	}
	
	@RequestMapping("/category/doUpdateCategory/{categoryId}")
	@ResponseBody
	public boolean doUpadateCategoryAction(@PathVariable String categoryId, String categoryName) {
		logger.debug("카테고리 아이디" + categoryId);
		logger.debug("카테고리 이름" + categoryName);
		return categoryService.UpdateCategory(categoryId, categoryName);
	}
	
	
}
