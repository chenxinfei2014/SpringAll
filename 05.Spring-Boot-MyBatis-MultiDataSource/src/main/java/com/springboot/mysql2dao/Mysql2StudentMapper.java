package com.springboot.mysql2dao;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface Mysql2StudentMapper {
	List<Map<String, Object>> getAllStudents();
}
