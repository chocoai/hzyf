package com.cd.zjyf.mapper;

import com.cd.zjyf.bean.Hkdevice;
import com.cd.zjyf.bean.HkdeviceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HkdeviceMapper {
    long countByExample(HkdeviceExample example);

    int deleteByExample(HkdeviceExample example);

    int deleteByPrimaryKey(String id);

    int insert(Hkdevice record);

    int insertSelective(Hkdevice record);

    List<Hkdevice> selectByExample(HkdeviceExample example);

    Hkdevice selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Hkdevice record, @Param("example") HkdeviceExample example);

    int updateByExample(@Param("record") Hkdevice record, @Param("example") HkdeviceExample example);

    int updateByPrimaryKeySelective(Hkdevice record);

    int updateByPrimaryKey(Hkdevice record);
}