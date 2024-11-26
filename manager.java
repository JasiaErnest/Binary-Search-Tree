import java.util.Stack;

public class manager<E> {

    searchTreeNode<String> root; 
    
    public manager() { 
        this.root = null; 
    }

    //A method to add a new account (node)
    public void add(searchTreeNode<String> account) { 
        //Checks if the binary search tree is empty
        if (root == null) { 
            root = account; //Adds the account to the binary search tree
            return; 
        } 
        searchTreeNode<String> current = root; //Declaring current as the first node that was added
        searchTreeNode<String> parent; 
        while (true) { 
            parent = current; //For adding 
            if (account.primaryKey.compareTo(current.primaryKey) < 0) { 
                current = current.left; //Traversing to the left of the current node
                if (current == null) { //Checks if it is occupied. If occupied, the while loop will continue. If not occupied:
                    parent.left = account; //Adds the account to the binary search tree
                    return; //Return statement to stop the while loop & get out of the method
                } 
            } else { 
                current = current.right; //Traversing to the right of the current node
                if (current == null) { //Checks if it is occupied. If occupied, the while loop will continue. If not occupied:
                    parent.right = account; //Adds the account to the binary search tree
                return; //Return statement to stop the while loop & get out of the method
            } 
        } 
    }
    }

    //A method to find the index of the user's account
    public String findUserIdx(String email) {
        if (root == null) return null; 
        Stack<searchTreeNode<String>> stack = new Stack<>(); 
        searchTreeNode<String> current = root; 
        while (current != null || !stack.isEmpty()) { 
            while (current != null) { 
                stack.push(current); 
                current = current.left; 
            } 
            current = stack.pop(); 
            if (current.email.equals(email)) { 
                return current.primaryKey; 
            } 
            current = current.right; } 
        return null;
    }

    public searchTreeNode<String> search(String primaryKey) { 
        searchTreeNode<String> current = root; 
        while (current != null) { 
            if (current.primaryKey.equals(primaryKey)) { 
                return current; 
            } else if (primaryKey.compareTo(current.primaryKey) < 0) { 
                current = current.left; 
            } else { 
                current = current.right; 
            } 
        } 
        return null; 
    }

    public void forPrint(searchTreeNode<String> root) {
        System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName);
        System.out.println("Address: " + root.streetAddress + ", " + root.city + ", " + root.state + ", " + root.zip);
        System.out.println("Email :" + root.email);
        System.out.println("Phone number: " + root.phoneNum); 
    }

    public void inorder() { 
        if (root == null) {
            System.out.println("This directory is empty");
            return; 
        }
        Stack<searchTreeNode<String>> stack = new Stack<>(); 
        searchTreeNode<String> current = root; 
        while (current != null || !stack.isEmpty()) { 
            while (current != null) { 
                stack.push(current); current = current.left; 
            } 
            current = stack.pop(); 
            forPrint(current); 
            current = current.right; 
        }
    }

    public void preorder() { 
        if (root == null) {
            System.out.println("This directory is empty");
            return; 
        } 
        Stack<searchTreeNode<String>> stack = new Stack<>(); 
        stack.push(root); 
        while (!stack.isEmpty()) { 
            searchTreeNode<String> node = stack.pop(); 
            forPrint(node);
            if (node.right != null) { 
                stack.push(node.right); 
            } 
            if (node.left != null) { 
                stack.push(node.left); 
        } }
    } 
    
    public void postorder() { 
        if (root == null) {
            System.out.println("This directory is empty");
            return; 
        }
        Stack<searchTreeNode<String>> stack1 = new Stack<>(); 
        Stack<searchTreeNode<String>> stack2 = new Stack<>(); 
        stack1.push(root);
        while (!stack1.isEmpty()) { 
            searchTreeNode<String> node = stack1.pop(); 
            stack2.push(node); 
            if (node.left != null) { 
                stack1.push(node.left); 
            } 
            if (node.right != null) { 
                stack1.push(node.right); 
            } 
        } 
        while (!stack2.isEmpty()) { 
            searchTreeNode<String> node = stack2.pop(); 
            forPrint(node);
    }
    }

    public void delete(String primaryKey) { 
        searchTreeNode<String> current = root; 
        searchTreeNode<String> parent = null; // Find the node to be deleted and its parent 
        while (current != null && !current.primaryKey.equals(primaryKey)) { 
            parent = current; 
            if (primaryKey.compareTo(current.primaryKey) < 0) { 
                current = current.left; 
            } else { 
                current = current.right; 
            } 
        } 
        
        if (current == null) return; 
        // Case 1: Node to be deleted has no children (is a leaf node) 
        if (current.left == null && current.right == null) { 
            if (current != root) { 
                if (parent.left == current) { 
                    parent.left = null; 
                } else { 
                    parent.right = null; 
                } 
            } else { 
                root = null; 
            } 
        } else if (current.left == null || current.right == null) { // Case 2: Node to be deleted has one child
            searchTreeNode<String> child = (current.left != null) ? current.left : current.right; 
            if (current != root) { 
                if (current == parent.left) { 
                    parent.left = child; 
                } else { 
                    parent.right = child; 
                } 
            } else { 
                root = child; 
            } 
        } else {     // Case 3: Node to be deleted has two children 
            searchTreeNode<String> successorParent = current; 
            searchTreeNode<String> successor = current.right; 
            while (successor.left != null) { 
                successorParent = successor; 
                successor = successor.left; 
            }
            current.primaryKey = successor.primaryKey; 
            if (successorParent != current) { 
                successorParent.left = successor.right; 
            } else { 
                current.right = successor.right; 
            } 
        }
    }

    //This method modifies a specific node in the binary search tree
    public void modify(String primaryKey, String firstName, String lastName, String streetAddress, String city, 
    String state, String zip, String email, String phoneNum) { 
        //Using the search method to search for the account (node) that the user wants to modify
        searchTreeNode<String> accountToModify = search(primaryKey); 
        //Overrides everything
        if (accountToModify != null) { 
            accountToModify.firstName = firstName; 
            accountToModify.lastName = lastName; 
            accountToModify.streetAddress = streetAddress; 
            accountToModify.city = city; 
            accountToModify.state = state; 
            accountToModify.zip = zip; 
            accountToModify.email = email; 
            accountToModify.phoneNum = phoneNum; 
        } 
    }
}
