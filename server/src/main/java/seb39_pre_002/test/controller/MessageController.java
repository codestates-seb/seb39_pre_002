//package seb39_pre_002.test.controller;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import seb39_pre_002.test.dto.MessagePostDto;
//import seb39_pre_002.test.entity.Message;
//import seb39_pre_002.test.mapper.MessageMapper;
//import seb39_pre_002.test.sevice.MessageService;
//
//import javax.validation.Valid;
//
//@RequestMapping("/v1/messages")
//@RestController
//public class MessageController {
//    private final MessageService messageService;
//    private final MessageMapper mapper;
//
//    public MessageController(MessageService messageService,
//                             MessageMapper mapper) {
//        this.messageService = messageService;
//        this.mapper = mapper;
//    }
//
//    @PostMapping
//    public ResponseEntity postMessage(
//            @Valid @RequestBody MessagePostDto messagePostDto) {
//        Message message =
//                messageService.createMessage(mapper.messageDtoToMessage(messagePostDto));
//
//        return ResponseEntity.ok(mapper.messageToMessageResponseDto(message));
//    }
//
//}
