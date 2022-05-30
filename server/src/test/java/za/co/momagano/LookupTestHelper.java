package za.co.momagano;

import za.co.momagano.model.Category;
import za.co.momagano.model.KeyValue;
import za.co.momagano.model.LookupObject;
import za.co.momagano.model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class LookupTestHelper {
    public static LookupObject getLookupObject() {
        List<KeyValue> serviceList = getServiceList();
        List<SubCategory> subCategoryList = getSubCategories(serviceList);
        List<Category> categoryList = getCategories(subCategoryList);
        LookupObject lookupObject = new LookupObject();
        lookupObject.setCategoryList(categoryList);
        return lookupObject;
    }

    public static List<KeyValue> getServiceList() {
        List<KeyValue> serviceList = new ArrayList<>();
        serviceList.add(new KeyValue("Installation", "Installation"));
        return serviceList;
    }

    public static List<Category> getCategories(List<SubCategory> subCategoryList) {
        Category category = new Category("Beauty", "Beauty", subCategoryList);
        List<Category> categoryList = new ArrayList<>();
        categoryList.add(category);
        return categoryList;
    }

    public static List<SubCategory> getSubCategories(List<KeyValue> serviceList) {
        SubCategory subCategory = new SubCategory("Hairdressing", "Hairdressing", serviceList);
        List<SubCategory> subCategoryList = new ArrayList<>();
        subCategoryList.add(subCategory);
        return subCategoryList;
    }
}
