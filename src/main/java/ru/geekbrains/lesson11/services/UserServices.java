package ru.geekbrains.lesson11.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.lesson11.model.User;
import ru.geekbrains.lesson11.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository repository;

    public Optional<User> findProductById(Long id) {
        return repository.findById(id);
    }

    public List<User> findAllProduct() {
        return repository.findAll();
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    public void deleteUserById(Long id) {
        repository.deleteById(id);
    }
}
