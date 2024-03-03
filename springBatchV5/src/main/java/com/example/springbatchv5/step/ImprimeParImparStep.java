package com.example.springbatchv5.step;

import org.springframework.batch.core.JobInterruptedException;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.function.FunctionItemProcessor;
import org.springframework.batch.item.support.IteratorItemReader;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@Configuration
public class ImprimeParImparStep {

    @Bean
    Step imprimeParImpar(JobRepository jobRepository) {
        return new StepBuilder("imprimeParImpar", jobRepository)
                .<Integer, String>chunk(1)
                .reader(contarReader())
                .processor(parImparProcessor())
                .writer(imprimirWrite())
                .build();
    }

    public IteratorItemReader<Integer> contarReader (){
        List<Integer> contador = Arrays.asList(1, 2, 3 ,4 ,5);
        return new IteratorItemReader<Integer>(contador.iterator());
    }

    public FunctionItemProcessor<Integer, String> parImparProcessor(){
        return new FunctionItemProcessor<Integer, String>(
                item -> item % 2 == 0 ? String.format("Item %s é par", item) : String.format("Item %s é impar", item)
        );
    }

    public ItemWriter<String> imprimirWrite () {
        return itens -> itens.forEach(System.out::println);

    }
}


//    Step com tasklet

//    @Bean
//    public Step imprimeOlaMundo (JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new StepBuilder("imprimeOlaMundo", jobRepository)
//                .tasklet(imprimeOlaMundoTasklet(null), transactionManager)
//                .build();
//
//    }


//    @StepScope
//    @Bean
//    public Tasklet imprimeOlaMundoTasklet(@Value("#{jobParameters['name']}") String nome){
//        return new Tasklet() {
//            @Override
//            public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
//                System.out.println(String.format("Ola, %s!", nome));
//                return RepeatStatus.FINISHED;
//            }
//        };



