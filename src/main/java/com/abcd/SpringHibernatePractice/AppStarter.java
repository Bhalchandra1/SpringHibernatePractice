package com.abcd.SpringHibernatePractice;

import com.abcd.SpringHibernatePractice.dao.CollegeHibDao;
import com.abcd.SpringHibernatePractice.dao.HomeSprHibDao;
import com.abcd.SpringHibernatePractice.dao.StudentDao;
import com.abcd.SpringHibernatePractice.model.Home;
import com.abcd.SpringHibernatePractice.model.Student;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jca.context.ResourceAdapterApplicationContext;

import java.util.ResourceBundle;

/**
 * Created by bhalchandra on 11/1/2016.
 */
public class AppStarter {
    @SuppressWarnings("resource")
    public static void main(String[] ar){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:config/spring-config.xml");
        /*Student student = (Student) context.getBean("student");
        System.out.println(student.getStudentName());
        StudentDao studentDao = (StudentDao) context.getBean("studentDao");*/
        HomeSprHibDao homeSprHibDao = (HomeSprHibDao) context.getBean("homeSprHibDao");

        homeSprHibDao.persistHome(new Home("sheldi"));

       /* studentDao.printAllStudents();

        CollegeHibDao c = new CollegeHibDao();
        c.persistRecord();*/
    }
}
