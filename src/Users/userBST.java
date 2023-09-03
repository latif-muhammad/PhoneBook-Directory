package Users;
import Contacts.PhoneBook;
import java.util.Objects;

public class userBST {

    userNode root;
    public void insert(String name, String pass, PhoneBook phoneBook) {
        userNode newNode = new userNode(name, pass, phoneBook);
        if (root == null) {
            root = newNode;
        } else {
            userNode Temp = root;
            userNode p = Temp;
            while (Temp != null) {
                p = Temp;
                if (name.compareTo(Temp.userName) < 0) {
                    Temp = Temp.left;
                } else Temp = Temp.right;
            }
            if (name.compareTo(p.userName) < 0) p.left = newNode;
            else p.right = newNode;
        }

    }

    public void LNR(userNode n) {
        if (n == null) {
            return;
        }
        LNR(n.left);
        System.out.println(n.userName + " " + n.pass);
        LNR(n.right);
    }

    public userNode findUser(String key, String password) {
        if (root == null) return null;
        else {
            userNode Temp = root;
            if (Objects.equals(root.userName, key) && Objects.equals(root.pass, password)) return root;
            while (Temp != null && !Objects.equals(Temp.userName, key) && Objects.equals(Temp.pass, password)) {
                if (key.compareTo(Temp.userName) < 0) {
                    Temp = Temp.left;
                } else Temp = Temp.right;
            }
            return Temp == root ? null : Temp;
        }
    }

    //min

    public userNode Minimum() {
        if (root.left == null)
            return root;
        else {
            userNode Temp = root;
            userNode p = Temp;
            while (Temp != null) {
                p = Temp;
                Temp = Temp.left;
            }
            return p;
        }

    }

    //max
    public userNode Maximum() {
        if (root.right == null) return root;
        else {
            userNode Temp = root;
            userNode p = Temp;
            while (Temp != null) {
                p = Temp;
                Temp = Temp.right;
            }
            return p;
        }
    }

    //no child deletion
    public void deleteNoChild(userNode t, userNode p) {
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
    public void deleteOneChild(userNode t, userNode p) {
        userNode child = (t.left != null) ? t.left : t.right;
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
    public userNode Delete(String name) {
        userNode p = null;
        userNode t = root;

        while (t != null && t.userName.compareTo(name) != 0) {
            p = t;
            if (name.compareTo(t.userName) < 0) {
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
            userNode successor = Minimum();
            String val = successor.userName;
            Delete(successor.userName);
            t.userName = val;
        }
        // only one child
        else if (t.left != null || t.right != null) {
            deleteOneChild(t, p);
        }
        // two children

        return root;
    }
}
