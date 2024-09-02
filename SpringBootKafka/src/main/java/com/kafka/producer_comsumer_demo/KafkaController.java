package com.kafka.producer_comsumer_demo;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {

//    private final KafkaTemplate<String, SimpleModel> kafkaTemplate;
//
//    @Autowired
//    public  KafkaController(KafkaTemplate<String, SimpleModel> kafkaTemplate){
//        this.kafkaTemplate = kafkaTemplate;
//    }
//
//    @PostMapping("/post")
//    public  void post(@RequestBody SimpleModel simpleModel){
//        kafkaTemplate.send("myTopic", simpleModel);
//    }
//
//    @KafkaListener(topics = "myTopic")
//    public void getFromKafka(SimpleModel simpleModel){
//        System.out.println(simpleModel.toString());
//    }

    private final KafkaTemplate<String, String> kafkaTemplate;
    private Gson jsonConverter;

    @Autowired
    public  KafkaController(KafkaTemplate<String, String> kafkaTemplate, Gson jsonConverter){
        this.kafkaTemplate = kafkaTemplate;
        this.jsonConverter = jsonConverter;
    }

    @PostMapping("/post")
    public  void post(@RequestBody SimpleModel simpleModel){
        kafkaTemplate.send("myTopic", jsonConverter.toJson(simpleModel));
    }

    @KafkaListener(topics = "myTopic")
    public void getFromKafka(String simpleModel){
        System.out.println(simpleModel);

        SimpleModel model = (SimpleModel) jsonConverter.fromJson(simpleModel, SimpleModel.class);
        System.out.println(model.toString());
    }

    @PostMapping("/v2")
    public void post(@RequestBody MoreSimpleModel model){
        kafkaTemplate.send("myTopic2", jsonConverter.toJson(model));
    }

    @KafkaListener(topics = "myTopic2")
    public void getFromKafka2(String moreSimpleModel){
        System.out.println(moreSimpleModel);

        MoreSimpleModel model = (MoreSimpleModel) jsonConverter.fromJson(moreSimpleModel, MoreSimpleModel.class);
        System.out.println(model.toString());
    }
}
