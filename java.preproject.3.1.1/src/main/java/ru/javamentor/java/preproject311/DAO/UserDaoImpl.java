package ru.javamentor.java.preproject311.DAO;

import org.springframework.stereotype.Component;
import ru.javamentor.java.preproject311.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void removeUser(int id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updatedUser) {
       User user = getUserById(id);
       user.setEmail(updatedUser.getEmail());
       user.setName(updatedUser.getName());
       user.setSurName(updatedUser.getSurName());

    entityManager.merge(user);
    }
}
