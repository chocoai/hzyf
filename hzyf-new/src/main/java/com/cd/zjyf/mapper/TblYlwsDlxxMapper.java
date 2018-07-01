package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.TblYlwsDlxx;
import com.cd.zjyf.bean.TblYlwsDlxxExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TblYlwsDlxxMapper {
    int countByExample(TblYlwsDlxxExample example);

    int deleteByExample(TblYlwsDlxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(TblYlwsDlxx record);

    int insertSelective(TblYlwsDlxx record);

    List<TblYlwsDlxx> selectByExample(TblYlwsDlxxExample example);

    TblYlwsDlxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TblYlwsDlxx record, @Param("example") TblYlwsDlxxExample example);

    int updateByExample(@Param("record") TblYlwsDlxx record, @Param("example") TblYlwsDlxxExample example);

    int updateByPrimaryKeySelective(TblYlwsDlxx record);

    int updateByPrimaryKey(TblYlwsDlxx record);
}