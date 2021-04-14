package by.tms.action;

import by.tms.action.util.Writer;
import by.tms.service.AdminService;

import static by.tms.action.util.Reader.readId;
import static by.tms.action.util.Reader.readLine;
import static by.tms.action.util.Writer.writeln;

public class AdminAction {

    private AdminService adminService = new AdminService();

    public void addAdmin() {
        writeln("Input administrator's Name: ");
        String newAdminName = readLine();
        writeln("Input administrator's Login: ");
        String newAdminLogin = readLine();
        writeln("Input administrator's Password: ");
        String newAdminPassword = readLine();
        writeln("Input Admin - 1 or Moderator - 2:");
        int role = Integer.parseInt(readLine());
        switch (role) {
                    case 1:
                        if (adminService.addAdmin(newAdminName, newAdminLogin, newAdminPassword, role));
                        writeln("Administrator " + newAdminName + " was successfully added!");
                    case 2:
                        if (adminService.addAdmin(newAdminName, newAdminLogin, newAdminPassword, role));
                        writeln("Moderator " + newAdminName + " was successfully added!");
                    default:
                }
        }

    public void removeAdmin() {
        writeln("Input Administrator's Login to delete: ");
        String login = readLine();
        writeln("Input Administrator's Password: ");
        String password = readLine();
        if (adminService.removeAdmin(login, password))
            writeln("Student was successfully removed!");
        else
            writeln("Student with Login(" + login + ") not found OR password is incorrect!");
    }

    public boolean authorizationAdmin (String login, String password) {
        if (adminService.checkAdminByLogin(login, password)) {
            if (adminService.authorizationAdmin(login, password)) {
                return true;
            }
        }
        return false;
    }


    public void findAdminByLogin() {
        writeln("Input Administrator's Login: ");
        String adminLogin = readLine();
        writeln("Input Administrator's Password: ");
        String adminPassword = readLine();
        if ((adminService.checkAdminByLogin(adminLogin, adminPassword)))
            writeln("Founded Administrator:\n" + adminLogin);
        else
            writeln("Admin with Login(" + adminLogin + ") not found!");
    }

    public void findAdminById() {
        writeln("Input Administrator's Id: ");
        long adminId = readId();
        writeln("Input Administrator's Password: ");
        String adminPassword = readLine();
        if ((adminService.checkAdminById(adminId, adminPassword)))
            writeln("Founded Administrator with Id: " + adminId);
        else
            writeln("Admin with Login(" + adminId + ") not found!");
    }

    public void updateAdminNameById() {
        Writer.writeln("Input Administrator's Id:");
        Long adminId = readId();
        writeln("Input Administrator's Password: ");
        String adminPassword = readLine();
        writeln("Input Administrator's new name:");
        String adminNewName = readLine();
        if (adminService.updateAdminNameById(adminId, adminPassword, adminNewName))
            Writer.writeln("New name of Administrator with id " + adminId + " was set");
        else writeln("Id " + adminId + " or password is incorrect!");
    }
}