public class searchTreeNode<E> {
    
    //Creating the data placeholders
    protected E primaryKey;
    protected E firstName;
    protected E lastName;
    protected E streetAddress;
    protected E city;
    protected E state;
    protected E zip;
    protected E email;
    protected E phoneNum;
    
    //Making left and right nodes for the tree
    searchTreeNode<E> left, right;

    //A method to set the data in the node to the user input data
    public searchTreeNode(E incomingPrimaryKey, E incomingFirstName, E incomingLastName, E incomingStreetAddress, 
    E incomingCity, E incomingState, E incomingZip, E incomingEmail, E incomingPhoneNumber) { 
        this.primaryKey = incomingPrimaryKey;
        this.firstName = incomingFirstName; 
        this.lastName = incomingLastName; 
        this.streetAddress = incomingStreetAddress; 
        this.city = incomingCity; 
        this.state = incomingState; 
        this.zip = incomingZip; 
        this.email = incomingEmail; 
        this.phoneNum = incomingPhoneNumber; 
        this.left = this.right = null;
    }
}
