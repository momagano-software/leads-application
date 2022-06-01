package za.co.momagano.service;

import za.co.momagano.model.Category;
import za.co.momagano.model.LookupObject;
import za.co.momagano.repository.LookupRepository;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class LookupService {

    private LookupRepository lookupRepository;

    public LookupService(LookupRepository lookupRepository) {
        this.lookupRepository = lookupRepository;
    }

    public LookupObject getLookupObject() {
        return lookupRepository
                .findAll()
                .iterator()
                .next();

    }

    public void updateCategory(Category category) {
        LookupObject lookupObject;

        try {
            lookupObject = lookupRepository
                    .findAll()
                    .iterator()
                    .next();
        } catch (NoSuchElementException e) {
            lookupObject = new LookupObject();
        }

        AtomicBoolean isFound = new AtomicBoolean(false);

        lookupObject
                .getCategoryList()
                .stream()
                .filter(c -> c.getName().equalsIgnoreCase(category.getName()))
                .findFirst()
                .ifPresent(c1 -> {
                    c1.setName(category.getName());
                    c1.setSubCategoryList(category.getSubCategoryList());
                    isFound.set(true);
                });

        if (!isFound.get()) {
            lookupObject.getCategoryList().add(category);
        }

        lookupRepository.save(lookupObject);

    }

    public void deleteCategory(String categoryName) {
        LookupObject lookupObject = lookupRepository
                .findAll()
                .iterator()
                .next();

        AtomicReference<Category> foundCategory = new AtomicReference<>();

        lookupObject
                .getCategoryList()
                .stream()
                .filter(c -> c.getName().equalsIgnoreCase(categoryName))
                .findFirst()
                .ifPresent(c1 -> foundCategory.set(c1));

        lookupObject.getCategoryList().remove(foundCategory.get());

        lookupRepository.save(lookupObject);
    }
}
