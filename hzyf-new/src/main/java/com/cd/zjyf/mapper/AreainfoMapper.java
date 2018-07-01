package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.Areainfo;
import com.cd.zjyf.bean.AreainfoExample;
import com.cd.zjyf.pojo.AreaTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AreainfoMapper {
    int countByExample(AreainfoExample example);

    int deleteByExample(AreainfoExample example);

    int deleteByPrimaryKey(String code);

    int insert(Areainfo record);

    int insertSelective(Areainfo record);

    List<Areainfo> selectByExample(AreainfoExample example);

    Areainfo selectByPrimaryKey(String code);

    int updateByExampleSelective(@Param("record") Areainfo record, @Param("example") AreainfoExample example);

    int updateByExample(@Param("record") Areainfo record, @Param("example") AreainfoExample example);

    int updateByPrimaryKeySelective(Areainfo record);

    int updateByPrimaryKey(Areainfo record);
    
    AreaTree  getArea(String areacode);
    
    List<AreaTree> getAreaChildren(String areacde);
}