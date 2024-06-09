/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.controller;

import se2finalproject.model.DAO.PersonDAO;
import se2finalproject.model.DTO.PersonDTO;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mohsen
 */
public class Insertion extends Thread {
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DocumentCreation.class);

    public static List<PersonDTO> getPersonList() {
        PersonDAO personDAO = new PersonDAO();
        return personDAO.getAllPersonDTO();
    }
    @Override
    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Insertion.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                ResourceBundle resourceBundle = ResourceBundle.getBundle("fileInfo");
                String path = resourceBundle.getString("fos.path");
                FileInputStream fileInputStream = new FileInputStream(path);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                Object object = objectInputStream.readObject();
                List list = (List) object;

                PersonDAO personDAO = new PersonDAO();
                for (int i = 0; i < list.size(); i++) {
                    PersonDTO person = (PersonDTO) list.get(i);
                    personDAO.addPersonDTO(person);
                }
            } catch (Exception e) {
                logger.fatal("FileInputStreamException");
                e.printStackTrace();
            }

        }

    }

}
