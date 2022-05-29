package za.co.momagano.model;

import java.util.List;

public class Category extends KeyValue {

    private List<SubCategory> subCategoryList;

    public Category(String name, String value, List<SubCategory> subCategoryList) {
        super(name, value);
        this.subCategoryList = subCategoryList;
    }

    public Category(String name, String value) {
        super(name, value);
    }

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
