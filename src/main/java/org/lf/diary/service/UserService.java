package org.lf.diary.service;


import org.lf.diary.model.User;
import org.lf.diary.model.Vo.SafeUserVo;

import java.util.List;

/**
 * @Author: Jvinh
 * @DateTime: 2020/1/21 22:37
 * @Description: TODO
 */
public interface UserService {


    User findById(Long id);

    /**
     * @param :keyword
     * @Description:根据输入的关键字查找用户
     */
    List<SafeUserVo> searchFriend(String keyword);
}
