package ua.training.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Registration implements Command {
    @Override
    public String execute(HttpServletRequest request) {

        return "/registration.jsp";
    }
}
