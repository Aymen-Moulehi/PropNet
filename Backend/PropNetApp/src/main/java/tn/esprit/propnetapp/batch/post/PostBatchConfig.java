package tn.esprit.propnetapp.batch.post;


import lombok.AllArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import tn.esprit.propnetapp.post.Post;
import tn.esprit.propnetapp.post.PostRepository;


@AllArgsConstructor
@Configuration
@EnableBatchProcessing
public class PostBatchConfig {
    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private PostRepository postRepository;

    @Bean
    public FlatFileItemReader<Post> reader() {
        FlatFileItemReader<Post> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/csv/Post.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }


    private LineMapper<Post> lineMapper() {
        DefaultLineMapper<Post> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer delimitedLineTokenizer = new DelimitedLineTokenizer();
        delimitedLineTokenizer.setDelimiter(",");
        delimitedLineTokenizer.setStrict(false);
        delimitedLineTokenizer.setNames("idPost", "imageUrl","title", "content", "category", "relatedTags", "status", "formatedDate");
        BeanWrapperFieldSetMapper<Post>  fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Post.class);
        lineMapper.setLineTokenizer(delimitedLineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;
    }

    @Bean
    public PostProcessor postProcessor() {
        return new PostProcessor();
    }

    @Bean
    public RepositoryItemWriter<Post> postRepositoryItemWriter() {
        RepositoryItemWriter<Post> writer = new RepositoryItemWriter<>();
        writer.setRepository(postRepository);
        writer.setMethodName("save");
        return writer;
    }
    @Bean
    public Step step() {
        return stepBuilderFactory.get("load-data-from-csv-file").<Post, Post>chunk(10)
                .reader(reader())
                .processor(postProcessor())
                .writer(postRepositoryItemWriter())
                .build();
    }
    @Bean
    public Job loadPostData() {
        return jobBuilderFactory.get("load-post-data").flow(step()).end().build();
    }
}
