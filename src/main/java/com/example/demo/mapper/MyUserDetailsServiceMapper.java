//package com.example.demo.mapper;
//
//import com.example.demo.model.MyUserDetails;
//import org.apache.ibatis.annotations.Mapper;
//import org.apache.ibatis.annotations.Param;
//import org.apache.ibatis.annotations.Select;
//
//import java.util.List;
//
//@Mapper
//public interface MyUserDetailsServiceMapper {
//
//    // 根据userId查询用户信息
//    @Select("select username,password,enabled " +
//            "from sys_user u " +
//            "where u.username = #{userId}" )
//    MyUserDetails findByUserName(@Param("userId") String userId);
//
//    // 根据uerId查询用户角色信息
//    @Select("select role_code " +
//            "from sys_role r " +
//            "left join sys_user_role ur on r.id=ur.role_id " +
//            "left join sys_user u on u.id = ur.user_id " +
//            "where u.username = #{suerId}")
//    List<String> findRoleByUserName(@Param("userId") String userId);
//
//    // 根据用户角色查询用户权限
//    @Select({
//            "<script>",
//                "select url " ,
//                "from sys_menu m " ,
//                "left join sys_role_menu rm on m.id = rm.menu_id " ,
//                "left join sys_role r on r.id = rm.role_id ",
//                "where r.role_code in ",
//                "<foreach collection='roleCodes' item='roleCode' open='(' separator=',' close=')'>",
//                    "#{roleCode}",
//                "</foreach>",
//            "</script>"
//    })
//    List<String> findAuthorityByRoleCodes(@Param("roleCodes") List<String> roleCodes);
//
//}
