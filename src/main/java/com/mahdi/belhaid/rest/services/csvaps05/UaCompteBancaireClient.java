package com.mahdi.belhaid.rest.services.csvaps05;

import com.mahdi.belhaid.rest.dto.ApiResponse;
import com.mahdi.belhaid.rest.dto.CBValeur;
import com.mahdi.belhaid.rest.dto.ErrorResponse;
import com.mahdi.belhaid.rest.factory.ApiClientFactory;
import com.mahdi.belhaid.rest.interfaces.Csvaps05SynchroneInterface;
import com.mahdi.belhaid.rest.mapper.ResponseMapper;

import javax.ws.rs.core.Response;
import java.util.List;

public final class UaCompteBancaireClient {

    public static final String  CSVAPS05 = "CSVAPS05";
    private UaCompteBancaireClient(){}
    public static ApiResponse<List<CBValeur>> getCBValeur(String codeUa, String date, String codeFlux) {
        try(
                Response response = ApiClientFactory
                .createClient(Csvaps05SynchroneInterface.class,CSVAPS05)
                .uaCompteBancaire(codeUa,date,codeFlux)){

            String responseBody = response.readEntity(String.class);
            return ResponseMapper.fetchDataList(responseBody, CBValeur.class);
        }catch (Exception exception){
            ErrorResponse errorResponse = new ErrorResponse("999999",exception.getMessage(),exception.getCause().getMessage());
            return new ApiResponse<>(errorResponse);
        }

    }

}
