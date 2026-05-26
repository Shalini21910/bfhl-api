package com.shalini.bfhl_api.service;

import com.shalini.bfhl_api.dto.BFHLRequest;
import com.shalini.bfhl_api.dto.BFHLResponse;

public interface BFHLService {
    BFHLResponse process(BFHLRequest request);
}
