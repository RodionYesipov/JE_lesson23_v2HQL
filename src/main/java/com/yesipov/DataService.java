package com.yesipov;

import com.yesipov.dao.GroupDao;
import com.yesipov.dao.StudentDao;
import com.yesipov.model.Group;
import com.yesipov.model.Student;

import java.util.ArrayList;
import java.util.List;

public class DataService {
    private StudentDao studentDao = new StudentDao();
    private GroupDao groupDao = new GroupDao();

    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    public void addGroup(int id, String groupName) {
        groupDao.addGroup(new Group(id, groupName));
    }

    public Group getGroup(int id) {
        return groupDao.getGroup(id);
    }

    public List<String> getStudentsByGroup(String groupName) {
        List<Student> students = studentDao.getStudentsByGroup(groupName);
        List<String> result = new ArrayList<>();

        for (Student student:students) {
            result.add(student.getName());
        }
        return result;
    }

    public List<String> getGroupsByStudentName(String studentName) {
        List<Group> groups = studentDao.getGroupsByStudentName(studentName);
        List<String> result = new ArrayList<>();

        for (Group group:groups) {
            result.add(group.getGroupName());
        }
        return result;
    }

    public void close() {
        studentDao.close();
    }
}
