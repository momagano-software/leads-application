package za.co.momagano.model;

import java.util.List;

public class LookupObject {
    List<Category> categoryList;

    public LookupObject() {
    }

    public LookupObject(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
