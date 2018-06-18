package cn.summerwaves.dao;

import cn.summerwaves.model.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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