package com.example.DIRESA.dto.response;


import com.example.DIRESA.controller.commons.CodEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomResponse {

	private CodEnum code;
	private Object message;
	private Object data;

}