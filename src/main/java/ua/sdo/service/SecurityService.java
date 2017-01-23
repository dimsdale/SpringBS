package ua.sdo.service;

public interface SecurityService {

    void logIn(String login, String password);

    String findLoggedUser();
}
