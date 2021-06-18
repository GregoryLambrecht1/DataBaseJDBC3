package data;

import model.Continent;
import model.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContinentDAO {

    private Connection connection;

    public ContinentDAO() throws SQLException {
        connection = ConnectionFactory.getConnection();
    }

    //TODO: create update, delete and Insert methods

    public Continent getContinentById(int id) throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM Continent WHERE id = "+id+";";
        ResultSet resultSet = statement.executeQuery(select);
        Continent continent = null;
        while (resultSet.next())
            continent = new Continent(resultSet.getInt("Id"),resultSet.getString("name"));
        return continent;
    }


    public List<Continent> getAllContinents() throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM Continent;";
        ResultSet resultSet = statement.executeQuery(select);
        List<Continent> continentList = new ArrayList<>();
        while (resultSet.next()){
            Continent continent =
                    new Continent(resultSet.getInt("Id"),resultSet.getString("name"));
            continentList.add(continent);
        }
        return continentList;
    }

    public Continent getContinentByCountry(Country country) throws SQLException {
        Statement statement = connection.createStatement();
        String select = "SELECT * FROM Continent WHERE id = "+country.getContinentId()+";";
        ResultSet resultSet = statement.executeQuery(select);
        Continent continent = null;
        while (resultSet.next())
            continent = new Continent(resultSet.getInt("Id"),resultSet.getString("name"));
        return continent;
    }

    public void addContinent(Continent continent) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("INSERT INTO Continent (name) VALUES (?);");
        preparedStatement.setString(1, continent.getName());
        preparedStatement.execute();
    }

    public void updateContinent(Continent continent, int id) throws SQLException {
        PreparedStatement preparedStatement =
                connection.prepareStatement("Update Continent SET name= ?, id = ? WHERE id = ?;");
        preparedStatement.setString(1, continent.getName());
        preparedStatement.setInt(2, continent.getId());
        preparedStatement.setInt(3, id);
        preparedStatement.execute();

    }
    public void deleteContinent(Continent continent) throws SQLException {
        Statement statement = connection.createStatement();
        String delete= "Delete FROM Continent WHERE id = "+continent.getId()+";";
        statement.executeUpdate(delete);
    }


}
