package org.kgyury.chat.controllers;

import org.kgyury.chat.entities.Chatroom;
import org.kgyury.chat.requests.CreateChatroomRequest;
import org.kgyury.chat.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rooms")
public class ChatRoomController {

    @Autowired
    private ChatroomService chatroomService;

    @PostMapping("")
    public ResponseEntity<String> createChatroom(@RequestBody CreateChatroomRequest request) {

        chatroomService.createChatroom(request.getChatroomName());

        return ResponseEntity.ok("Created Chatroom");
    }

    @GetMapping("")
    public ResponseEntity<List<Chatroom>> getChatroomList() {

        List<Chatroom> chatroomList = chatroomService.getChatroomList();

        return ResponseEntity.ok(chatroomList);
    }
//
//
//    @PostMapping("/join")
//    public ResponseEntity<String> joinChatRoom(@RequestBody ChatroomUserRequest request) {
//        // chatroomService.joinChatRoom(request.getChatroomId(), request.getUserId()
//        return ResponseEntity.ok("Joined chat room");
//
//    }
}
