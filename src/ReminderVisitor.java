import java.io.IOException;

public class ReminderVisitor extends NodeVisitor {

	private Reminder m_Reminder;
	static Facade facade = new Facade();

	public static void visitMenu(UserInfoItem userInfoItem) throws IOException {
		System.out.println("Implementing VISITOR DESIGN PATTERN to revisit the main stage according to the user");
		facade.createUser(userInfoItem);
	}

	public void visitTrading(Trading trading) {

	}

	public void visitFacade(Facade facade) throws IOException {
		System.out.println("Implementing VISITOR DESIGN PATTERN");
		facade.login();
	}

}
