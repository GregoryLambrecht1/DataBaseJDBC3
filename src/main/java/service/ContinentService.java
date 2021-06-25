package service;

import data.ContinentDAO;
import model.Continent;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ContinentService {

    private ContinentDAO continentDAO;
    private Scanner scanner = new Scanner(System.in);

    public ContinentService() throws SQLException {
        continentDAO = new ContinentDAO();
    }

    public void showAllContinents()throws SQLException {
        List<Continent> continents = continentDAO.getAllContinents();
        for (Continent continent:continents){
            System.out.println(continent);
        }

    }
    public void showContinentById()throws SQLException {
        System.out.println("give me the id of the continent");
        int id = scanner.nextInt();
        Continent continent = continentDAO.getContinentById(id);
        System.out.println(continent);

    }
    public void insertAContinent()throws SQLException {
        System.out.println("give me the name of the continent");
        String name = scanner.next();
        Continent continent = new Continent();
        continentDAO.addContinent(continent);

    }
    public void updateContinent()throws SQLException {
        showAllContinents();
        System.out.println("choose the id of which continent to change");
        int originalID = scanner.nextInt();
        Continent continent = continentDAO.getContinentByCountry(originalID);


        System.out.println("type in the name if you want to change it prss 0 if you dont want to change anything");
        String newName = scanner.next();
        if (!newName.equals("0"))continent.setName(newName);

        continentDAO.updateContinent(continent);


    }
    public void deleteContinent() throws SQLException{
        showAllContinents();
        System.out.println("choose the id of which continent to delete");
        int originalId = scanner.nextInt();
        Continent continent = continentDAO.getContinentById(originalId);

        continentDAO.deleteContinent(continent);

    }

}
