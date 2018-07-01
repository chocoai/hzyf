package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.YlwsJbxx;
import com.cd.zjyf.bean.YlwsJbxxExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author chen.shuodong
 *医疗机构表
 */
public interface YlwsJbxxMapper {
    int countByExample(YlwsJbxxExample example);

    int deleteByExample(YlwsJbxxExample example);

    int deleteByPrimaryKey(String id);

    int insert(YlwsJbxx record);

    int insertSelective(YlwsJbxx record);

    List<YlwsJbxx> selectByExample(YlwsJbxxExample example);

    YlwsJbxx selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") YlwsJbxx record, @Param("example") YlwsJbxxExample example);

    int updateByExample(@Param("record") YlwsJbxx record, @Param("example") YlwsJbxxExample example);

    int updateByPrimaryKeySelective(YlwsJbxx record);

    int updateByPrimaryKey(YlwsJbxx record);
    

}