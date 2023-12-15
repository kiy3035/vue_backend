package com.example.demo.chat;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.CloseStatus;

import com.example.demo.chat.dto.ChatDto;
import com.example.demo.chat.mapper.ChatMapper;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


/*
* WebSocket Handler 작성
* 소켓 통신은 서버와 클라이언트가 1:n으로 관계를 맺는다. 따라서 한 서버에 여러 클라이언트 접속 가능
* 서버에는 여러 클라이언트가 발송한 메세지를 받아 처리해줄 핸들러가 필요
* TextWebSocketHandler를 상속받아 핸들러 작성
* 클라이언트로 받은 메세지를 log로 출력하고 클라이언트로 환영 메세지를 보내줌
* */
@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {

    private final ChatMapper chatmapper;
    private final ObjectMapper objectMapper;

    // 현재 연결된 세션들
    private final Set<WebSocketSession> sessions = new HashSet<>();

    // chatRoomId: {session1, session2}
    private final Map<Long,Set<WebSocketSession>> chatRoomSessionMap = new HashMap<>();

    // 소켓 연결 확인
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("---- 연결됨--------------------" +  session.getId());
        sessions.add(session);
    }

    // 소켓 통신 시 메세지의 전송을 다루는 부분
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
        System.out.println("페이로드 :" + payload);

        Map<String, Object> dataMap = objectMapper.readValue(payload, Map.class);

        Optional<Integer> result = findChatRoomYN(dataMap);
        Optional<Integer> result2 = findMaxChatRoomID(dataMap);

        // 기존에 대화방이 있으면
        if(result.isPresent()){
            dataMap.put("chatRoomId", result.get());
        }else{ // 없으면 새로 만들어줌 (MAX ID + 1)
            if(!result2.isPresent()){ // DB에 값이 없으면 (=서버 최초 대화방이 생성될 때)
                dataMap.put("chatRoomId", 1);
            }else{
                dataMap.put("chatRoomId", result2.get() + 1);
            }
        }

        chatmapper.insertMessage(dataMap);
    
    }

    // 기존에 대화방 있는지 찾기
    private Optional<Integer> findChatRoomYN(Map<String, Object> data){
        Integer val = chatmapper.findChatRoomYN(data);
        return Optional.ofNullable(val);
    }

    // MAX ID 찾기
    private Optional<Integer> findMaxChatRoomID(Map<String, Object> data){
        Integer val = chatmapper.findMaxChatRoomID(data);
        return Optional.ofNullable(val);
    }

}


