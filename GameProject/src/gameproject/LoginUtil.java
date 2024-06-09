/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohsen
 */
public class LoginUtil extends RegisterUtil {

    private String FullName;
    private boolean password;

    @Override
    public boolean passwordCheck() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\file\\register.txt"));
            //RandomAccessFile r=new RandomAccessFile("src\\file\\register.txt","rw");
            String line = null;
            String uline = null; 
            while ((line = br.readLine()) != null ) {
                if (line.equals(getUserName())) {
                    //JOptionPane.showMessageDialog(null, fline);
                    //JOptionPane.showMessageDialog(null, line);
                    uline = line;
                        while ((line = br.readLine()) != null && !line.startsWith("@")) {
                               if (getPassword().equals(line) && getUserName().equals(uline)) {
//                    JOptionPane.showMessageDialog(null, line);
//                    JOptionPane.showMessageDialog(null, uline);
                    this.password = true;
                    break;
                } else {
                    this.password = false;
                }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.password;
    }

    @Override
    public String fullNameFetch() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\file\\register.txt"));
            String line = null;
            String fline = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    fline = line;
                }
                if (line.equals(getUserName())) {
                    //JOptionPane.showMessageDialog(null, fline);
                    //JOptionPane.showMessageDialog(null, line);
                    this.FullName = fline;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.FullName;
    }


    public LoginUtil(String fullName, String userName, String password) {
        super(fullName, userName, password);
        
    }

    @Override
    public boolean userNameCheck() {
        return super.userNameCheck(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getMsg() {
        return super.getMsg(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String elementValueCheck() {
        return super.elementValueCheck(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String lengthOFCharCheck() {
        return super.lengthOFCharCheck(); //To change body of generated methods, choose Tools | Templates.
    }

}
