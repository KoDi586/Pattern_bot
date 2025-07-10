package com.example.Pattern_bot.service.otherService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtherService {

    public void doNothing() {
        System.out.println(
                "do nothing service"
        );
    }

}
