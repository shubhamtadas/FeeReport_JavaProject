package com.student;

public interface StudentDao {
	
	public void addStudent(Student student);
	public String loadStudent(String roll);
	public String deuFee(String rollNo);
	public void updateStudent(String roll,String oldData, String newData);
}