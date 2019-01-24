package com.cyq.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

	
	@Select("select * from app_user where id = #{id}")
	Map<String, Object> get(@Param("id") String id);
}
