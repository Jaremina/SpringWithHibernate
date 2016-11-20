package pl.akademiakodu.giflib.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.Gif;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Jaremina on 2016-11-20.
 */
@Repository
public class GifRepositoryImpl implements GifRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Gif> findAll() {

        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery <Gif> criteriaQuery = criteriaBuilder.createQuery(Gif.class);
            criteriaQuery.from(Gif.class);

            return  session.createQuery(criteriaQuery).getResultList();
        }
    }

    @Override
    public Gif findByID(Long id) {
        try(Session session = sessionFactory.openSession()){
            return session.get(Gif.class, id);
        }
    }

    @Override
    public void save(Gif gif) {
        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            session.save(gif);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Gif gif) {
        try(Session session= sessionFactory.openSession()){
            session.beginTransaction();
            session.delete(gif);
            session.getTransaction().commit();
        }
    }
}
