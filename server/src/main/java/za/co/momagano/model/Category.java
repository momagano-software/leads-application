package za.co.momagano.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(subCategoryList, category.subCategoryList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subCategoryList);
    }
}
