import Contacts.PhoneBook;
import Users.Users;
import Users.userNode;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        PhoneBook newPhoneBook = new  PhoneBook();
        Users useME = new Users();
        useME.addUser("master","1234", newPhoneBook);
        useME.addUser("hello","1234", newPhoneBook);
        useME.addUser("sadf","1234", newPhoneBook);

        //Control Flow
        userNode ADMIN;
        userNode temp = useME.searchUser("hello", "1234");
        if(temp!=null) {
            ADMIN = temp;

            //Add contact
            ADMIN.newPhoneBook.addContacts("sdasir", "888","dd@sdf.com");
            ADMIN.newPhoneBook.addContacts("sfbcd", "888","dd@sdsd.com");
            ADMIN.newPhoneBook.addContacts("abs", "12345678","sss@gmail.com");
            ADMIN.newPhoneBook.addContacts("stameer", "888","dd@banda.com");
            ADMIN.newPhoneBook.addContacts("syatif", "888","sd@sds.com");


            //Print

            userNode a = useME.searchUser("master", "1234");

//            ArrayList list = a.newPhoneBook.printContacts();
//            System.out.println("my List " + list.size());

            //Deleting
            ADMIN.newPhoneBook.edit("sdasir", "to","234444","yas@gmail.com");
            System.out.println("help");
            ADMIN.newPhoneBook.printContacts();


        }
        else System.out.println("username or password incorrect");
        //Control

        userNode a = useME.searchUser("master", "1234");
        a.newPhoneBook.printContacts();


    }
}