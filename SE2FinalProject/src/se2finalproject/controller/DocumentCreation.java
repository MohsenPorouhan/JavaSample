/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2finalproject.controller;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Mohsen
 */
public class DocumentCreation extends Thread {

    List propertyList;
    ObjectCreation objectCreaton;
    private static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(DocumentCreation.class);
    public void setPropertyList(List propertyList) {
        this.propertyList = propertyList;
    }

    public List getPropertyList() {
        return propertyList;
    }

    public DocumentCreation(ObjectCreation objectCreaton) {
         this.objectCreaton=objectCreaton;
    }

    @Override
    public void run(){
        while (true) {
            
                try {
                    synchronized (this) {
                    wait();
                    }
                } catch (InterruptedException ex) {

                    Logger.getLogger(DocumentCreation.class.getName()).log(Level.SEVERE, null, ex);
                    logger.fatal("InterruptedException");
                }
            
                Document document = DocumentHelper.createDocument();
               
                Element personElement = document.addElement("person");

                Element firstNameElement = personElement.addElement("firstName");
                firstNameElement.addText(this.getPropertyList().get(0).toString());

                Element lastNameElement = personElement.addElement("lastName");
                lastNameElement.addText(this.getPropertyList().get(1).toString());

                Element ageElement = personElement.addElement("age");
                ageElement.addText(this.getPropertyList().get(2).toString());

                Element birthDateElement = personElement.addElement("birthDate");
                birthDateElement.addText(this.getPropertyList().get(3).toString());
                objectCreaton.document=document;
                synchronized(objectCreaton){
                    
                     objectCreaton.notify();
                }
//                OutputFormat outputFormat = OutputFormat.createPrettyPrint();
//
//                XMLWriter xmlWriter = null;
//                try {
//                    xmlWriter = new XMLWriter(System.out, outputFormat);
//                } catch (UnsupportedEncodingException ex) {
//                    Logger.getLogger(DocumentCreation.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                    xmlWriter.write(document);
//                } catch (IOException ex) {
//                    Logger.getLogger(DocumentCreation.class.getName()).log(Level.SEVERE, null, ex);
//                }
            
        }
    }
}
