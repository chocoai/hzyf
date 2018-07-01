package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.JgdwJbxx;
import com.cd.zjyf.bean.JgdwJbxxExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface JgdwJbxxMapper {
    int countByExample(JgdwJbxxExample example);

    int deleteByExample(JgdwJbxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(JgdwJbxx record);

    int insertSelective(JgdwJbxx record);

    List<JgdwJbxx> selectByExample(JgdwJbxxExample example);

    JgdwJbxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") JgdwJbxx record, @Param("example") JgdwJbxxExample example);

    int updateByExample(@Param("record") JgdwJbxx record, @Param("example") JgdwJbxxExample example);

    int updateByPrimaryKeySelective(JgdwJbxx record);

    int updateByPrimaryKey(JgdwJbxx record);
}