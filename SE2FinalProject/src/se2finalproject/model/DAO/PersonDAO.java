/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.model.DAO;

import se2finalproject.controller.DocumentCreation;
import se2finalproject.model.DTO.PersonDTO;
import se2finalproject.model.DataBaseUtil.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mohsen
 */
public class PersonDAO {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DocumentCreation.class);
    public int addPersonDTO(PersonDTO personDTO) {
        String query = "insert into person values(person_sequence.nextval,?,?,?,to_date(?,'dd/mm/yyyy'))";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataSource.getBasicDataSource().getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, personDTO.getFirstName());
            preparedStatement.setString(2, personDTO.getLastName());
            preparedStatement.setInt(3, personDTO.getAge());
            preparedStatement.setString(4,  personDTO.getBirthDate());
            int n = preparedStatement.executeUpdate();
            return n;
        } catch (SQLException e) {
            logger.fatal("SQLException in addPersonDTO method");
            e.printStackTrace();
            return -1;
        } finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                logger.fatal("SQLException in addPersonDTO method");
                e.printStackTrace();
            }
        }
    }

    public List<PersonDTO> getAllPersonDTO(){
        String query = "select firstName,lastName,age,to_char(birthDate,'dd/mm/yyyy')birthDate from person order by id desc";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DataSource.getBasicDataSource().getConnection();
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<PersonDTO> list = new ArrayList<PersonDTO>();
            while (resultSet.next()) {
                PersonDTO personDTO = new PersonDTO();
                personDTO.setFirstName(resultSet.getString(1));
                personDTO.setLastName(resultSet.getString(2));
                personDTO.setAge(resultSet.getInt(3));
                personDTO.setBirthDate(resultSet.getString(4));
                list.add(personDTO);
            }
            return list;
        } catch (SQLException e) {
            logger.fatal("SQLException in getAllPersonDTO method");
            e.printStackTrace();
            return null;
        }finally {
            try {
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                logger.fatal("SQLException in getAllPersonDTO method");
                e.printStackTrace();
                return null;
            }
        }
    }

}
