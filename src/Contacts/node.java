package Contacts;

class node {
    String name;
    String number;
    String email;

    node left;
    node right;

    node(String n, String nm, String e){
        this.name =n;
        this.number = nm;
        this.email =e;
    }
}