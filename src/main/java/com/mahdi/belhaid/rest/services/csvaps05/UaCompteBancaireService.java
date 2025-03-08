package com.mahdi.belhaid.rest.services.csvaps05;

import com.mahdi.belhaid.rest.dto.ApiResponse;
import com.mahdi.belhaid.rest.dto.CBValeur;
import com.mahdi.belhaid.rest.dto.ErrorResponse;
import com.mahdi.belhaid.rest.exceptions.WsException;
import java.util.Comparator;
import java.util.List;

public final class UaCompteBancaireService {

    private UaCompteBancaireService(){}
    public static CBValeur getCBValeur (String codeUa) throws WsException {
        ApiResponse<List<CBValeur>> apiResponse = UaCompteBancaireClient.getCBValeur(codeUa, null, null);
        if (!apiResponse.hasError()) {
            List<CBValeur> comptes = apiResponse.getData();
            return comptes.stream()
                    .sorted(Comparator.comparing(CBValeur::getCodeFlux))
                    .filter(cb -> cb.getCodeFlux().equals("051"))
                    .findFirst()
                    .orElse(comptes.get(0));
        }else{
            throw new WsException(handleError(apiResponse.getErrorMessage()));
        }

    }

    public static String handleError(ErrorResponse errorResponse){
        return "{code: "+errorResponse.getCode()+", libelle:"+errorResponse.getLibelle()+" ,description:"+errorResponse.getDescription()+"}";
    }

}
