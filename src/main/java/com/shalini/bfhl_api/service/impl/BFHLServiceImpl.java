package com.shalini.bfhl_api.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.shalini.bfhl_api.dto.BFHLRequest;
import com.shalini.bfhl_api.dto.BFHLResponse;
import com.shalini.bfhl_api.service.BFHLService;

@Service
public class BFHLServiceImpl implements BFHLService {

    private static final String USER_ID = "shalini_pandey_21112004";
    private static final String EMAIL = "shalinipandey230900@acropolis.in";
    private static final String ROLL_NUMBER = "0827CS231241";

    @Override
    public BFHLResponse process(BFHLRequest request) {
        if (request == null || request.getData() == null) {
            return BFHLResponse.builder()
                    .isSuccess(false)
                    .userId(USER_ID)
                    .email(EMAIL)
                    .rollNumber(ROLL_NUMBER)
                    .oddNumbers(new ArrayList<>())
                    .evenNumbers(new ArrayList<>())
                    .alphabets(new ArrayList<>())
                    .specialCharacters(new ArrayList<>())
                    .sum("0")
                    .concatString("")
                    .build();
        }

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();

        int sum = 0;
        StringBuilder alphabetConcat = new StringBuilder();

        for (String item : request.getData()) {
            if (item == null || item.isEmpty()) {
                continue;
            }

            if (item.matches("\\d+")) {
                int number = Integer.parseInt(item);
                if (number % 2 == 0) {
                    evenNumbers.add(item);
                } else {
                    oddNumbers.add(item);
                }
                sum += number;
            } else if (item.matches("[a-zA-Z]+")) {
                alphabets.add(item.toUpperCase());
                alphabetConcat.append(item);
            } else {
                specialCharacters.add(item);
            }
        }

        String concatString = generateAlternatingCapsReverse(alphabetConcat.toString());

        return BFHLResponse.builder()
                .isSuccess(true)
                .userId(USER_ID)
                .email(EMAIL)
                .rollNumber(ROLL_NUMBER)
                .oddNumbers(oddNumbers)
                .evenNumbers(evenNumbers)
                .alphabets(alphabets)
                .specialCharacters(specialCharacters)
                .sum(String.valueOf(sum))
                .concatString(concatString)
                .build();
    }

    private String generateAlternatingCapsReverse(String input) {

        String reversed =
                new StringBuilder(input)
                        .reverse()
                        .toString()
                        .toLowerCase();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < reversed.length(); i++) {

            if (i % 2 == 0) {
                result.append(
                        Character.toUpperCase(
                                reversed.charAt(i)
                        )
                );
            } else {
                result.append(
                        Character.toLowerCase(
                                reversed.charAt(i)
                        )
                );
            }
        }

        return result.toString();
    }
}