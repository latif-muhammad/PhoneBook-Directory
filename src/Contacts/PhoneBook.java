package Contacts;

import java.util.ArrayList;
import java.util.Objects;

public class PhoneBook {
    private final BST[] alpha = new BST[26];

    public PhoneBook() {
        //Initialize
        for (int i = 0; i < 26; i++) {
            alpha[i] = new BST();
        }
    }

    //Adding Contacts
    public void addContacts(String name, String num, String email) {
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        alpha[tempAscii].insert(name, num, email);
    }

    //Printing
    public ArrayList<node> printContacts(){
        ArrayList<node> temp = new ArrayList<>();
        for (int i = 0; i<26; i++){
            System.out.println(((char) ((i + 65))) + " _____________________");
            alpha[i].LNR(alpha[i].root, temp);
            System.out.println("______________________________________________");
        }
        return temp;
    }
    //Delete
    public node deleteContact(String name){
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        return alpha[tempAscii].Delete(name);
    }
    // Searching
    public ArrayList<node> searchContacts(String name){
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        return alpha[tempAscii].find(name);
    }
    public void edit(String name, String to, String num, String mail) {
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        String tempN = alpha[tempAscii].find(name).get(0).number;
        String tempe = alpha[tempAscii].find(name).get(0).email;
        String tname = alpha[tempAscii].find(name).get(0).name;

        if(!Objects.equals(tname, to)){
            int t2 = (((int) to.charAt(0)) + 7) % 26;
            alpha[tempAscii].Delete(name);
            alpha[t2].insert(to,tempN,tempe);
        }else{
            alpha[tempAscii].edit(name,num, mail);
        }
    }
}
