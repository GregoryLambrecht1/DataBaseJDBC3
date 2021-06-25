package data;

import model.Continent;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;

import java.util.List;

public class ContinentDAO {

    private EntityManagerFactory connection;

    public ContinentDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    //TODO: create update, delete and Insert methods

    public Continent getContinentById(int id) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        return entityManager.find(Continent.class , id);
    }


    public List<Continent> getAllContinents() throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        Query query = entityManager.createQuery("Select c from Continent c");
        List<Continent> contList = query.getResultList();
        return contList;

    }

    public Continent getContinentByCountry(int country) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        return entityManager.find(Continent.class , country);
    }
    public void addContinent(Continent continent) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(continent);
        entityManager.getTransaction().commit();

    }

    public void updateContinent(Continent continent) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(continent);
        entityManager.getTransaction().commit();



    }
    public void deleteContinent(Continent continent) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(continent);
        entityManager.getTransaction().commit();
    }


}
