package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TimestampUpdateService {

	@Autowired
	private CcuRepository ccuRepository;

	@Autowired
	private HealthRepository healthRepository;

	@Scheduled(fixedRate = 10000)
	void updateTimestamp() {
		System.out.println("Updating the timestamps now ...");
		this.ccuRepository.updateTimestamp();
		this.healthRepository.updateTimestamp();
	}
}
