package by.tms.domain;

public class Admin extends UsersOfStudentBase {

	public Admin(long id, String name, String login, String password, int role) {
		super(id, name, login, password, role);
	}

	public Admin(String name, String login, String password, int role) {
		super(name, login, password, role);
	}

	@Override
	public String toString() {
		return "Admin{}";
	}
}