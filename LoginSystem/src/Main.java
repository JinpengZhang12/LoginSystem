public class Main {

    public static void main(String[] args) {
        // call the class
        IDandPasswords idandPasswords = new IDandPasswords();
        // to retrive information from login page class
        // return hash map
        LoginPage loginPage = new LoginPage(idandPasswords.getLogininfo());
    }
}