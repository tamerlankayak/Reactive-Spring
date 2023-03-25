package tamerlankayak.az.reactiveprogrammingtrain.student;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository repository;

    public Mono<Student> save(Student student) {
        return repository.save(student);
    }
    //every element of data will show after 100 millis
    //that is why using delayEments() function
    public Flux<Student> findAll() {
        return repository
                .findAll()
                .delayElements(Duration.ofMillis(100));
    }

    public Mono<Student> findById(Integer id) {
        return repository.findById(id);
    }
}
