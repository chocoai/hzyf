package com.cd.zjyf.mapper;


import com.cd.zjyf.pojo.Dropdown;
import com.cd.zjyf.pojo.LoginUserInfo;
import com.cd.zjyf.pojo.qc.*;
import com.cd.zjyf.pojo.qr.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 项目业务主要的mapper
 */
public interface ProjectMapper {

     String queryUserXZQH (LoginUserInfo userInfo);

     List<YlwsJbxxQR> cqueryYLJG(YlwsJbxxQC qc);

//     List<AppUser> cqueryRY(AppUserQC qc);

     List<JSHBQR> queryJSHB(JSHB qc);

     List<JSHBQR> queryJSHBZCD(JSHB qc);

     @Deprecated
     List<JSTBQR> queryJSTB(JSTB qc);

     List<JSTBNQR> queryJSTBN(JSTB qc);

     List<JSMXQR> queryJSMX(JSMX qc);

     List<JSQKQR> queryJSQK(JSQK qc);

     List<SDLQR> querySDL(SDL qc);

     List<Dropdown> zcdDropdown(String userxzqh);
     List<Dropdown> zcdDropdown1(String userxzqh);

     List<Dropdown> jgdwDropdown(String userxzqh);

     @Deprecated
     List<Dropdown> userjgDropdown(@Param("userxzqh")String userxzqh, @Param("rylx")String rylx);

     List<Dropdown> userYljgDropdown(@Param("userxzqh")String userxzqh, @Param("rylx")String rylx,@Param("zcdid")String zcdid);

     List<Dropdown> userJgdwDropdown(@Param("userxzqh")String userxzqh, @Param("rylx")String rylx);

     @Delete("delete from tbl_app_user where yljgid=#{yljgid}")
     void deleteUserByYLJGID(@Param("yljgid")String id);

     @Update("update  tbl_app_user   set zgzt='2' where yljgid=#{yljgid}")
     void logicDeleteUserByYLJGID(@Param("yljgid")String yljgid);

     //删除医疗机构，如果暂存点则还要删除下面的产生点
     @Update("update tbl_ylws_jbxx set isdelete='1' where id=#{id} or zcdid=#{id}")
     int logicDeleteYljg(String id);

     @Update("update tbl_app_user set zgzt='2' where id=#{id}")
     int logicDeleteUser(String id);

     List<SewageQR> querySewage(SewageQC qc);

     List<SewageQR> querySewageInfo(SewageQC qc);


}
