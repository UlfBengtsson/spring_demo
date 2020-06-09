package com.example.spring_demo;

import com.example.spring_demo.daos.CarDaoImpl;
import com.example.spring_demo.daos.StudentDao;
import com.example.spring_demo.models.Car;
import com.example.spring_demo.models.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}

	@Bean//by default a singleton
	public CommandLineRunner ourConsole(StudentDao studentDao, CarDaoImpl carDao) {
		return (args -> {
			Student studentJohn = studentDao.create(new Student("John","Doo","a@a.a"));

			log.info(studentJohn.toString());

			Student foundStudent = studentDao.findById(studentJohn.getStudentId());

			log.info(foundStudent.toString());

			Car saab = new Car();
			saab.setName("SAAB 900 Turbo");

			log.info(saab.toString());

			Car car = carDao.save(saab);

			log.info(car.toString());
		});
	}
}
