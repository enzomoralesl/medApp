/*
package br.com.enzomoralesl.medapp.infrastructure.config;

import br.com.enzomoralesl.medapp.adapter.output.repository.DoctorRepository;
import br.com.enzomoralesl.medapp.repository.IJPADoctorRepository;
import br.com.enzomoralesl.medapp.service.DoctorService;
import br.com.enzomoralesl.medapp.service.IDoctorService;
import br.com.enzomoralesl.medapp.utils.mapper.IDoctorMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "br.com.enzomoralesl.medapp.utils")
public class BeanConfiguration {

    @Bean
    IDoctorService doctorService(IDoctorRepository repository, @Qualifier("IDoctorMapperImpl") IDoctorMapper mapper) {
        return new DoctorService(repository, mapper);
    }

    @Bean
    IDoctorRepository doctorRepository(IJPADoctorRepository repository) {
        return new DoctorRepository(repository);
    }
}
*/
