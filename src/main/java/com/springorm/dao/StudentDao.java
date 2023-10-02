package com.springorm.dao;

import com.springorm.entities.Student;
import org.springframework.orm.hibernate5.HibernateTemplate;

import javax.transaction.Transactional;
import java.util.List;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	@Transactional
	public int insert(Student student) {
		int i = (int) this.hibernateTemplate.save(student);
		return i;
	}

	public Student getStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}

	public List<Student> getAllStudents() {
		List<Student> students = this.hibernateTemplate.loadAll(Student.class);
		return students;
	}

	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);
		this.hibernateTemplate.delete(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		this.hibernateTemplate.update(student);
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
