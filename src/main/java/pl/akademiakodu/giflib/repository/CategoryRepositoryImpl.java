package pl.akademiakodu.giflib.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.Category;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
            criteriaQuery.from(Category.class);

            List<Category> categories = session.createQuery(criteriaQuery).getResultList();

            return categories;
        }
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
