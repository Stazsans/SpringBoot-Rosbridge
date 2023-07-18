package com.ros.controller;

import com.ros.sseEmitter.SseEmitterServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author ss
 */
@RestController
@RequestMapping("/sse")
public class SseEmitterController {
    /**
     * 用于创建连接
     */
    @GetMapping("/connect/{userRole}")
    public SseEmitter connect(@PathVariable String userRole) {
        return SseEmitterServer.connect(userRole);
    }

}