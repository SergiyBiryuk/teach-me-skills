package by.tms.service;

import by.tms.domain.Admin;
import by.tms.storage.AdminStorage;

public class AdminService {
	private final AdminStorage adminStorage = new AdminStorage();

	public boolean addAdmin(String name,
                            String login,
                            String password,
                            int role) {
		if (!adminStorage.checkAdminByLogin(login, password)) {
			Admin admin = new Admin(name, login, password, role);
			admin.setLogin(admin.getLogin().toUpperCase());
			adminStorage.saveAdmin(name, admin.getLogin(), password, role);
			return true;
		} else {
			return false;
		}
	}

	public boolean authorizationAdmin (String login, String password) {
		if (adminStorage.checkAdminByLogin(login, password) && adminStorage.checkUserRole(login) == 1) {
			if (adminStorage.checkAdminPasswordByLogin(login, password)) {
				return true;
			}
		}
		return false;
	}

	public boolean removeAdmin (String adminLogin, String adminPassword) {
		if (adminStorage.checkAdminByLogin(adminLogin, adminPassword) && adminStorage.checkUserRole(adminLogin) == 1) {
			adminStorage.removeAdminByLogin(adminLogin, adminPassword);
			return true;
		} else return false;
	}

	public boolean checkAdminByLogin (String adminLogin, String adminPassword) {
		if (adminStorage.checkAdminByLogin(adminLogin, adminPassword))
			return true;
		return false;
	}

	public boolean checkAdminById (Long adminId, String adminPassword) {
		if (adminStorage.checkAdminById(adminId, adminPassword))
			return true;
		else return false;
	}

	public boolean updateAdminNameById (Long adminId, String adminPassword, String adminNewName) {
		if (adminStorage.checkAdminById(adminId, adminPassword)) {
			adminStorage.updateAdminNameById(adminId, adminPassword, adminNewName);
			return true;
		} else return false;
	}
}
