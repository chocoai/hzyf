package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.YfappVersion;
import com.cd.zjyf.bean.YfappVersionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface YfappVersionMapper {
    int countByExample(YfappVersionExample example);

    int deleteByExample(YfappVersionExample example);

    int deleteByPrimaryKey(String appkey);

    int insert(YfappVersion record);

    int insertSelective(YfappVersion record);

    List<YfappVersion> selectByExample(YfappVersionExample example);

    YfappVersion selectByPrimaryKey(String appkey);

    int updateByExampleSelective(@Param("record") YfappVersion record, @Param("example") YfappVersionExample example);

    int updateByExample(@Param("record") YfappVersion record, @Param("example") YfappVersionExample example);

    int updateByPrimaryKeySelective(YfappVersion record);

    int updateByPrimaryKey(YfappVersion record);
}