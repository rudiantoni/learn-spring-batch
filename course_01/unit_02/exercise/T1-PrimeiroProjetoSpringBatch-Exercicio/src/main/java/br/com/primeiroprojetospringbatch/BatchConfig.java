package br.com.primeiroprojetospringbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {
  private JobBuilderFactory jobBuilderFactory;
  private StepBuilderFactory stepBuilderFactory;
  
  private Step imprimeOlaStep() {
    return stepBuilderFactory.get("imprimeOlaStep").tasklet(new Tasklet() {
      @Override
      public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("Olá, mundo!");
        return RepeatStatus.FINISHED;
      }
    }).build();
  }
  
  private Job imprimeOlaJob() {
    return jobBuilderFactory.get("imprimeOlaJob").start(imprimeOlaStep()).build();
  }
}
