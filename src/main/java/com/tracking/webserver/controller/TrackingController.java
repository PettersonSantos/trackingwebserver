package com.tracking.webserver.controller;

import com.tracking.webserver.common.Routes;
import com.tracking.webserver.service.TrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@RestController
public class TrackingController {

    @Autowired
    private TrackingService service;

    @GetMapping(path = Routes.PING)
    public ResponseEntity<String> ping() {
        if (service.ping()) {
            return new ResponseEntity<>("OK",
                    HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping(path = Routes.IMG)
    public void img(HttpServletResponse response) throws IOException {

        byte[] trackingGif = service.img();

        response.setContentType("image/gif");
        response.setContentLength(trackingGif.length);

        OutputStream out = response.getOutputStream();
        out.write(trackingGif);
        out.close();
    }
}
