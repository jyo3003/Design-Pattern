import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Facade facade = new Facade();
        boolean bool = facade.login(); //calling the login function in Facade class.
        // If neither buyer nor seller info matches the user entered credentials
        if(!bool){
            System.out.println("Invalid Credentials, Please try again!!!");
        }
    }
}
