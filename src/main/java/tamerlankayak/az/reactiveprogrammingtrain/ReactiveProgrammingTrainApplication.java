package tamerlankayak.az.reactiveprogrammingtrain;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tamerlankayak.az.reactiveprogrammingtrain.student.Student;
import tamerlankayak.az.reactiveprogrammingtrain.student.StudentService;

@SpringBootApplication
public class ReactiveProgrammingTrainApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveProgrammingTrainApplication.class, args);
    }

    //here is starting insert 100 data to DB
    //and subscribing method to flux with subscribe() function
    @Bean
    public CommandLineRunner commandLineRunner(StudentService studentService) {

        return args -> {
            for (int i = 0; i < 100; i++) {
                studentService.save(
                        Student.builder()
                                .firstname("Tamerlam")
                                .lastname("Mustafayev")
                                .age(i)
                                .build()
                ).subscribe();
            }
        };
    }
}
