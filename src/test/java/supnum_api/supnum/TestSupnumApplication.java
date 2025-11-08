package supnum_api.supnum;

import org.springframework.boot.SpringApplication;

public class TestSupnumApplication {

	public static void main(String[] args) {
		SpringApplication.from(SupnumApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
