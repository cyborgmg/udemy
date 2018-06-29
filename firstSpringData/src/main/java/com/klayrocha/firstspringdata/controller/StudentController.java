package com.klayrocha.firstspringdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.klayrocha.firstspringdata.entity.Student;
import com.klayrocha.firstspringdata.repository.StudentRepository;

@RestController
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@RequestMapping(value="/student", method=RequestMethod.GET)
	public List<Student> listStudent(){
		
		return studentRepository.findAll();
	}
	
	@RequestMapping(value="/student", method=RequestMethod.POST)
	public Student saveStudent(@RequestBody Student student){
		return studentRepository.save(student);
	}
	
	@RequestMapping(value="/student/{id}", method=RequestMethod.GET)
	public Student findById(@PathVariable String id){
		return studentRepository.findOne(id);
	}
	
	@RequestMapping(value="/student/{name}/name", method=RequestMethod.GET)
	public List<Student> findByName(@PathVariable String name){
		return studentRepository.findByNameLikeIgnoreCase(name);
	}
}
