package com.ktdsuniv.admin.category.service.impl;

import java.util.List;

import com.ktdsuniv.admin.category.biz.CategoryBiz;
import com.ktdsuniv.admin.category.service.CategoryService;

import category.schema.CategoriesSchema;
import common.mongo.biz.CommonBiz;

public class CategoryServiceImpl implements CategoryService {
	
	private CategoryBiz categoryBiz;
	private CommonBiz commonBiz;
	
	public void setCommonBiz(CommonBiz commonBiz) {
		this.commonBiz = commonBiz;
	}

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
		
		boolean isSucess = categoryBiz.addCategory(categoriesSchema);
		
		return isSucess;
	}

	@Override
	public boolean deleteCategory(String categoryId) {
		return categoryBiz.deleteCategory(categoryId);
	}

	@Override
	public CategoriesSchema getCategoryByName(String categoryName) {
		return commonBiz.getMongoById("categoryName", categoryName, CategoriesSchema.class);
	}

	@Override
	public boolean checkExistChild(String categoryId) {
		return categoryBiz.checkExistChild(categoryId);
	}

	@Override
	public boolean UpdateCategory(String categoryId, String categoryName) {
		return categoryBiz.updateCategory(categoryId, categoryName);
	}

	@Override
	public CategoriesSchema getCategoryById(String categoryId) {
		return commonBiz.getMongoById("id", categoryId, CategoriesSchema.class);
	}

}
