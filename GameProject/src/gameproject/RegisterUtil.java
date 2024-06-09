/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohsen Porouhan
 */
public abstract class RegisterUtil {

    private String s1 = new String();
    private String s2 = new String();
    private String s3 = new String();
    private boolean result;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public String getUserName() {
        return s2;
    }

    public String getPassword() {
        return s3;
    }

    public RegisterUtil(String fullName, String userName, String password) {
        this.s1 = fullName.trim();
        this.s2 = userName.trim();
        this.s3 = password.trim();
    }
    public abstract String fullNameFetch();
    public abstract boolean passwordCheck();
    
    public void rafWrite() {
        try {
            RandomAccessFile raf = new RandomAccessFile("src\\file\\register.txt", "rw");
            if (raf.length() > 0) {
                raf.seek(raf.length());
                raf.writeBytes("\r\n");
            }
            raf.writeBytes("@" + this.s1 + "\r\n");
            raf.writeBytes(this.s2 + "\r\n");
            raf.writeBytes(this.s3);
            JOptionPane.showMessageDialog(null, "You successfully registered");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean fullNameCheck() {
        try {
            File f = new File("src\\file\\register.txt");
            if (!f.exists()) {
                f.createNewFile();
            }
            BufferedReader br = new BufferedReader(new FileReader("src\\file\\register.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.startsWith("@")) {
                    if (line.equals("@" + this.s1)) {
                        this.result = true;
                        break;
                    } else {
                        this.result = false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.result;
    }

    public boolean userNameCheck() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\file\\register.txt"));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals(this.s2)) {
                    this.result = true;
                    break;
                } else {
                    this.result = false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.result;
    }

    public String elementValueCheck() {
        if (this.s1.isEmpty()) {
            return this.msg = "Please Enter FullName";
        } else if (this.s2.isEmpty()) {
            return this.msg = "Please Enter UserName";
        } else if (this.s3.isEmpty()) {
            return this.msg = "Please Enter Password";
        }
        return null;
    }

    public String lengthOFCharCheck() {
        if (!s1.matches("^.{4,8}$")) {
            return this.msg = "Matches any string between 4 and 8 characters in length for full name";
        } else if (!s2.matches("^.{4,8}$")) {
            return this.msg = "Matches any string between 4 and 8 characters in length for user name";
        } else if (!s3.matches("^.{6,8}$")) {
            return this.msg = "Matches any string between 6 and 10 characters in length for password";
        } else {
            return null;
        }

    }

    public boolean equalCheck() {
        if (this.s1.equals(this.s2)) {
            this.result = true;
        }
        return this.result;
    }
}
