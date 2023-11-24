package com.micro.exception;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseExceptionMessage {
	private String uri;
	private String message;
	@JsonProperty(value = "timestamp")
	private Date responseTimeStamp;
}
