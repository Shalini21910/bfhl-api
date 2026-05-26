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
public class BFHLResponse {
    private boolean isSuccess;
    private String userId;
    private String email;
    private String rollNumber;

    private List<String> oddNumbers;
    private List<String> evenNumbers;
    private List<String> alphabets;
    private List<String> specialCharacters;

    private String sum;
    private String concatString;
}
