package com.arjun.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.arjun.springboot.learnjpaandhibernate.course.Course;

@Repository
public class CourseJdbcRepository {
	
	@Autowired
	private JdbcTemplate springjdbcTemplate;
	
	/*
	 * private static String INSERT_QUERY = """ insert into course(id,name,author)
	 * values(1,'learn AWS','Malli'); """;
	 * 
	 * public void insert() { springjdbcTemplate.update(INSERT_QUERY);
	 * }
	 */
	
	private static String INSERT_QUERY =
			"""
				insert into course(id,name,author)
				values(?,?,?);	
					""";
	private static String DELETE_QUERY =
			"""
				delete from course 
				where id =?
					
					""";
	private static String SELECT_QUERY =
			"""
				select * from course 
				where id =?
					
					""";
	
	public void insert(Course course) {
		springjdbcTemplate.update(INSERT_QUERY,course.getId(),
				course.getName(),course.getAuthor());
	}
	public void deleteById(long id) {
		springjdbcTemplate.update(DELETE_QUERY,id);
	}
	public Course findById(long id) {
		// ResultSet -> Bean => RowMapper
		return springjdbcTemplate.queryForObject(SELECT_QUERY,
				new BeanPropertyRowMapper<>(Course.class), id);
	}

}
