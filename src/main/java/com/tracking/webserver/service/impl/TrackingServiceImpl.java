package com.tracking.webserver.service.impl;

import com.tracking.webserver.service.TrackingService;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class TrackingServiceImpl implements TrackingService {

    private static String path = "/tmp/ok";

    @Override
    public boolean ping() {

        File file = new File(path);

        return file.isDirectory();
    }

    @Override
    public byte[] img() {
        return new byte[] { 0x47, 0x49, 0x46, 0x38, 0x39, 0x61, 0x1, 0x0, 0x1, 0x0, (byte) 0x80, 0x0, 0x0,
                (byte) 0xff, (byte) 0xff, (byte) 0xff, 0x0, 0x0, 0x0, 0x2c, 0x0, 0x0, 0x0, 0x0, 0x1, 0x0, 0x1, 0x0,
                0x0, 0x2, 0x2, 0x44, 0x1, 0x0, 0x3b };
    }
}
