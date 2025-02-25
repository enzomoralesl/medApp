package br.com.enzomoralesl.medapp.infrastructure.config;

import br.com.enzomoralesl.medapp.adapter.output.repository.DoctorRepository;
import br.com.enzomoralesl.medapp.adapter.output.repository.IJPADoctorRepository;
import br.com.enzomoralesl.medapp.application.services.DoctorUseCases;
import br.com.enzomoralesl.medapp.application.usecases.IDoctorUseCases;
import br.com.enzomoralesl.medapp.domain.doctor.IDoctorRepository;
import br.com.enzomoralesl.medapp.utils.IDoctorMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.enzomoralesl.medapp.utils")
public class BeanConfiguration {

    @Bean
    IDoctorUseCases doctorUseCase(IDoctorRepository repository, @Qualifier("IDoctorMapperImpl") IDoctorMapper mapper) {
        return new DoctorUseCases(repository, mapper);
    }

    @Bean
    IDoctorRepository doctorRepository(IJPADoctorRepository repository) {
        return new DoctorRepository(repository);
    }
}
