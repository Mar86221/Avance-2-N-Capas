package org.luismore.hlvs.services;

import org.luismore.hlvs.domain.dtos.RequestDTO;
import org.luismore.hlvs.domain.entities.Request;

import java.util.List;

public interface RequestService {
    List<Request> getRequestsByHomeId(Long homeId);
    Request createRequest(RequestDTO requestDto, String role);
    List<Request> getRequestHistory();
    Request updateRequest(Long requestId, RequestDTO requestDto, String role);
}
