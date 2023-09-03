package Contacts;
import java.util.ArrayList;
import java.util.Objects;

public class BST {
    node root;
    public void insert(String name, String number, String mail) {
        node newNode = new node(name, number, mail);
        if (root == null) {
            root = newNode;
        } else {
            node Temp = root;
            node p = Temp;
            while (Temp != null) {
                p = Temp;
                if (name.compareTo(Temp.name) < 0) {
                    Temp = Temp.left;
                } else Temp = Temp.right;
            }
            if (name.compareTo(p.name) < 0) p.left = newNode;
            else p.right = newNode;
        }

    }
    public void LNR(node n, ArrayList<node> listOfCon) {
        if (n == null) {
            return;
        }
        LNR(n.left,listOfCon);
        System.out.println(n.name + " " + n.number + " " + n.email);
        listOfCon.add(n);
        LNR(n.right, listOfCon);
    }

    public ArrayList<node> find(String key) {
        ArrayList<node> con = new ArrayList<>();
        if (root == null) return null;
        else {
            node Temp = root;
            while (Temp != null) {
                int toSub = Temp.name.indexOf(' ');
                String subS = toSub != -1 ? Temp.name.substring(0, toSub) : "";
                if ((Objects.equals(Temp.name, key)) || subS.equals(key)) {
                    con.add(Temp);
                }
                if (key.compareTo(Temp.name) < 0) {
                    Temp = Temp.left;
                } else Temp = Temp.right;
            }
            return con;
        }
    }

    //min

    public node Minimum() {
        if (root.left == null)
            return root;
        else {
            node Temp = root;
            node p = Temp;
            while (Temp != null) {
                p = Temp;
                Temp = Temp.left;
            }
            return p;
        }

    }

    //max
    public node Maximum() {
        if (root.right == null) return root;
        else {
            node Temp = root;
            node p = Temp;
            while (Temp != null) {
                p = Temp;
                Temp = Temp.right;
            }
            return p;
        }
    }

    //no child deletion
    public void deleteNoChild(node t, node p) {
        if (t != root) {
            if (p.left == t) {
                p.left = null;
            } else {
                p.right = null;
            }
        } else {
            root = null;
        }
    }

    //two child deletion
    public void deleteOneChild(node t, node p) {
        node child = (t.left != null) ? t.left : t.right;
        if (t != root) {
            if (t == p.left) {
                p.left = child;
            } else {
                p.right = child;
            }
        } else {
            root = child;
        }
    }


    //one child deletion
    public node Delete(String name) {
        node p = null;
        node t = root;

        while (t != null && t.name.compareTo(name) != 0) {
            p = t;
            if (name.compareTo(t.name) < 0) {
                t = t.left;
            } else {
                t = t.right;
            }
        }
        if (t == null) {
            return root;
        }

        // No child
        if (t.left == null && t.right == null) {
            deleteNoChild(t, p);
        }


        else if (t.left != null && t.right != null){
            node successor = Minimum();
            String val = successor.name;
            Delete(successor.name);
            t.name = val;
        }
        // only one child
        else if (t.left != null || t.right != null) {
            deleteOneChild(t, p);
        }
        // two children

        return root;
    }
    public void edit(String name, String numTo, String emailTo){
        find(name).get(0).number = numTo;
        find(name).get(0).email = emailTo;
    }

}