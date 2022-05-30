package za.co.momagano.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LookupObject {
    List<Category> categoryList;

    public LookupObject() {
        this.categoryList = new ArrayList<>();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LookupObject that = (LookupObject) o;
        return Objects.equals(categoryList, that.categoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryList);
    }
}
