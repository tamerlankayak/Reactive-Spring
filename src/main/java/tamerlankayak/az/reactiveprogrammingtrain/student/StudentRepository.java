package tamerlankayak.az.reactiveprogrammingtrain.student;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface StudentRepository extends ReactiveCrudRepository<Student, Integer> {
    //for fetching data list we are usinng Flux class
    Flux<Student> findAllByFirstnameIgnoreCase(String firstname);
}
