package com.springboot.dao.impl;

import com.springboot.dao.Mysql2StudentDao;
import com.springboot.dao.MysqlStudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class Mysql2StudentDaoImp implements Mysql2StudentDao {
	
	@Autowired
	@Qualifier("mysql2JdbcTemplate")
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Map<String, Object>> getAllStudents() {
		return this.jdbcTemplate.queryForList("select * from student");
	}

}
