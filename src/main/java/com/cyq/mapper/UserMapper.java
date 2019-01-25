package com.cyq.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.cyq.entity.User;

@Mapper
public interface UserMapper {

	
	@Select("select * from app_user where id = #{id}")
	Map<String, Object> get(@Param("id") String id);

	@Select("select * from app_user limit #{pageIndex}, #{pageSize}")
	List<User> getUsers(@Param("pageIndex") Integer pageIndex, @Param("pageSize") Integer pageSize);
}
