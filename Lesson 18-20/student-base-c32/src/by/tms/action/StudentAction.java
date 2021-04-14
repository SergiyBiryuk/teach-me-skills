package by.tms.action;

import by.tms.action.util.Reader;
import by.tms.action.util.Writer;
import by.tms.domain.Student;
import by.tms.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import static by.tms.action.util.Reader.readId;
import static by.tms.action.util.Reader.readLine;
import static by.tms.action.util.Writer.writeln;

public class StudentAction {

	private final StudentService studentService = new StudentService();

	public void addStudent() {
		writeln("Введите имя:");
		String name = readLine();
		writeln("Введите логин:");
		String login = readLine();
		writeln("Введите пароль:");
		String password = readLine();
		writeln("Введите факультет:");
		String faculty = readLine();
		writeln("Введите группу:");
		String group = readLine();;
		long role = 3;
		if (studentService.add(name, login, password, faculty, group, role)) {
			Writer.write("Студент " + login + " добавлен.");
		} else {
			Writer.write("Ошибка добавления, такой студент уже существует");
		}
	}

	public void changeStudentPasswordByLogin() {
		writeln("Input Login");
		String login = readLine();
		writeln("Input password");
		String password = readLine();
		if (studentService.changeStudentPasswordByLogin(login, password)) {
			writeln("Password changed");
		} else
			writeln("Error.");
	}

	public void removeStudent() {
		writeln("Input student Login: ");
		String login = readLine();
		if (studentService.removeStudentByLogin(login))
			writeln("Student was successfully removed!");
		else
			writeln("Student with Login(" + login + ") not found OR password is incorrect!");
	}

	public void findAllStudents() {
		writeln("-= List of ALL students =-");
		List<Student> students = studentService.getAllStudents();
		for (int i = 0; i < students.size(); i++) {
			writeln(students.get(i));
		}
	}

	public void findByLogin() {
		writeln("Input Login: ");
		String login = readLine();
		Student student = studentService.searchStudentByLogin(login);
		if (student != null)
			writeln("Founded Student with login:" + login + " :\n" + student.toString());
		else
			writeln("Student with Login(" + login + ") not found!");
	}

	public void updateNameFacultyGroupById() {
		writeln("Input student's Id:");
		long id = readId();
		if (studentService.searchById(id)) {
			writeln("Input new name:");
			String newName = readLine();
			writeln("Input new faculty:");
			String newFaculty = readLine();
			writeln("Input new group:");
			String newGroup = readLine();
			writeln("Input Student password:");
			String password = readLine();
			studentService.updateNameFacultyGroupById(id, password, newName, newFaculty, newGroup);
			writeln("Name, faculty, group were updated.");
		} else
			writeln("Student with such ID not found!");
	}

	public void updateStudentNameById() {
		writeln("Input student's Id:");
		long id = readId();
		if (studentService.searchById(id)) {
			writeln("Input new name:");
			String newName = readLine();
			studentService.updateNameById(id, newName);
			writeln("Name, faculty, group were updated.");
		}
		writeln("Id was not found");
	}

	public void updatePasswordById() {
		writeln("Input id:");
		long id = readId();
		if (studentService.searchById(id)) {
			writeln("Input new password:");
			String newPassword = readLine();;
			studentService.changePasswordById(id, newPassword);
			writeln("Input new password:");
		}
		writeln("Student with such ID not found!");
	}

	public void updateFacultyById() {
		writeln("Input id:");
		long id = readId();
		writeln("Input new faculty:");
		String newFaculty = readLine();
		if (studentService.updateFacultyById(id, newFaculty))
			writeln("Faculty updated");
		else writeln("Not found id");
	}

	public void updateGroupById() {
		writeln("Input id:");
		long id = readId();
		writeln("Input new group:");
		String newGroup = readLine();
		if (studentService.updateGroupById(id, newGroup))
			writeln("Group updated");
		else writeln("Not found id");
	}

	public void removeByLogin() {
		Writer.write("Введите логин для удаления:");
		String login = Reader.readLine();
		if (studentService.removeStudentByLogin(login)) {
			Writer.write("Студент " + login + " удален");
		} else {
			Writer.write("Таких студентов не найдено");
		}
	}

	public void searchByLogin() {
		writeln("Введите логин для поиска по логину:");
		String login = readLine();
		Student studentByLogin = studentService.searchStudentByLogin(login);
		if (studentByLogin != null) {
			Writer.write("Студент " + login + " найден:");
			writeln(studentByLogin.toString());
		} else {
			Writer.write("Студентов с таким логином не существует");
		}
	}

	public void changePasswordById() {
		Writer.write("Введите Id для обновления пароля:");
		Long id = readId();
		Writer.write("Введите новый пароль:");
		String newPassword = Reader.readLine();
		if (studentService.changePasswordById(id, newPassword))
			writeln("New password set");
		else writeln("Id not found");
	}

	public void getStudentGroupList() {
		writeln("Input group name");
		String group = readLine();
		Student student;
		if (studentService.getStudentGroupList(group) != null) {
			ArrayList<Student> studentGroupList = studentService.getStudentGroupList(group);
			for (int i = 0; i < studentGroupList.size(); i++) {
				student = studentGroupList.get(i);
				writeln(student.toString());
			}
		}
	}

	public void getStudentFacultyList() {
		writeln("Input faculty name");
		String faculty = readLine();
		Student student;
		if (studentService.getStudentFacultyList(faculty) != null) {
			ArrayList<Student> studentFacultyList = studentService.getStudentFacultyList(faculty);
			for (int i = 0; i < studentFacultyList.size(); i++) {
				student = studentFacultyList.get(i);
				writeln(student.toString());
			}
		}
	}
}
