package com.shalini.bfhl_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.shalini.bfhl_api.dto.BFHLRequest;
import com.shalini.bfhl_api.dto.BFHLResponse;
import com.shalini.bfhl_api.service.BFHLService;

@RestController
@RequestMapping("/bfhl")
@RequiredArgsConstructor
public class BFHLController {

    private final BFHLService bfhlService;

    @PostMapping
    public ResponseEntity<BFHLResponse> process(@RequestBody BFHLRequest request) {
        return ResponseEntity.ok(bfhlService.process(request));
    }
}
