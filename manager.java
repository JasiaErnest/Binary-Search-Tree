public class manager<E> {
    searchTreeNode<String> root; 
    public void BSTManager() { 
        this.root = null; 
    }
    public void insert(searchTreeNode<String> node) { 
        if (root == null) { 
            root = node; 
            return; 
        } 
        searchTreeNode<String> current = root; 
        searchTreeNode<String> parent; 
        while (true) { 
            parent = current; 
            if (node.primaryKey.compareTo(current.primaryKey) < 0) { 
                current = current.left; 
                if (current == null) { 
                    parent.left = node; 
                    return; 
                } 
            } else { 
                current = current.right; 
                if (current == null) { 
                    parent.right = node; 
                return; 
            } 
        } 
    }
    }

    searchTreeNode<String> search(String primaryKey) { 
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

    public void inorder() { 
        inorderRec(this.root); 
    } 
    private void inorderRec(searchTreeNode<String> root) { 
        if (root != null) { 
            inorderRec(root.left); 
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName); 
            inorderRec(root.right); 
        } 
    }

    public void preorder() { 
        preorderRec(this.root); 
    } 
    private void preorderRec(searchTreeNode<String> root) { 
        if (root != null) { 
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName); 
            preorderRec(root.left); 
            preorderRec(root.right); 
        } 
    } 
    
    public void postorder() { 
        postorderRec(this.root); 
    } 
    private void postorderRec(searchTreeNode<String> root) { 
        if (root != null) { 
            postorderRec(root.left); 
            postorderRec(root.right); 
            System.out.println(root.primaryKey + ": " + root.firstName + " " + root.lastName); 
        } 
    }

    private searchTreeNode<String> findMin(searchTreeNode<String> root) { 
        while (root.left != null) { 
            root = root.left; 
        } 
        return root; 
    }

    public void delete(String primaryKey) { 
        searchTreeNode<String> current = root; 
        searchTreeNode<String> parent = null; 
        while (current != null && !current.primaryKey.equals(primaryKey)) { 
            parent = current; 
            if (primaryKey.compareTo(current.primaryKey) < 0) { 
                current = current.left; 
            } else { 
                current = current.right; 
            } 
        } if (current == null) { 
            return; // Key not found 
        } 

        if (current.left == null && current.right == null) { 
            if (current != root) { 
                if (parent.left == current) { 
                    parent.left = null; 
                } else { 
                    parent.right = null; 
                } 
            } else { root = null; 
            } 
        } else if (current.left != null && current.right != null) { 
            searchTreeNode<String> successor = findMin(current.right); 
            String val = successor.primaryKey; 
            delete(successor.primaryKey); 
            current.primaryKey = val; 
        } else { 
            searchTreeNode<String> child = (current.left != null) ? current.left : current.right; 
            if (current != root) { 
                if (current == parent.left) { 
                    parent.left = child; 
                } else { parent.right = child; 
                } 
            } else { 
                root = child; 
            } 
        } 
    }

    public void modify(String primaryKey, String firstName, String lastName, String streetAddress, String city, String state, String zip, String email, String phoneNum) { 
        searchTreeNode<String> node = search(primaryKey); 
        if (node != null) { 
            node.firstName = firstName; 
            node.lastName = lastName; 
            node.streetAddress = streetAddress; 
            node.city = city; 
            node.state = state; 
            node.zip = zip; 
            node.email = email; 
            node.phoneNum = phoneNum; 
        } 
    }
}
