package br.com.enzomoralesl.medapp.infrastructure.config;

import br.com.enzomoralesl.medapp.adapter.output.repository.DoctorRepository;
import br.com.enzomoralesl.medapp.adapter.output.repository.IJPADoctorRepository;
import br.com.enzomoralesl.medapp.application.services.CreateDoctorUseCases;
import br.com.enzomoralesl.medapp.application.usecases.ICreateDoctorUseCases;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;
import br.com.enzomoralesl.medapp.utils.IDoctorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.enzomoralesl.medapp.utils")
public class BeanConfiguration {

    @Bean
    ICreateDoctorUseCases createDoctorUseCase(IDoctorRepository repository, @Autowired IDoctorMapper mapper) {
        return new CreateDoctorUseCases(repository, mapper);
    }

    @Bean
    IDoctorRepository doctorRepository(IJPADoctorRepository repository) {
        return new DoctorRepository(repository);
    }
}
