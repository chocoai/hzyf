package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.YlwsFile;
import com.cd.zjyf.bean.YlwsFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YlwsFileMapper {
    long countByExample(YlwsFileExample example);

    int deleteByExample(YlwsFileExample example);

    int deleteByPrimaryKey(String id);

    int insert(YlwsFile record);

    int insertSelective(YlwsFile record);

    List<YlwsFile> selectByExample(YlwsFileExample example);

    YlwsFile selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YlwsFile record, @Param("example") YlwsFileExample example);

    int updateByExample(@Param("record") YlwsFile record, @Param("example") YlwsFileExample example);

    int updateByPrimaryKeySelective(YlwsFile record);

    int updateByPrimaryKey(YlwsFile record);
}