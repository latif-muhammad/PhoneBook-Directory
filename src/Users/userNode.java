package Users;
import Contacts.PhoneBook;

public class userNode {
    public String userName;
    public String pass;

    public PhoneBook newPhoneBook;
    userNode left;
    userNode right;


    public userNode(String userName, String pass, PhoneBook phoneBook) {
        this.pass = pass;
        this.userName = userName;
        this.newPhoneBook = phoneBook;
    }

}

