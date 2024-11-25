//Name: Jasia Ernest
//Assignment: Lab 6 - Binary Search Tree
//Class: CS&145

public class searchTreeTest {
    public static void main(String[] args) {
        manager<String> searchTreeManager = new manager<String>(); 
        searchTreeNode<String> forInsert = new searchTreeNode<String>("1", "John", "Doe", "123 Elm St", "Anytown", "WA", "12345", "john.doe@example.com", "555-1234");
        searchTreeManager.insert(forInsert); 
        searchTreeManager.insert(new searchTreeNode<String>("2", "Jane", "Smith", "456 Oak St", "Othertown", "WA", "54321", "jane.smith@example.com", "555-5678")); 
        System.out.println("Inorder Traversal of Tree:"); 
        searchTreeManager.inorder(); 
        System.out.println("\nPreorder Traversal of Tree:"); 
        searchTreeManager.preorder(); 
        System.out.println("\nPostorder Traversal of Tree:"); 
        searchTreeManager.postorder(); 
        searchTreeNode<String> foundNode = searchTreeManager.search("1"); 
        if (foundNode != null) { 
            System.out.println("\nNode found: " + foundNode.firstName + " " + foundNode.lastName); 
        } else { 
            System.out.println("\nNode not found"); 
        } 
        searchTreeManager.modify("1", "John", "Bo", "789 Pine St", "Newtown", "WA", "67890", "john.doe@newemail.com", "555-9876"); 
        System.out.println("\nAfter modification:"); 
        searchTreeManager.inorder(); 
        searchTreeManager.delete("1"); 
        System.out.println("\nAfter deletion:"); 
        searchTreeManager.inorder();
    }
}