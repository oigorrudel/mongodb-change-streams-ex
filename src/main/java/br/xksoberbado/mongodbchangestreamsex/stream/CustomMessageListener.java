//package br.xksoberbado.mongodbchangestreamsex.stream;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.data.mongodb.core.messaging.Message;
//import org.springframework.data.mongodb.core.messaging.MessageListener;
//import org.springframework.stereotype.Component;
//
////@Component
////@RequiredArgsConstructor
//@Slf4j
//@Component
//class CustomMessageListener<S, T> implements MessageListener<S, T> {
//    @Override
//    public void onMessage(final Message<S, T> message) {
//        log.info(
//            String.format("Received Message in collection %s.\n\trawsource: %s\n\tconverted: %s",
//                message.getProperties().getCollectionName(), message.getRaw(), message.getBody())
//        );
//    }
//
////    private final ReactiveMongoOperations reactiveTemplate;
//
//
//}
