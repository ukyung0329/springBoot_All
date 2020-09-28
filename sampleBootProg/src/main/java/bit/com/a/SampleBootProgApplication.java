package bit.com.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "bit.com.a")
public class SampleBootProgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleBootProgApplication.class, args);
	}

}
