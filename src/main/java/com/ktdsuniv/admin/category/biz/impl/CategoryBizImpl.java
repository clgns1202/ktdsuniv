package com.ktdsuniv.admin.category.biz.impl;

import java.util.ArrayList;
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
		List<CategoriesSchema> categories = categoryDao.getAllCategoryList();
		List<CategoriesSchema> sortedCategories = new ArrayList<CategoriesSchema>();
		/* List<CategoriesSchema> childCategories = null; */

		CategoriesSchema criteria = null;
		while (true) {
			if (categories.size() == 0) {
				break;
			}

			criteria = categories.get(0);
			categories.remove(0);

			if (sortedCategories.size() == 0) {
				sortedCategories.add(criteria);
			} 
			else {
				int j = 0;
				for (j = 0; j < sortedCategories.size(); j++) {
					if (sortedCategories.get(j).getId().equals(criteria.getParentId())) {
						sortedCategories.add(j + 1, criteria);
						break;
					}
				}
				if (j == sortedCategories.size()) {
					sortedCategories.add(criteria);
				}
			}
		}

		return sortedCategories;
	}

	@Override
	public boolean addCategory(CategoriesSchema categoriesSchema) {
		
		if ( categoryDao.existName(categoriesSchema.getCategoryName()) == 0 ) {
			return categoryDao.addCategory(categoriesSchema) > 0;
		}
		
		return false;
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryDao.deleteCategory(categoryId) > 0;
	}

	@Override
	public boolean checkExistChild(String categoryId) {
		return categoryDao.checkExistChild(categoryId) > 0;
	}

	@Override
	public boolean updateCategory(String categoryId, String categoryName) {
		if ( categoryDao.existName(categoryName) == 0 ) {
			return categoryDao.updateCategory(categoryId, categoryName) > 0;
		}
		return false;
	}

}
