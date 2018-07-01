package com.cd.zjyf.management.dao;

import com.cd.zjyf.management.pojo.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * Created by ma.xiaofeng on 2018/4/16.
 */
public interface AppUserDao extends JpaRepository<AppUser, String>, JpaSpecificationExecutor<AppUser> {
    /**
     *  根据 rylx字段，查询用户
     * @param roleName
     * @return
     */
    List<AppUser> findByRole_RoleName(String roleName);

	List<AppUser> findBySjh(String sjh);
}
