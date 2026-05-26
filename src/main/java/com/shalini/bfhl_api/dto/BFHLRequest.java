package com.shalini.bfhl_api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BFHLRequest {
    // Generic list of tokens (strings). Service expects items like numbers, words, or special tokens.
    private List<String> data;
}
