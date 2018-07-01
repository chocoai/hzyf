package com.cd.zjyf.management.dao;

import com.cd.zjyf.management.pojo.JgdwJbxx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by ma.xiaofeng on 2018/4/16.
 */
public interface JgdwJbxxDao extends JpaRepository<JgdwJbxx, String>, JpaSpecificationExecutor<JgdwJbxx>{
}
