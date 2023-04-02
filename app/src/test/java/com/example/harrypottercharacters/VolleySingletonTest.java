package com.example.harrypottercharacters;

import android.content.Context;
import com.android.volley.RequestQueue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.android.volley.toolbox.Volley;

@RunWith(MockitoJUnitRunner.class)
public class VolleySingletonTest {

    private VolleySingleton volleySingleton;

    @Mock
    Context mockContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        volleySingleton = VolleySingleton.getrInstance(mockContext);
    }

    @Test
    public void testGetRequestQueue() {
        RequestQueue mockRequestQueue = Volley.newRequestQueue(mockContext);
        when(volleySingleton.getRequestQueue()).thenReturn(mockRequestQueue);
        assertEquals(mockRequestQueue, volleySingleton.getRequestQueue());
        verify(mockRequestQueue).start();
    }
}
