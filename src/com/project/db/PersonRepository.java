package com.project.db;

import com.project.models.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    private DBConnection dbConnection = new DBConnection();

    public void save(Person person) {
        String query = "INSERT INTO person_info (" +
                " name_p, " +
                " age, " +
                " address, " +
                " email " +
                ")" +
                "VALUES(?, ?, ?, ?)";

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(query);

            prepStatement.setString(1, person.getName());
            prepStatement.setInt(2, person.getAge());
            prepStatement.setString(3, person.getAddress());
            prepStatement.setString(4, person.getEmail());

            prepStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void update(Person person) {
        String query = "UPDATE person_info " +
                " SET name_p = ?, " +
                " age = ?, " +
                " address = ?, " +
                " email = ? " +
                " WHERE id = ? ";

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(query);

            prepStatement.setString(1, person.getName());
            prepStatement.setInt(2, person.getAge());
            prepStatement.setString(3, person.getAddress());
            prepStatement.setString(4, person.getEmail());
            prepStatement.setInt(5, person.getId());

            prepStatement.execute();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteById(int id) {
        String query = "DELETE " +
                " FROM person_info " +
                " WHERE id = ?";

        Person person = null;

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setInt(1, id);

            prepStatement.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Person> findAllPerson() {
        String query = "select  name_p as name, age, address as addr, email, id as p_id from person_info";
        List<Person> personList = new ArrayList<>();

        try {
            Connection connection = dbConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Person person = extractPersonFromResultSet(resultSet);
                personList.add(person);
            }

            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return personList;
    }

    public Person findById(int id) {
        String query = "SELECT " +
                " name_p as name, " +
                " age, address as addr, " +
                " email, " +
                " id as p_id " +
                " FROM person_info " +
                " WHERE id = ?";

        Person person = null;

        try(Connection connection = dbConnection.getConnection()) {
            PreparedStatement prepStatement = connection.prepareStatement(query);
            prepStatement.setInt(1, id);

            ResultSet resultSet = prepStatement.executeQuery();

            if(resultSet.next()) {
                person = extractPersonFromResultSet(resultSet);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        return person;
    }

    private Person extractPersonFromResultSet(ResultSet resultSet) throws SQLException {

        int personId = resultSet.getInt("p_id");
        String personName = resultSet.getString("name");
        int personAge = resultSet.getInt("age");
        String personAddress = resultSet.getString("addr");
        String personEmail = resultSet.getString("email");

        Person person = new Person(personId, personName, personAge, personAddress, personEmail);

        return person;
    }
}
