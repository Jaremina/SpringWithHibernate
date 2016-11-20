package pl.akademiakodu.giflib.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.giflib.model.AdvertismentProvider;

import javax.annotation.PostConstruct;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by Jaremina on 2016-11-19.
 */
@Repository
public class AdsProviderRepositoryImpl implements AdsProviderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<AdvertismentProvider> findAll() {


        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AdvertismentProvider> adsProviderQuery = builder.createQuery(AdvertismentProvider.class);
            adsProviderQuery.from(AdvertismentProvider.class);

            return session.createQuery(adsProviderQuery).getResultList();
        }
    }


    ////////// POLIGON ////////////////
    private Logger logger = LoggerFactory.getLogger(getClass());

    //@PostConstruct // wumysza uruchomienie tej metory po stworzeniu repozytorium
    public void poligon(){
        logger.info("utworzylismy ads provider repository!");

        //wypisz firmy po danym roku
        printCompaniesCreatedAfterYear(1990);
        //wypisz firmy ktore maja podwoja litere w nazwie "o"
        printCompaniesWithDoubleLetter('o');
        //wypisz firmy po danym roku lub  ktore maja  litere w nazwie
        printCompaniesCreatedAfterYearOrWithLetter(1995,'k');

    }

    @SuppressWarnings("unchecked")
    private void printCompaniesCreatedAfterYear (int year){

        /**
         *  SQL:
         *  SELECT *
         *  FROM ADS_PROV a
         *  WHERE a.created > year
         */
        // 1. Stare API
        try(Session session = sessionFactory.openSession()){
            Criteria criteria = session.createCriteria(AdvertismentProvider.class);
            List<AdvertismentProvider> advertismentProviders =
                    criteria.add(Restrictions.gt("yearCreated", year)).list();

            logger.info("stare API: " + advertismentProviders);
        }

        // 2. Nowe API (hibernate >=5.2.0

        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AdvertismentProvider> criteria = builder.createQuery(AdvertismentProvider.class);
            Root<AdvertismentProvider> from = criteria.from(AdvertismentProvider.class);// tabela ktora odpowiada tej klasie
            criteria.where(builder.gt(from.get("yearCreated"), year));

            List<AdvertismentProvider> result = session.createQuery(criteria).getResultList();
            logger.info("Nowe API: " + result);
        }

        // 3. HQL
        try(Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from AdvertismentProvider where yearCreated > :year");
            query.setParameter("year", year);
            List<AdvertismentProvider> result = query.getResultList();
            logger.info("HQL: " + result);
        }
    }

    @SuppressWarnings("unchecked")
    private void printCompaniesWithDoubleLetter(char letter){

        /**
         * SQL:
         *  SELECT *
         *  FROM ADS_PROV a
         *  WHERE name LIKE '%oo%'
         */

        String pattern = "%" + letter + letter + "%";

        //1
        try(Session session = sessionFactory.openSession()) {
            Criteria criteria = session.createCriteria(AdvertismentProvider.class);
            List<AdvertismentProvider> result = criteria.add(Restrictions.like("companyName",pattern)).list();
            logger.info("Stare API:  " + result);
        }

        //2
        try(Session session = sessionFactory.openSession()) {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AdvertismentProvider> query = builder.createQuery(AdvertismentProvider.class);
            Root<AdvertismentProvider> from = query.from(AdvertismentProvider.class);
            query.where(builder.like(from.get("companyName"), pattern));

            List<AdvertismentProvider> result = session.createQuery(query).getResultList() ;
            logger.info("Nowe API: " + result);
        }

        //3
        try(Session session = sessionFactory.openSession()) {
            Query query = session.createQuery("from AdvertismentProvider where companyName like :pattern");
            query.setParameter("pattern", pattern);
            List<AdvertismentProvider> result = query.getResultList();
            logger.info("HQL: " + result);
        }

    }

    @SuppressWarnings("unchecked")
    private void printCompaniesCreatedAfterYearOrWithLetter(int year, char letter){

        String pattern = "%" + letter + "%";
        //1
        try(Session session = sessionFactory.openSession()){
            Criteria criteria = session.createCriteria(AdvertismentProvider.class);
            List<AdvertismentProvider> result = criteria.add(
                    Restrictions.or(
                            Restrictions.gt("yearCreated", year),
                            Restrictions.like("companyName", pattern)
                    )
            ).list();
            logger.info("Stare API:  " + result);
        }

        //2
        try(Session session = sessionFactory.openSession()){
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<AdvertismentProvider> query = builder.createQuery(AdvertismentProvider.class);
            Root<AdvertismentProvider> from = query.from(AdvertismentProvider.class);
            query.where(
                    builder.or(
                            builder.like(from.get("companyName"), pattern),
                            builder.gt(from.get("yearCreated"),year)
                    )
            );

            List<AdvertismentProvider> result = session.createQuery(query).getResultList();
            logger.info("Nowe API:  " + result);
        }

        //3
        try(Session session = sessionFactory.openSession()){
            Query query = session.createQuery("from AdvertismentProvider where companyName like :pattern or " +
                    "                   yearCreated > :year");

            query.setParameter("pattern", pattern)
                    .setParameter("year", year); // podajemy parametry uzywane w criteriaQuery

            List<AdvertismentProvider> result = query.getResultList();
            logger.info("HQL:  " + result);
        }

    }

}
