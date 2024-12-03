/*This is a user directory. This program should be used by a manager as it shows all the accounts and allows to delete
any account as well as modify an account. When I refer to the user, I mean the person using this program, in this case,
a manager*/

import java.util.Scanner;

public class searchTreeTest {
    //Accessing the manager class
    public static manager<String> searchTreeManager = new manager<String>(); 
    
    //Main method : Method to arrange all the other methods so the program would work
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("This is a binary search tree");
        //Boolean to keep track of whether the user wants to continue using the program
        boolean run = true;
        //Integer to make sure that every user index is unique by tracking the last index
        int lastIdx = 0;
        while (run) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add an account");
            System.out.println("2. Delete an account");
            System.out.println("3. Modify an account");
            System.out.println("4. Print the entire directory");
            System.out.println("5. Exit");
            int userChoice = scan.nextInt();
            switch (userChoice) {
                case 1:
                    //Updating the last index that has already been assigned to an account
                    lastIdx = addNode(scan, lastIdx);
                    break;
                case 2:
                    deleteNode(scan);
                    break;
                case 3:
                    modifyNode(scan);
                    break;
                case 4:
                    printBST(scan);
                    break;
                case 5:
                    System.out.println("Thank you for using our program!");
                    run = false; //Ending the while loop
                    break;
                default:
                    //Message if the user enters an invalid input
                    System.out.println("This is not a valid choice. Please try again.");
                    System.out.println("Remember; the valid choices are 1, 2, 3, 4, 5");
                    break;
            }
        } 
    }

    //Method to add a account (node) to the binary search tree
    public static int addNode(Scanner scan, int lastIdx) {
        scan.nextLine(); //scan.nextLine so the next scan.nextLine will be guarenteed to work
        System.out.println("Please enter the following values:");
        System.out.println("Please enter a first name");
        String firstName = scan.nextLine();
        System.out.println("Please enter a last name");
        String lastName = scan.nextLine();
        System.out.println("Please enter a street address");
        String streetAddress = scan.nextLine();
        System.out.println("Please enter a city");
        String city = scan.nextLine();
        System.out.println("Please enter a state");
        String state = scan.nextLine();
        System.out.println("Please enter a zip code");
        String zip = scan.nextLine();
        System.out.println("Please enter an email");
        String email = scan.nextLine();
        System.out.println("Please enter a phone number");
        String phoneNum = scan.nextLine();

        //Calling the insert method from the manager class. Either put into all uppercase or all lowercase so there will be no errors
        searchTreeManager.add(new searchTreeNode<String>(Integer.toString(lastIdx + 1), firstName.toUpperCase(), lastName.toUpperCase(), 
        streetAddress.toLowerCase(), city.toLowerCase(), state.toLowerCase(), zip.toLowerCase(), email.toLowerCase(), phoneNum.toLowerCase()));
        //Return used to update the last index so the next user index will be unique
        return (lastIdx + 1);
    }

    //Method to delete a specific account (node) according to the user's wishes
    public static void deleteNode(Scanner scan) {
        scan.nextLine(); //scan.nextLine so the next scan.nextLine will be guarenteed to work
        System.out.println("Please enter the email of the account you want to delete");
        String toDelete = scan.nextLine();
        toDelete.toLowerCase();
        //Finding the user account's index
        String idx = searchTreeManager.findUserIdx(toDelete);
        //Calling the delete method from the manager class
        searchTreeManager.delete(idx); 
    }

    //Method to modify all the data in a specific account (node) 
    public static void modifyNode(Scanner scan) {
        scan.nextLine(); //scan.nextLine so the next scan.nextLine will be guarenteed to work
        System.out.println("Please enter the email of the account you want to modify");
        String toModify = scan.nextLine();
        toModify.toLowerCase();
        //Finding the user account's index by using the email 
        String idx  = searchTreeManager.findUserIdx(toModify); 
        
        System.out.println("Please enter the following values:");
        System.out.println("Please enter a first name");
        String firstName = scan.nextLine();
        System.out.println("Please enter a last name");
        String lastName = scan.nextLine();
        System.out.println("Please enter a street address");
        String streetAddress = scan.nextLine();
        System.out.println("Please enter a city");
        String city = scan.nextLine();
        System.out.println("Please enter a state");
        String state = scan.nextLine();
        System.out.println("Please enter a zip code");
        String zip = scan.nextLine();
        System.out.println("Please enter an email");
        String email = scan.nextLine();
        System.out.println("Please enter a phone number");
        String phoneNum = scan.nextLine();

        //Calling the modify method from the manager class. Either put into all uppercase or all lowercase so there will be no errors
        searchTreeManager.modify(idx, firstName.toUpperCase(), lastName.toUpperCase(), streetAddress.toLowerCase(), city.toLowerCase(), 
        state.toLowerCase(), zip.toLowerCase(), email.toLowerCase(), phoneNum.toLowerCase());            
    }
    
    //Method to print the whole dictionary according to different formats
    public static void printBST(Scanner scan) {
        System.out.println("What format do you want to print it as?");
        System.out.println("1. Pre-order format");
        System.out.println("2. In-order format");
        System.out.println("3. Post-order format");
        int format = scan.nextInt();
        switch (format) {
            case 1:
                System.out.println("Preorder Traversal of User Directory:"); 
                //Calling the preorder method from the manager class
                searchTreeManager.preorder(); 
                break;
            case 2:
                System.out.println("Inorder Traversal of User Directory:"); 
                //Calling the inorder method from the manager class
                searchTreeManager.inorder(); 
                break;
            case 3:
                System.out.println("Postorder Traversal of User Directory:"); 
                //Calling the postorder method from the manager class
                searchTreeManager.postorder();
                break;
            default:
                System.out.println("This is not a valid choice. Please try again.");
                System.out.println("Remember; the valid choices are 1, 2, 3");
                break;
        }
    }
}
