package com.alura.pix.streams;

import com.alura.pix.dto.PixDTO;
import com.alura.pix.serdes.PixSerdes;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PixAggregator {

    @Autowired
    public void aggregator(StreamsBuilder streamsBuilder) {
        KStream<String, PixDTO> messageStream = streamsBuilder
                .stream("pix-topic", Consumed.with(Serdes.String(), PixSerdes.serdes()))
                .peek((key, value) -> log.info("Pix recebido: " + value.getChaveOrigem()))
                .filter((key, value) -> value.getValor() > 10000)
                .peek((key, value) -> log.info("Pix: " + key + " será verificado para possível frause"));

        messageStream.print(Printed.toSysOut());
        messageStream.to("pix-verificacao-fraude", Produced.with(Serdes.String(), PixSerdes.serdes()));
    }
}
