package com.ktdsuniv.admin.category.biz.impl;

import java.util.List;

import com.ktdsuniv.admin.category.biz.CategoryBiz;
import com.ktdsuniv.admin.category.dao.CategoryDao;

import category.schema.CategoriesSchema;

public class CategoryBizImpl implements CategoryBiz {
	
	private CategoryDao categoryDao;
	
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	@Override
	public List<CategoriesSchema> getAllCategoryList() {
		return categoryDao.getAllCategoryList();
	}

	@Override
	public boolean addCategory(CategoriesSchema categoriesSchema) {
		return categoryDao.addCategory(categoriesSchema) > 0;
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryDao.deleteCategory(categoryId) > 0;
	}

}
