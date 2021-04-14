package by.tms.storage;

import by.tms.domain.Admin;
import by.tms.domain.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import static by.tms.action.util.Writer.writeln;

public class StudentStorage {
	private final static String SAVE_STUDENT = "insert into students s values (default, ?, ?, ?, ?, ?, ?)";
	private final static String RETURN_BY_LOGIN = "select * from students s where s.login = ?";
	private final static String REMOVE_STUDENT_BY_ID = "delete * from students s where s.id = ?";
	private final static String GET_ALL_STUDENTS = "select * from students";
	private final static String GET_STUDENT_BY_LOGIN = "select * from students s where s.login = ?";
	private final static String UPDATE_STUDENT_BY_ID = "update students s set s.login = ?, s.password = ?, s.name = ?, s.faculty = ?, s.group = ? where s.id = ?";
	private final static String UPDATE_PASSWORD_BY_ID = "update students set password = ? where id = ?";
	private final static String UPDATE_PASSWORD_BY_LOGIN = "update students s set s.password = ? where s.login = ?";
	private final static String CHECK_STUDENT_PASSWORD_BY_LOGIN = "select * from students s set s.password = ? where s.login = ?";
	private final static String UPDATE_NAME_BY_ID = "update studens set name = ? where id = ?";
	private final static String UPDATE_FACULTY_BY_ID = "update students set faculty = ? where id = ?";
	private final static String UPDATE_GROUP_BY_ID = "update students set groupa = ? where id = ?";
	private final static String CHECK_BY_ID = "select * from students s where s.id = ?";
	private final static String CHECK_BY_LOGIN = "select * from students s where s.login = ?";
	private final static String CHECK_BY_STUDENT = "select * from students s where s.id = ? or s.login = ?";
	private final static String UPDATE_NAME_FACULTY_GROUP_BY_ID = "update students s set s.name = ?, s.faculty = ?, s.group = ? where id = ?";
	private final static String CHECK_BY_GROUP = "select * from students s where s.group = ?";
	private final static String GET_STUDENT_GROUP = "select * from students s where s.group = ?";
	private final static String CHECK_BY_FACULTY = "select * from students s where s.faculty = ?";
	private final static String GET_STUDENT_FACULTY = "select * from students s where s.faculty = ?";
	Connection connection = null;

	private final static String URL_TABLES = "jdbc:postgresql://localhost:5432/postgres";
	private final static String LOGIN_TABLES = "postgres";
	private final static String PASS_TABLES = "learn2000_";

	public void saveStudent(String name, String login, String password, String faculty, String group, long role) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(SAVE_STUDENT);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, login);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, faculty);
			preparedStatement.setString(5, group);
			preparedStatement.setLong(6, role);
			preparedStatement.executeQuery();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public long returnIdByLogin(String login) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(RETURN_BY_LOGIN);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			long loginForReturn = resultSet.getLong(1);
			connection.close();
			return loginForReturn;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public boolean removeStudentById(Long id) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(REMOVE_STUDENT_BY_ID);
			preparedStatement.setLong(1, id);
			preparedStatement.executeQuery();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Student> getAllStudents() {
		try {
			long id = 0;
			String name = "";
			String login = "";
			String password = "";
			String faculty = "";
			String group = "";
			Student student = null;
			List<Student> listOfStudents = new ArrayList();
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getLong(1);
				name = resultSet.getString(2);
				login = resultSet.getString(3);
				password = resultSet.getString(4);
				faculty = resultSet.getString(5);
				group = resultSet.getString(6);
				student.setId(id);
				student.setName(name);
				student.setLogin(login);
				student.setFaculty(faculty);
				student.setPassword(password);
				student.setGroup(group);
				listOfStudents.add(student);
			}
			return (ArrayList<Student>) listOfStudents;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Student getStudentByLogin(String inputLogin) {
		try {
			long id = 0;
			String name = "";
			String login = "";
			String password = "";
			String faculty = "";
			String group = "";
			Student student = null;
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_BY_LOGIN);
			preparedStatement.setString(1, inputLogin);
			ResultSet resultSet = preparedStatement.executeQuery();
			id = resultSet.getLong(1);
			name = resultSet.getString(2);
			login = resultSet.getString(3);
			password = resultSet.getString(4);
			faculty = resultSet.getString(5);
			group = resultSet.getString(6);
			student.setId(id);
			student.setName(name);
			student.setLogin(login);
			student.setFaculty(faculty);
			student.setPassword(password);
			student.setGroup(group);
			return student;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateStudentById(long id, Student student) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_BY_ID);
			preparedStatement.setString(1, student.getLogin());
			preparedStatement.setString(2, student.getPassword());
			preparedStatement.setString(3, student.getPassword());
			preparedStatement.setString(4, student.getFaculty());
			preparedStatement.setString(5, student.getGroup());
			preparedStatement.setLong(6, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePasswordById(long id, String password) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_BY_ID);
			preparedStatement.setString(1, password);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updatePasswordByLogin(String login, String newPassword) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD_BY_LOGIN);
			preparedStatement.setString(1, newPassword);
			preparedStatement.setString(2, login);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkStudentPasswordByLogin (String inputLogin, String inputPassword) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_STUDENT_PASSWORD_BY_LOGIN);
			preparedStatement.setString(1, inputPassword);
			preparedStatement.setString(2, inputLogin);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.getString(1).equals(inputPassword)) return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public void updateNameById (long id , String name) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NAME_BY_ID);
			preparedStatement.setString(1, name);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateFacultyById(long id, String faculty) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FACULTY_BY_ID);
			preparedStatement.setString(1, faculty);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateGroupById(long id, String groupa) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_GROUP_BY_ID);
			preparedStatement.setString(1, groupa);
			preparedStatement.setLong(2, id);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean checkById(Long id) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_ID);
			preparedStatement.setLong(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByLogin(String login) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_LOGIN);
			preparedStatement.setString(1, login);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByStudent(Student student) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_STUDENT);
			preparedStatement.setLong(1, student.getId());
			preparedStatement.setString(2, student.getLogin());
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateNameFacultyGroupById(long id, String password, String newName, String newFaculty, String newGroup) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_NAME_FACULTY_GROUP_BY_ID);
			preparedStatement.setString(1, newName);
			preparedStatement.setString(2, newFaculty);
			preparedStatement.setString(3, newGroup);
			preparedStatement.setLong(4, id);
			preparedStatement.executeQuery();
			connection.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean checkByGroup(String group) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_GROUP);
			preparedStatement.setString(1, group);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public ArrayList<Student> getStudentGroup(String inputGroup) {
		ArrayList<Student> studentsGroup = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_GROUP);
			preparedStatement.setString(1, inputGroup);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String login = resultSet.getString(3);
				String password = resultSet.getString(4);
				String faculty = resultSet.getString(5);
				String group = resultSet.getString(6);
				int role = resultSet.getInt(7);
				Student student = new Student(id, name, login, password, faculty, group, role);
				studentsGroup.add(student);
			}
			return studentsGroup;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkByFaculty(String faculty) {
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(CHECK_BY_FACULTY);
			preparedStatement.setString(1, faculty);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<Student> getStudentFaculty(String inputFaculty) {
		ArrayList<Student> studentsFaculty = new ArrayList<>();
		try {
			connection = DriverManager.getConnection(URL_TABLES, LOGIN_TABLES, PASS_TABLES);
			PreparedStatement preparedStatement = connection.prepareStatement(GET_STUDENT_FACULTY);
			preparedStatement.setString(1, inputFaculty);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				long id = resultSet.getLong(1);
				String name = resultSet.getString(2);
				String login = resultSet.getString(3);
				String password = resultSet.getString(4);
				String faculty = resultSet.getString(5);
				String group = resultSet.getString(6);
				int role = resultSet.getInt(7);
				Student student = new Student(id, name, login, password, faculty, group, role);
				studentsFaculty.add(student);
			}
			return studentsFaculty;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}