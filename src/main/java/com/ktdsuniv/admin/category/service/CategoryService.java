package com.ktdsuniv.admin.category.service;

import java.util.List;

import category.schema.CategoriesSchema;

public interface CategoryService {

	public List<CategoriesSchema> getAllCategoryList();

	public boolean addCategory(CategoriesSchema categoriesSchema);

	public boolean deleteCategory(String categoryId);
	
	public CategoriesSchema getCategoryByName(String categoryName);

	public boolean checkExistChild(String categoryId);

	public boolean UpdateCategory(String categoryId, String categoryName);

	public CategoriesSchema getCategoryById(String categoryId);

}
