package cn.liu.moiveticket.service;

import cn.liu.moiveticket.dao.UserMapper;
import cn.liu.moiveticket.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;
    public User findUserByEmail(String email) {
        return userMapper.findUserByEmail(email);
    }

    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }
}
