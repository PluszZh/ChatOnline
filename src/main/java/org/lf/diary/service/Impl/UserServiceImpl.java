package org.lf.diary.service.Impl;



import org.lf.diary.core.ServiceException;

import org.lf.diary.model.User;
import org.lf.diary.model.Vo.SafeUserVo;

import org.lf.diary.repository.UserRepository;
import org.lf.diary.service.UserService;
import org.springframework.beans.BeanUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

/**
 * @Author: Jvinh
 * @DateTime: 2020/1/21 22:37
 * @Description: TODO
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    //返回用户的安全信息
    public User findById(Long id){
        User user = userRepository.findById(id).orElseThrow(() -> new ServiceException("id不存在"));
        User u = new User();
        u.setId(user.getId());
        u.setUsername(user.getUsername());
        u.setUserImg(user.getUserImg());
        return u;
    }

    //按前台输入的关键字查找所有的user用户
    @Override
    public List<SafeUserVo> searchFriend(String keyword) {
        List<User> userList = userRepository.findByUsernameLikeTop5(keyword);
        //转化为安全的user信息
        List<SafeUserVo> safeUserVos = new ArrayList<>();
        for(User u:userList){
            SafeUserVo safeUserVo = new SafeUserVo();
            BeanUtils.copyProperties(u,safeUserVo);
            safeUserVos.add(safeUserVo);
        }

        return  safeUserVos;
    }
}
