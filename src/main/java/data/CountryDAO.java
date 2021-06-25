package data;

import model.Continent;
import model.Country;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    private EntityManagerFactory connection;


    public CountryDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }


    public Country getCountryById(int id) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        return entityManager.find(Country.class , id);
    }

    public List<Country> getAllCountries() throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        Query query = entityManager.createQuery("Select * from Country");
        List<Country> countList = query.getResultList();
        return countList;
    }


    public void addCountry(Country country) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(country);
        entityManager.getTransaction().commit();
    }

    public void updateCountry(Country country) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(country);
        entityManager.getTransaction().commit();

    }
    public void deleteCountry(Country country) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(country);
        entityManager.getTransaction().commit();
    }
}
