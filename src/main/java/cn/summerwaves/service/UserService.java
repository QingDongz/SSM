package cn.summerwaves.service;

import cn.summerwaves.model.User;

public interface UserService {
    User selectByPrimaryKey(Long id);

    Boolean updateByPrimaryKeySelective(User record);
}
