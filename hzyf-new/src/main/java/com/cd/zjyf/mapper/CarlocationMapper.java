package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.Carlocation;
import com.cd.zjyf.bean.CarlocationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarlocationMapper {
    long countByExample(CarlocationExample example);

    int deleteByExample(CarlocationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Carlocation record);

    int insertSelective(Carlocation record);

    List<Carlocation> selectByExample(CarlocationExample example);

    Carlocation selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Carlocation record, @Param("example") CarlocationExample example);

    int updateByExample(@Param("record") Carlocation record, @Param("example") CarlocationExample example);

    int updateByPrimaryKeySelective(Carlocation record);

    int updateByPrimaryKey(Carlocation record);
}