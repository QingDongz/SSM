package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    Boolean deleteByPrimaryKey(Long id);

    List<User> selectAllUser();

    Long insert(User record);

    Long insertSelective(User record);

    User selectByPrimaryKey(Long id);

    Boolean updateByPrimaryKeySelective(User record);

    Boolean updateByPrimaryKey(User record);
}