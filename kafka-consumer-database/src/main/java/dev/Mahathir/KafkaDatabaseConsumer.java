package dev.Mahathir;

import dev.Mahathir.entity.WikimediaData;
import dev.Mahathir.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository){
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "wikimedia_recentchange",
            groupId="myGroup"
    )
    public void consume(String eventMessage){
        LOGGER.info("Received message received "+ eventMessage);

        WikimediaData wikimediaData = new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        dataRepository.save(wikimediaData);
        // process the event message and insert into database
    }

}
