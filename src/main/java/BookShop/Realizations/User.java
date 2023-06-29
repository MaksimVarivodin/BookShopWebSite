package BookShop.Realizations;


/**
 *      User(customer) class
 * */
public class User {


    /**
     *      field - Name
     * */
    private String name;


    /**
     *      field - Email
     * */
    private String email;


    /**
     *      field - Password
     * */
    private String password;


    /**
     *      Returns name
     * */
    public String getName() {
        return name;
    }


    /**
     *      Returns email
     * */
    public String getEmail() {
        return email;
    }


    /**
     *      Returns password
     * */
    public String getPassword() {
        return password;
    }


    /**
     *      Default constructor
     * */
    public User() {
    }


    /**
     *      Constructor with parameters
     * */
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }


}
