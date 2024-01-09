package com.example.projet_sem;

import com.example.projet_sem.Dao.B3Repository;
import com.example.projet_sem.Dao.WeddingCertificateRepository;
import com.example.projet_sem.security.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class ProjetSemApplication  {
    //@Autowired
    private B3Repository b3Repository;
    //@Autowired
    private WeddingCertificateRepository weddingCertificateRepository;


    public static void main(String[] args) {
        SpringApplication.run(ProjetSemApplication.class, args);
    }




    @Bean
    PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder() ;
    }

    //@Bean
    CommandLineRunner commandLineRunner(IAccountService accountService) {
        return args -> {
            accountService.addRole("USER");
            accountService.addRole("ADMIN");
            accountService.addUser("user", "123", "user@gmail.com");
            accountService.addUser("admin","123","admin@gmail.com");
            accountService.addroletoUser("user","USER");
            accountService.addroletoUser("admin","ADMIN");
            accountService.addroletoUser("admin", "USER");

        };
    }

}