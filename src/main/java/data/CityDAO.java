package data;

import model.City;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

public class CityDAO {
    private EntityManagerFactory connection;


    public CityDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }


    public City getCityById(int id) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        return entityManager.find(City.class , id);
    }

    public List<City> getAllCities() throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        Query query = entityManager.createQuery("Select c from City c ");
        List<City> cityList = query.getResultList();
        return cityList;
    }


    public void addCity(City city) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.getTransaction().commit();
    }

    public void updateCity(City city) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(city);
        entityManager.getTransaction().commit();

    }
    public void deleteCity(City city) throws SQLException {
        EntityManager entityManager = connection.createEntityManager();
        City c = entityManager.find(City.class,city.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(c);
        entityManager.getTransaction().commit();
    }
}
