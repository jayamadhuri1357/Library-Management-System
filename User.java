public class User {

    private int userId;
    private String name;

    // Constructor
    public User(int userId, String name) {

        this.userId = userId;
        this.name = name;
    }

    // Getters
    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    // Display User Details
    @Override
    public String toString() {

        return "User ID: " + userId +
                ", Name: " + name;
    }
}