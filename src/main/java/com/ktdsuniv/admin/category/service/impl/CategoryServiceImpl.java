package com.ktdsuniv.admin.category.service.impl;

import java.util.List;

import com.ktdsuniv.admin.category.biz.CategoryBiz;
import com.ktdsuniv.admin.category.service.CategoryService;

import category.schema.CategoriesSchema;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryBiz categoryBiz;
	
	public void setCategoryBiz(CategoryBiz categoryBiz) {
		this.categoryBiz = categoryBiz;
	}

	@Override
	public List<CategoriesSchema> getAllCategoryList() {
		return categoryBiz.getAllCategoryList();
	}

	@Override
	public boolean addCategory(CategoriesSchema categoriesSchema) {
		categoriesSchema.setLevel(categoriesSchema.getLevel()+1);
		return categoryBiz.addCategory(categoriesSchema);
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryBiz.deleteCategory(categoryId);
	}

}
