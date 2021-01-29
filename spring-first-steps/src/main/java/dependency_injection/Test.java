package dependency_injection;

import dependency_injection.annotation.ContextConfiguration;
import dependency_injection.xml.Pupil;
import dependency_injection.xml.School;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext xmlCtx = new ClassPathXmlApplicationContext("dependency_injection_beans.xml");
        Pupil pupil1 = xmlCtx.getBean(Pupil.class);
        School school1 = xmlCtx.getBean(School.class);
        System.out.println(pupil1.getAge()); //7
        System.out.println(school1.getPupils().size()); //3

        AnnotationConfigApplicationContext annotationCtx = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        dependency_injection.annotation.Pupil pupil2 = annotationCtx.getBean(dependency_injection.annotation.Pupil.class);
        //dependency_injection.annotation.School school2 = annotationCtx.getBean(dependency_injection.annotation.School.class);
        System.out.println(pupil2.getAge()); //7
        //System.out.println(school2.getPupils().size()); //3
    }
}
