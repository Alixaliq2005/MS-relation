package az.ingress.msrelation;

import az.ingress.msrelation.domain.Booking;
import az.ingress.msrelation.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MsRelationApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(MsRelationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//        User user= User.builder()
//                .userId(1L)
//                .name("Ali")
//                .surname("Xaliq")
//                .email("alixaliq@gmail.com")
//                .phoneNumber("0706876721")
//                .build();
//        userRepository.save(user);
//
//        Booking booking = Booking.builder()
//                .id(5L)
//                .bookingDate("05.05.2002")
//                .totalCost("550 dollar")
//                .build();
    }
}
