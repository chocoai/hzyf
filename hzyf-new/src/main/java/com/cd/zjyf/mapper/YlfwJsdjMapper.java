package com.cd.zjyf.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cd.zjyf.bean.YlfwJsdj;
import com.cd.zjyf.bean.YlfwJsdjExample;

@Mapper
public interface YlfwJsdjMapper {
    int countByExample(YlfwJsdjExample example);

    int deleteByExample(YlfwJsdjExample example);

    int deleteByPrimaryKey(String id);

    int insert(YlfwJsdj record);

    int insertSelective(YlfwJsdj record);

    List<YlfwJsdj> selectByExample(YlfwJsdjExample example);

    YlfwJsdj selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YlfwJsdj record, @Param("example") YlfwJsdjExample example);

    int updateByExample(@Param("record") YlfwJsdj record, @Param("example") YlfwJsdjExample example);

    int updateByPrimaryKeySelective(YlfwJsdj record);
    
    int updateByZCDid(YlfwJsdj record);

    int updateByPrimaryKey(YlfwJsdj record);

}