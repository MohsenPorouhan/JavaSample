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
 * @author Mohsen //Class score is created in login class
 */
public class Score {

    private String fullName;
    private int score=0;
    private ArrayList topScore;

    public Score(String fullName) {
        this.fullName = fullName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        if(score<0)
            this.score=0;
        else
        this.score = score;
    }

    public void wrightScore() {
        try {
            //StringIndexOutOfBoundsException
            String line;
            String line2 = "trick";
            int length = 0;
            RandomAccessFile raf = new RandomAccessFile("src//file//score.txt", "rw");
            while ((line = raf.readLine()) != null) {
                length = line.length();
                if (line.startsWith("@") && this.fullName.equals(line.substring(1))) {
                    line2 = line;
                    raf.writeBytes(this.score + "  ");
                }
            }
            if (!line2.substring(1).equals(this.fullName)) {
                if (length > 0) {
                    raf.writeBytes("\r\n@" + this.fullName);
                    raf.writeBytes("\r\n" + this.score + "    ");
                } else {
                    raf.writeBytes("@" + this.fullName);
                    raf.writeBytes("\r\n" + this.score + "    ");
                }
            }
            raf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int readScore() {
        //int score=0;
        try {
            String line;
            int score=0;
            RandomAccessFile raf = new RandomAccessFile("src//file//score.txt", "rw");
            while ((line = raf.readLine()) != null) {
                if (line.equals("@" + this.fullName)) {
                    while ((line = raf.readLine()) != null && !line.startsWith("@")) {
                        score = Integer.parseInt(line.trim());
                        this.score=score;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.score;
    }

    public ArrayList topScore() {
        try {
            String line;
            int maxScore=0;
            int score;
            String fullName;
            ArrayList topScore=new ArrayList();
            RandomAccessFile raf = new RandomAccessFile("src//file//score.txt", "r");
            while ((line = raf.readLine()) != null) {
                    if (!line.startsWith("@")) {
                        score = Integer.parseInt(line.trim());
                        if(score>=maxScore){
                            maxScore=score;
                        }
                    }
            }
            raf.seek(0);
            while ((line = raf.readLine()) != null) {
                if (line.startsWith("@")) {
                    fullName=line;
                    while ((line = raf.readLine()) != null && !line.startsWith("@")) {
                        score = Integer.parseInt(line.trim());
                        if(score>=maxScore){
                            maxScore=score;
                            topScore.add(fullName.substring(1));
                            topScore.add(maxScore);
                        }
                        break;
                    }
                }
            }
            this.topScore=topScore;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return this.topScore;
    }
}
