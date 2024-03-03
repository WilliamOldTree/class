package com.example.springbatchv5.job;

import com.example.springbatchv5.step.ImprimeParImparStep;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

    @Bean
    Job parImpar(JobRepository jobRepository, Step parImparStep){
        return new JobBuilder("parImpar", jobRepository)
                .start(parImparStep)
                .build();
    }

}
