package com.cd.zjyf.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.cd.zjyf.management.pojo.Wx;

/**
 * Created by ma.xiaofeng on 2018/4/16.
 */
public interface WxDao extends JpaRepository<Wx, Integer>,JpaSpecificationExecutor<Wx> {
    public Wx findByOpenId(String openId);
    
    public boolean existsByOpenId(String openId);
    
    public boolean existsByUserId(String userId);
    
    public int deleteByUserId(String userId);
}
