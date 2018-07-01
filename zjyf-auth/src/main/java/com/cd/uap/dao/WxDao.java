package com.cd.uap.dao;

import com.cd.uap.entity.Wx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by li.mingyang on 2018/5/22.
 */
public interface WxDao extends JpaRepository<Wx, Integer>,JpaSpecificationExecutor<Wx> {
    public Wx findByOpenId(String openId);

}
