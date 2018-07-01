package com.cd.zjyf.mapper;

import com.cd.zjyf.annotation.NoPaging;
import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * chenshuo.dong
 * 通用的DAO方法
 */
@NoPaging
public interface CommonMapper {


     @Select("SELECT FOUND_ROWS()")
     Integer  getTotal();

}
