package org.lf.diary.repository;

import org.lf.diary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Jvinh
 * @DateTime: 2020/1/14 14:56
 * @Description: TODO
 */

@Repository
public interface UserRepository extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
    User findByUsernameAndPassword(String username,String password);



    /**
     * 用户名模糊匹配首字母
     * @param
     */
    @Query(value = "select * from user where username like %?1%",nativeQuery = true)
    List<User> findByUsernameLike(String username);

    /**
     * 用户名模糊匹配首字母找出前7个
     * @param
     */
    @Query(value = "select * from user where username like %?1% LIMIT 0,5",nativeQuery = true)
    List<User> findByUsernameLikeTop5(String username);


}
