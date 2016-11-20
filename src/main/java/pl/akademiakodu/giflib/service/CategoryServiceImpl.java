package pl.akademiakodu.giflib.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.akademiakodu.giflib.model.Category;
import pl.akademiakodu.giflib.repository.CategoryRepository;

import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save() {

    }

    @Override
    public void delete(Category category) {

    }
}
