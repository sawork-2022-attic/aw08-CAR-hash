package com.micro.delivery.checker;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface Sink {
    String INPUT="input";

    @Input("input")
    MessageChannel input();
}
