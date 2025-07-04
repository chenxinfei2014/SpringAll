package com.springboot.dao;

import java.util.List;
import java.util.Map;


public interface Mysql2StudentDao {
	List<Map<String, Object>> getAllStudents();
}
