package services;

import dao.UserDAO;
import model.User;

import javax.persistence.NoResultException;

public class UserService {

    UserDAO userDAO;



    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public UserService() {
        userDAO = new UserDAO();

    }

    public boolean registerUser(User user) {
        if (isUserAlreadyExist(user.getEmail())) {
            return false;
        }
        userDAO.createUser(user);
        return true;

    }

    private boolean isUserAlreadyExist(String email) {
        try {
            userDAO.getUserByEmail(email);
            return true;
        } catch (NoResultException e) {
            return false;
        }
    }
}
