package com.pb.kuptsov.hw8;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Auth {
    private String login;
    private String password;

    public Auth() {
    }

    public Auth(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean signUp(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        String regexLogin = "^[A-Za-z0-9]+${5,20}";
        String regexPwd = "^[A-Za-z0-9_]+${5,}";

        if(!Pattern.matches(regexLogin, login)){
            throw new WrongLoginException("Неверный логин");
        }
        if(!Pattern.matches(regexPwd, password)){
            throw new WrongPasswordException("Неверный пароль");
        } else if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Повторение пароля не совпадает с введенным паролем");
        }
        System.out.println("Регистрация на сайте успешна");
        this.login = login;
        this.password = password;
        return true;
    }

    public boolean signIn (String login, String password) throws WrongLoginException {
        if(this.login.equals(login) && this.password.equals(password)){
            System.out.println("Вы успешно вошли на сайт");
            return true;
        } else throw new WrongLoginException("Введен неверный логин или пароль");
    }

    @Override
    public String toString() {
        return "Auth{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
