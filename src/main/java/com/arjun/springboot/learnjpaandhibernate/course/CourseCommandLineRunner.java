package com.arjun.springboot.learnjpaandhibernate.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.arjun.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.arjun.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {
	
//	@Autowired
//	private CourseJdbcRepository repository;
	
//	@Autowired
//	private CourseJpaRepository repository;
	
	@Autowired
	private CourseSpringDataJpaRepository repository;

	@Override
	public void run(String... args) throws Exception {
//		repository.insert(new Course(2, "Learn Spring Jpa", "mySlef"));
//		repository.insert(new Course(3, "Learn Azure JPA", "mySlef"));
//		repository.insert(new Course(4, "Learn Devoops JPA", "mySlef"));
		
		repository.save(new Course(2, "Learn Spring Jpa", "mySlef"));
		repository.save(new Course(3, "Learn Azure JPA", "mySlef"));
		repository.save(new Course(4, "Learn Devoops JPA", "mySlef"));
		
		
		repository.deleteById(2l);
		
		System.out.println(repository.findById(3l));
		System.out.println(repository.findById(4l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("mySlef"));
		System.out.println(repository.findByAuthor(""));
		
		System.out.println(repository.findByName("Learn Azure JPA"));
		System.out.println(repository.findByName(""));
		
	}

}
