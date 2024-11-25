public class searchTreeNode<E> {
    protected E primaryKey;
    protected E firstName;
    protected E lastName;
    protected E streetAddress;
    protected E city;
    protected E state;
    protected E zip;
    protected E email;
    protected E phoneNum;
    //Creating the data placeholders
    searchTreeNode<E> left, right;
    //Making left and right nodes for the tree

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
    //Setting the data in the nodes to the user input data
}
