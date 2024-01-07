package com.studentRegistrationSysytem.utils;


import com.studentRegistrationSysytem.dto.ResponseDataDto;
import com.studentRegistrationSysytem.dto.ResponseListDto;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

public class ResponseUtils {
    public static <T> ResponseEntity<T> getOKResponse(T obj) {

        return returnResposne(obj, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> getTestOKResponse(T obj) {
        return returnResposne(obj, HttpStatus.OK);
    }

    public static <T> ResponseEntity<T> getCreatedResponse(T obj) {

        return returnResposne(obj, HttpStatus.CREATED);
    }

    public static <T> ResponseEntity<T> getBadRequestResponse(T obj) {
        return returnResposne(obj, HttpStatus.BAD_REQUEST);
    }

    public static <T> ResponseEntity<T> getUnAuthorizedResponse(T obj) {
        return returnResposne(obj, HttpStatus.UNAUTHORIZED);
    }

    public static <T> ResponseEntity<T> getNotFoundResponse(T obj) {

        return returnResposne(obj, HttpStatus.NOT_FOUND);
    }

    public static <T> ResponseEntity<T> getInternalServerErrorResponse(T obj) {
        return returnResposne(obj, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static <T> ResponseEntity<T> getNoContentResponse(T obj) {
        return returnResposne(obj, HttpStatus.NO_CONTENT);
    }

    public static <T> ResponseEntity<T> getAcceptedResponse(T obj) {
        return returnResposne(obj, HttpStatus.ACCEPTED);
    }

    private static <T> ResponseEntity<T> returnResposne(T obj,HttpStatus status){
        return new ResponseEntity<T>( obj, status);
    }

    public static <T> ResponseListDto<T> createOKResponse(String responseMessage, List<T> data) {
        ResponseListDto<T> response = new ResponseListDto<>();
        response.setStatusMsg("OK");
        response.setStatusCode("200");
        response.setResponseMessage(responseMessage);
        response.setDataList(data);
        return response;
    }

    public static <T> ResponseListDto<T> createNotFoundResponse(String message) {
        ResponseListDto<T> response = new ResponseListDto<>();
        response.setResponseMessage("No Data found with provided details");
        response.setStatusCode("404");
        response.setStatusMsg("NOT_FOUND");
        response.setDataList(Collections.emptyList());
        return response;
    }
    public static <T> ResponseListDto<T> createInternalServerErrorResponse(Exception e) {
        ResponseListDto<T> response = new ResponseListDto<>();
        response.setResponseMessage("Error Occurred TRY after SomeTimes"+e.getMessage());
        response.setStatusCode("500");
        response.setStatusMsg("INTERNAL_SERVER_ERROR");
        response.setDataList(Collections.emptyList());
        return response;
    }

    public static  <T> ResponseDataDto<T> createFoundResponse(String responseMessage, T data) {
        ResponseDataDto<T> response = new ResponseDataDto<>();
        response.setStatusMsg("OK");
        response.setStatusCode("200");
        response.setResponseMessage(responseMessage);
        response.setData(data);
        return response;
    }

    public static <T> ResponseDataDto<T> createNotFoundResponseForData(String responseMessage) {
        ResponseDataDto<T> response = new ResponseDataDto<>();
        response.setResponseMessage(responseMessage);
        response.setStatusCode("404");
        response.setStatusMsg("NOT_FOUND");
        response.setData(null);
        return response;
    }

    public static <T> ResponseDataDto<T> saveDataResponse(String msg,T data) {
        ResponseDataDto<T> response = new ResponseDataDto<>();
        response.setResponseMessage(msg);
        response.setStatusCode("201");
        response.setStatusMsg("Created");
        response.setData(data);
        return response;
    }

    public static <T> ResponseDataDto<T> createInternalResponse(DataAccessException e) {
        ResponseDataDto<T> response = new ResponseDataDto<>();
        response.setResponseMessage("Error Occurred TRY after SomeTimes"+e.getMessage());
        response.setStatusCode("500");
        response.setStatusMsg("INTERNAL_SERVER_ERROR");
        response.setData(null);
        return response;
    }


    //for bad request
    public static <T> ResponseDataDto<T> createBadRequestResponse(String responseMessage) {
        ResponseDataDto<T> response = new ResponseDataDto<>();
        response.setResponseMessage(responseMessage);
        response.setStatusCode("400");
        response.setStatusMsg("BAD_REQUEST");
        response.setData(null);
        return response;
    }

}
