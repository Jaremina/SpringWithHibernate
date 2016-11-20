package pl.akademiakodu.giflib.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

            return  session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Category category) {
    }
}
