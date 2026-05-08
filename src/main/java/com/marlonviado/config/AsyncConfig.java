package com.marlonviado.config;

import java.util.concurrent.Executor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {
	
	@Bean("taskExecutor")
	Executor taskExecutor() {
		
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor() {

			private static final long serialVersionUID = 1L;
			
			@Override
			public void execute(Runnable task) {
				logger.info("Task Submitted");
				super.execute(() -> {
					logger.info("Task started!!!");
					try {
						task.run();
						logger.info("Task Completed " + Thread.currentThread().getName());
					} catch(Exception e) {
						logger.error("Task Failed "+Thread.currentThread().getName());
					}
				});
			}
			
		};
		executor.setCorePoolSize(10);
		executor.setMaxPoolSize(10);
		executor.setQueueCapacity(100); // maximum number of task that can be held to the queue, but if the queue is full it will trigger the creation of new thread
		executor.initialize();
		executor.setThreadNamePrefix("AsyncExecutor-");
		return executor;
	}

}
