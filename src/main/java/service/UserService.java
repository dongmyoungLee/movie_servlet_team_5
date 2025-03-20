package service;

import dao.UserDao;
import dto.UserDto;

public class UserService {
    private static UserService userService;
    public static UserService getUserService() {
        if(userService == null) userService = new UserService();
        return userService;
    }

    public boolean signUp(UserDto dto) {
        return new UserDao().signUp(dto);
    }
}
