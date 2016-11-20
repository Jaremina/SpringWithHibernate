package pl.akademiakodu.giflib.service;


import pl.akademiakodu.giflib.model.Category;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
public interface CategoryService {

    List<Category> findAll();
    Category findById(Long id);
    void save();
    void delete(Category category);

}
