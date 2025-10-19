package in.nareshit.raghu.batchconfig;

import in.nareshit.raghu.model.Uom;
import in.nareshit.raghu.service.IUomService;
import in.nareshit.raghu.util.AppUtil;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class UomBatchConfig {

    @Autowired
    private IUomService service;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    // a. reader object
    @Bean
    public ItemReader<Uom> readerUom() {
        FlatFileItemReader<Uom> reader = new FlatFileItemReader<>();
        reader.setResource(new FileSystemResource("E:/batchinput/uoms.csv"));
		/*try {
			reader.setResource(new UrlResource("http://abcd.com/uoms.csv"));
		} catch (Exception e) {
			e.printStackTrace();
		}*/
        reader.setLineMapper(new DefaultLineMapper<>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setDelimiter(",");
                setNames("uomType", "uomModel", "description");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {{
                setTargetType(Uom.class);
            }});
        }});
        return reader;
    }

    // b. processor object
    @Bean
    public ItemProcessor<Uom, Uom> processorUom() {
        return (ob) -> {
            ob.setUomModel(ob.getUomModel().toUpperCase());
            if (!AppUtil.getUomTypes().contains(ob.getUomType())) {
                ob.setUomType("NA");
            }
            ob.setDescription(ob.getDescription().toUpperCase());
            if (service.isUomModelExist(ob.getUomModel())) {
                return null;
            } else {
                return ob;
            }
        };
    }

    // c. writer object
    @Bean
    public ItemWriter<Uom> writerUom() {
        JpaItemWriter<Uom> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory);
        return writer;
    }

    // d. listener object
    @Bean
    public JobExecutionListener listenerUom() {
        return new JobExecutionListener() {

            public void beforeJob(JobExecution je) {
                System.out.println("Started with " + je.getStatus());
            }

            public void afterJob(JobExecution je) {
                System.out.println("Finished with " + je.getStatus());
            }
        };
    }


    // g. step object
    @Bean
    public Step stepUom(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("stepUom", jobRepository)
                .<Uom, Uom>chunk(100, transactionManager) //one batch size
                .reader(readerUom()) //reader object name
                .processor(processorUom()) //processor object name
                .writer(writerUom())//writer object name
                .build();
    }


    // i. job object
    @Bean
    public Job jobUom(JobRepository jobRepository, Step stepUom) {
        return new JobBuilder("jobUom", jobRepository)
                .listener(listenerUom())
                .incrementer(new RunIdIncrementer())
                .start(stepUom)
                .build()
                ;
    }
}
