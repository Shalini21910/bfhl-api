package com.shalini.bfhl_api.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.shalini.bfhl_api.dto.BFHLRequest;
import com.shalini.bfhl_api.dto.BFHLResponse;

class BFHLServiceImplTest {

    private final BFHLServiceImpl service = new BFHLServiceImpl();

    @Test
    void mixedInput() {
        BFHLRequest req = BFHLRequest.builder()
                .data(Arrays.asList("Ab", "1", "!", "Cd", "2", "@"))
                .build();

        BFHLResponse res = service.process(req);

        assertTrue(res.isSuccess());
        assertEquals("shalini_pandey_21112004", res.getUserId());
        assertEquals("shalinipandey230900@acropolis.in", res.getEmail());
        assertEquals("0827CS231241", res.getRollNumber());

        assertEquals("3", res.getSum());
        assertEquals(Arrays.asList("1"), res.getOddNumbers());
        assertEquals(Arrays.asList("2"), res.getEvenNumbers());
        assertEquals(Arrays.asList("AB", "CD"), res.getAlphabets());
        assertEquals(Arrays.asList("!", "@"), res.getSpecialCharacters());
        assertEquals("DcBa", res.getConcatString());
    }

    @Test
    void alphabetOnly() {
        BFHLRequest req = BFHLRequest.builder()
                .data(Arrays.asList("aBCdE"))
                .build();

        BFHLResponse res = service.process(req);

        assertTrue(res.isSuccess());
        assertEquals("0", res.getSum());
        assertTrue(res.getOddNumbers().isEmpty());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertEquals(Arrays.asList("ABCDE"), res.getAlphabets());
        assertEquals(Collections.emptyList(), res.getSpecialCharacters());
        assertEquals("EdCbA", res.getConcatString());
    }

    @Test
    void numbersOnly() {
        BFHLRequest req = BFHLRequest.builder()
                .data(Arrays.asList("3", "4", "5"))
                .build();

        BFHLResponse res = service.process(req);

        assertTrue(res.isSuccess());
        assertEquals("12", res.getSum());
        assertEquals(Arrays.asList("3", "5"), res.getOddNumbers());
        assertEquals(Arrays.asList("4"), res.getEvenNumbers());
        assertEquals(Collections.emptyList(), res.getAlphabets());
        assertEquals(Collections.emptyList(), res.getSpecialCharacters());
        assertEquals("", res.getConcatString());
    }

    @Test
    void specialCharsOnly() {
        BFHLRequest req = BFHLRequest.builder()
                .data(Arrays.asList("!", "@", "#"))
                .build();

        BFHLResponse res = service.process(req);

        assertTrue(res.isSuccess());
        assertEquals("0", res.getSum());
        assertTrue(res.getOddNumbers().isEmpty());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertEquals(Collections.emptyList(), res.getAlphabets());
        assertEquals(Arrays.asList("!", "@", "#"), res.getSpecialCharacters());
        assertEquals("", res.getConcatString());
    }

    @Test
    void nullInput_returnsFailureResponse() {
        BFHLResponse res = service.process(null);

        assertFalse(res.isSuccess());
        assertEquals("shalini_pandey_21112004", res.getUserId());
        assertEquals("shalinipandey230900@acropolis.in", res.getEmail());
        assertEquals("0827CS231241", res.getRollNumber());
        assertEquals(Collections.emptyList(), res.getOddNumbers());
        assertEquals(Collections.emptyList(), res.getEvenNumbers());
        assertEquals(Collections.emptyList(), res.getAlphabets());
        assertEquals(Collections.emptyList(), res.getSpecialCharacters());
        assertEquals("0", res.getSum());
        assertEquals("", res.getConcatString());
    }

    @Test
    void emptyInput() {
        BFHLRequest req = BFHLRequest.builder()
                .data(Collections.emptyList())
                .build();

        BFHLResponse res = service.process(req);

        assertTrue(res.isSuccess());
        assertEquals("0", res.getSum());
        assertNotNull(res.getOddNumbers());
        assertTrue(res.getOddNumbers().isEmpty());
        assertNotNull(res.getEvenNumbers());
        assertTrue(res.getEvenNumbers().isEmpty());
        assertEquals(Collections.emptyList(), res.getAlphabets());
        assertEquals(Collections.emptyList(), res.getSpecialCharacters());
        assertEquals("", res.getConcatString());
    }
}
