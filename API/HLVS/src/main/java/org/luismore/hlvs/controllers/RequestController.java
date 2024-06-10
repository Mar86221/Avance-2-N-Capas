package org.luismore.hlvs.controllers;

import org.luismore.hlvs.domain.dtos.RequestDTO;
import org.luismore.hlvs.domain.dtos.GeneralResponse;
import org.luismore.hlvs.domain.entities.Request;
import org.luismore.hlvs.domain.entities.User;
import org.luismore.hlvs.services.RequestService;
import org.luismore.hlvs.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @Autowired
    private UserService userService;

    @GetMapping("/home/{homeId}/pending")
    public ResponseEntity<GeneralResponse> getPendingRequests(@PathVariable Long homeId) {
        List<Request> requests = requestService.getRequestsByHomeId(homeId);
        return GeneralResponse.getResponse(requests, "Pending requests fetched successfully");
    }

    @PostMapping("/")
    public ResponseEntity<GeneralResponse> createRequest(@RequestBody RequestDTO request, @RequestHeader("userId") Long userId) {
        User user = userService.findById(userId);
        String role = user.getRole();
        Request createdRequest = requestService.createRequest(request, role);
        return GeneralResponse.getResponse(createdRequest, "Request created successfully");
    }

    @GetMapping("/history")
    public ResponseEntity<GeneralResponse> getRequestHistory() {
        List<Request> requestHistory = requestService.getRequestHistory();
        return GeneralResponse.getResponse(requestHistory, "Request history fetched successfully");
    }

    @PutMapping("/{requestId}")
    public ResponseEntity<GeneralResponse> updateRequest(@PathVariable Long requestId, @RequestBody RequestDTO request, @RequestHeader("userId") Long userId) {
        User user = userService.findById(userId);
        String role = user.getRole();
        Request updatedRequest = requestService.updateRequest(requestId, request, role);
        return GeneralResponse.getResponse(updatedRequest, "Request updated successfully");
    }
}
