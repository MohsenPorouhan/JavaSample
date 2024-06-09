/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohsen
 */
public class GameProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

            Country country=new Country();
            System.out.println(country.getCountryInQuestion());
            System.out.println(country.getFinalList());
            City city=new City(country);
            System.out.println(city.getRightAnwser());
            System.out.println(city.getFinalList());
//JOptionPane.showOptionDialog(null, "jlk", null,
//                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE,
//                null, null, null);
            Score score=new Score("MohsenPo");
//            score.wrightScore();
//String s="";
//for (int i = 0; i < score.topScore().size(); i=i+2) {
//      s+=score.topScore().get(i)+", ";     
//        }
//        System.out.println(score.topScore().get(1)+"("+s.substring(0, s.length()-2)+")");

        System.out.println(score.topScore());

    }

}
