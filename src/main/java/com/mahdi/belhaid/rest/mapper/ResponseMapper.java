package com.mahdi.belhaid.rest.mapper;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.mahdi.belhaid.rest.config.ObjectMapperFactory;
import com.mahdi.belhaid.rest.dto.ApiResponse;
import com.mahdi.belhaid.rest.dto.ErrorResponse;

import java.util.ArrayList;
import java.util.List;

public class ResponseMapper {
    private ResponseMapper(){}
    public static <R> ApiResponse<List<R>> fetchDataList(String responseBody, Class<R> clazz) {
        ApiResponse<List<R>> apiResponse = new ApiResponse<>();
        ObjectMapper mapper = ObjectMapperFactory.getInstance();
        try {
            JsonNode jsonNode = mapper.readTree(responseBody);

            if (isErrorResponse(jsonNode)) {
                ErrorResponse error = mapper.convertValue(jsonNode,ErrorResponse.class);
                apiResponse.setErrorMessage(error);
            }else{
                CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, clazz);
                List<R> dataList = mapper.convertValue(jsonNode,listType);
                apiResponse.setData(dataList);
            }


        } catch (Exception e) {
            apiResponse.setErrorMessage(new ErrorResponse("50000", e.getMessage(), e.getCause().getMessage()));

        }
        return apiResponse;
    }
    public static <R> ApiResponse<R> fetchData(String responseBody, Class<R> clazz) {

        ApiResponse<R> apiResponse = new ApiResponse<>();
        ObjectMapper mapper = ObjectMapperFactory.getInstance();

        try {
            JsonNode jsonNode = mapper.readTree(responseBody);

            if (isErrorResponse(jsonNode)) {
                ErrorResponse error = mapper.convertValue(jsonNode,ErrorResponse.class);
                apiResponse.setErrorMessage(error);

            }

            R data = mapper.convertValue(jsonNode,clazz);
            apiResponse.setData(data);

        } catch (Exception e) {
            apiResponse.setErrorMessage(new ErrorResponse("7000", "Parsing Error", "Failed to parse response"));

        }
        return apiResponse;
    }


    private static boolean isErrorResponse(JsonNode jsonNode) {
        return jsonNode.isObject() && jsonNode.has("code") && jsonNode.has("libelle");
    }
}
