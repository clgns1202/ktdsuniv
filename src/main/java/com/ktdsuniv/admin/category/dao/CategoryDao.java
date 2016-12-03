package com.ktdsuniv.admin.category.dao;

import java.util.List;

import category.schema.CategoriesSchema;

public interface CategoryDao {

	public List<CategoriesSchema> getAllCategoryList();

	public int addCategory(CategoriesSchema categoriesSchema);

	public int deleteCategory(String categoryId);

	public int checkExistChild(String categoryId);
	
}


