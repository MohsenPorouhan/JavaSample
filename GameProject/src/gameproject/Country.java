/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Mohsen
 */
public  class Country {

    private ArrayList<Object> countryList;
    private String countryQuestion;
    private ArrayList finalList;

    public Country() {
        this.setListOfCountry();
        this.setCountryINQuestion(this.getCountryList());
    }

    private void setListOfCountry() {
        try {
            String line = null;
            int i = 0;
            BufferedReader br = new BufferedReader(new FileReader("src/file/country&city.txt"));
            ArrayList al = new ArrayList();
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    al.add(i, line);
                    i++;
                }
            }
            this.countryList = al;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private ArrayList<Object> getCountryList() {
        return countryList;
    }

    private void setCountryINQuestion(ArrayList countryList) {
        double index = Math.round(Math.floor(Math.random() * countryList.size()));
        this.countryQuestion = countryList.get((int) index).toString();
        this.setFinalListCountry(this.countryQuestion);
    }

    public String getCountryInQuestion() {
        return countryQuestion;
    }
    

    private void setFinalListCountry(String questionP) {
        ArrayList finalList = new ArrayList(5);
        double index = Math.round(Math.floor(Math.random() * 5));
        //Finall list
        for (int i = 0; i < 5; i++) {
            finalList.add(i, null);
        }
        String question = questionP;
        finalList.remove((int) index);
        finalList.add((int) index, question);
        //System.out.println(question + "       Question");
        //System.out.println(finalList);
        ArrayList listOfCountry = this.getCountryList();
        listOfCountry.remove(question);
        //System.out.println(listOfCountry);
        //System.out.println(listOfCountry.size());
        for (int i = 0; i < 5; i++) {
            double index2 = Math.round(Math.floor(Math.random() * (listOfCountry.size())));
            if (i != (int) index) {
                finalList.remove(i);
                finalList.add(i, listOfCountry.get((int) index2).toString());
                listOfCountry.remove((int) index2);
            }
        }
        this.finalList= finalList;
    }

    public ArrayList getFinalList() {
        return finalList;
    }
    
}
