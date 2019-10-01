package cn.liu.moiveticket.dao;

import cn.liu.moiveticket.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    User findUserByEmail(String email);
    int insertUser(User user);
    int registerUser(User user);
}
