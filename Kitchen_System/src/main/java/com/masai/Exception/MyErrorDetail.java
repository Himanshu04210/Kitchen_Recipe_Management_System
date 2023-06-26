package com.masai.Exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyErrorDetail {
	private LocalDateTime timeStamp;
	private String message;
	private String detail;
	
}
