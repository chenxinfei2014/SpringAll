package com.springboot.service.impl;

import com.springboot.mysql2dao.Mysql2StudentMapper;
import com.springboot.mysqldao.MysqlStudentMapper;
import com.springboot.oracledao.OracleStudentMapper;
import com.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImp implements StudentService {
    @Autowired
    private OracleStudentMapper oracleStudentMapper;
    @Autowired
    private MysqlStudentMapper mysqlStudentMapper;
    @Autowired
    private Mysql2StudentMapper mysql2StudentMapper;

    @Override
    public List<Map<String, Object>> getAllStudentsFromOralce() {
        return this.oracleStudentMapper.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> getAllStudentsFromMysql() {
        return this.mysqlStudentMapper.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> getAllStudentsFromMysql2() {
        return this.mysql2StudentMapper.getAllStudents();
    }

}
