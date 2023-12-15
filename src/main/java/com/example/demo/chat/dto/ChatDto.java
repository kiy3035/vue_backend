package com.example.demo.chat.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChatDto {
  
    private String myId;

    private String otherId;

    private Long chatRoomId;
    
    private String message;

        
}