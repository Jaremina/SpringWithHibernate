package pl.akademiakodu.giflib.repository;

import pl.akademiakodu.giflib.model.Category;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
public interface CategoryRepository {

    List<Category> findAll();
    Category findById(Long id);
    void save();
    void delete(Category category);

}
