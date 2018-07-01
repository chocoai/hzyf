package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.YlwsUpload;
import com.cd.zjyf.bean.YlwsUploadExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YlwsUploadMapper {
    long countByExample(YlwsUploadExample example);

    int deleteByExample(YlwsUploadExample example);

    int deleteByPrimaryKey(String id);

    int insert(YlwsUpload record);

    int insertSelective(YlwsUpload record);

    List<YlwsUpload> selectByExample(YlwsUploadExample example);

    YlwsUpload selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YlwsUpload record, @Param("example") YlwsUploadExample example);

    int updateByExample(@Param("record") YlwsUpload record, @Param("example") YlwsUploadExample example);

    int updateByPrimaryKeySelective(YlwsUpload record);

    int updateByPrimaryKey(YlwsUpload record);
}