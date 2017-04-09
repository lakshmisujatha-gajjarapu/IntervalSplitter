package com.submission.intervalSplitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages={"com.submission.intervalSplitter"})
public class IntervalSplitterApplication {

	public static void main(String[] args) {
		SpringApplication.run(IntervalSplitterApplication.class, args);
	}
}
