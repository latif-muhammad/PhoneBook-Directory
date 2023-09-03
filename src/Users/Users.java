package Users;

import Contacts.PhoneBook;

public class Users {
    private final userBST[] userArray = new userBST[26];
    public Users(){
        for (int i = 0; i < 26; i++) {
            userArray[i] = new userBST();
        }
    }
    public void addUser(String name, String pass, PhoneBook phoneBook) {
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        userArray[tempAscii].insert(name,pass, phoneBook);
    }

    //find
    public userNode searchUser(String name, String pass){
        String temp = name.toLowerCase();
        int tempAscii = (((int) temp.charAt(0)) + 7) % 26;
        return userArray[tempAscii].findUser(name, pass);
    }

    public void printContacts(){
        for (int i = 0; i<26; i++){
//            System.out.println(((char) ((i + 65))) + " _____________________");
            userArray[i].LNR(userArray[i].root);
//            System.out.println("______________________________________________");
        }
    }

}
