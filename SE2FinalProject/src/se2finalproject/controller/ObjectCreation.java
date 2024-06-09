/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.controller;

import org.dom4j.Document;
import org.dom4j.Node;
import se2finalproject.model.DTO.PersonDTO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 *
 * @author Mohsen
 */
public class ObjectCreation extends Thread {

    Document document;
    Insertion insertion;
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DocumentCreation.class);
    public ObjectCreation(Insertion insertion) {
        this.insertion = insertion;
    }

    public void run() {
        while (true) {
            try {
                synchronized (this) {
                    wait();
                }

            } catch (InterruptedException e) {
                logger.fatal("InterruptedException");
                e.printStackTrace();

            }
            List<Node> list = this.document.selectNodes("/person"); //Xpath style
            String firstName = null;
            String lastName = null;
            int age = 0;
            String birthDate = null;

            for (Node node : list) {
                firstName = node.selectSingleNode("firstName").getText();
                lastName = node.selectSingleNode("lastName").getText();
                age = Integer.parseInt(node.selectSingleNode("age").getText());
                birthDate =node.selectSingleNode("birthDate").getText();
            }
            List list2 = new ArrayList();
            list2.add(new PersonDTO(firstName, lastName, age, birthDate));
            ResourceBundle resourceBundle = ResourceBundle.getBundle("fileInfo");
            String path = resourceBundle.getString("fos.path");
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(path);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(list2);
                objectOutputStream.close();
                fileOutputStream.close();
            } catch (Exception e) {
                logger.fatal("FileOutputStreamException");
                e.printStackTrace();
            }
            synchronized (this.insertion) {
                this.insertion.notify();
            }
        }

    }
}
