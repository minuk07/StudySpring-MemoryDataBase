package com.example.memorydb.entity;

import jakarta.websocket.server.ServerEndpoint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


public class Entity implements PrimaryKey{

    @Getter
    @Setter
    private Long id;
}
