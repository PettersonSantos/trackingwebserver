package com.tracking.webserver.service.impl;


import com.tracking.webserver.service.TrackingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.File;

@ExtendWith(SpringExtension.class)
public class TrackingServiceImplTest {
    @Mock
    private TrackingService trackingService;

    @Test
    public void fileNotExistsReturnFalse(){
        Mockito.when(trackingService.ping()).thenReturn(false);
        Assertions.assertFalse(trackingService.ping());
    }
    @Test
    public void fileExistsReturnTrue(){
        Mockito.when(trackingService.ping()).thenReturn(true);
        Assertions.assertTrue(trackingService.ping());
    }

    @Test
    public void returnImg(){
        byte[] b = new byte[0];
        Mockito.when(trackingService.img()).thenReturn(b);
        Assertions.assertNotNull(trackingService.img());
    }
}
