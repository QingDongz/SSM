package cn.summerwaves.service;

import cn.summerwaves.model.User;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {
    User selectByPrimaryKey(Long id);

    Boolean updateByPrimaryKeySelective(User record);


    Long insert(User record);


    Long insertSelective(User record);
}
