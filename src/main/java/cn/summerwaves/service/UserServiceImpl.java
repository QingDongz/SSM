package cn.summerwaves.service;

import cn.summerwaves.dao.UserDao;
import cn.summerwaves.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User selectByPrimaryKey(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    @Override
    public Boolean updateByPrimaryKeySelective(User record) {
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public Long insert(User record) {
        return userDao.insert(record);
    }

    @Transactional(propagation=Propagation.REQUIRED)
    @Override
    public Long insertSelective(User record) {
        Long success = userDao.insertSelective(record);
        return success;
    }

}
