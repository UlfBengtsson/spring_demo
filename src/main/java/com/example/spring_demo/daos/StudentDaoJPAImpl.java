package com.example.spring_demo.daos;

import com.example.spring_demo.models.Student;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class StudentDaoJPAImpl implements StudentDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Student create(Student student) {
        entityManager.persist(student);
        return student;
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        return (List<Student>) entityManager.createQuery("SELECT * FROM Student");
    }

    @Override
    @Transactional
    public Student update(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        entityManager.remove(student);
    }
}
