/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author Mohsen
 */
public class City {

    private final Country country;
    private String rightAnswer;
    private ArrayList finalList;

    public City(Country country) {
        this.country = country;
        this.setRightAnwser();
        this.setFinalList();
    }

    //Pass country question parameter to setRightAnswer method.
    private void setRightAnwser() {
        try {
            String line = null;
            double index;
            int i = 0;
            ArrayList al = new ArrayList();
            //BufferedReader br = new BufferedReader(new FileReader("src/file/country&city.txt"));
            RandomAccessFile raf = new RandomAccessFile("src/file/country&city.txt", "r");
            while ((line = raf.readLine()) != null) {
                if (line.equals(this.country.getCountryInQuestion())) {
                    //System.out.println(country.getCountryInQuestion());
                    while ((line = raf.readLine()) != null && !line.startsWith("@")) {
                        al.add(i, line);
                        i++;
                    }
                }
            }
            index = Math.round(Math.floor(Math.random() * al.size()));
            this.rightAnswer = al.get(((int) index)).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setFinalList() {
        try {
            String line = null;
            ArrayList al = new ArrayList();
            ArrayList al2 = new ArrayList();
            for (int i = 0; i < 5; i++) {
                al2.add(i, null);
            }
            double index;
            RandomAccessFile raf = new RandomAccessFile("src/file/country&city.txt", "r");
            for (int i = 0; i < this.country.getFinalList().size(); i++) {
                if (!this.country.getFinalList().get(i).equals(this.country.getCountryInQuestion())) {
                    raf.seek(0);
                    while ((line = raf.readLine()) != null) {
                        if (this.country.getFinalList().get(i).equals(line)) {
                            while ((line = raf.readLine()) != null && !line.startsWith("@")) {
                                al.add(line);
                            }
                            index = Math.round(Math.floor(Math.random() * al.size()));
                            al2.remove(i);
                            al2.add(i, al.get((int) index));
                            al.removeAll(al);
                        }
                    }
                }

            }
            for (int i = 0; i < 5; i++) {
                if (al2.get(i) == null) {
                    al2.remove(i);
                    al2.add(i, this.rightAnswer);
                }
            }
            this.finalList = al2;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Country getCountry() {
        return country;
    }

    public String getRightAnwser() {
        return rightAnswer;
    }

    public ArrayList getFinalList() {
        return finalList;
    }

}
