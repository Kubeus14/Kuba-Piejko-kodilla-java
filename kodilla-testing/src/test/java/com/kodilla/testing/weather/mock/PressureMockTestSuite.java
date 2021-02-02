package com.kodilla.testing.weather.mock;

import com.kodilla.testing.mockTraining.Pascals;
import com.kodilla.testing.mockTraining.PressureCentral;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PressureMockTestSuite{
    @Mock
    private Pascals pascals;
    @Test
    void testCalculatePascalsWithMock(){
        //Given
        Pascals pascalsMock = mock(Pascals.class);
        Map<String,Double> resultsMap = new HashMap<>();
        resultsMap.put("London",15.4);
        resultsMap.put("Tokyo",17.7);
        resultsMap.put("Paris",12.3);

        when(pascalsMock.getResults()).thenReturn(resultsMap);
        PressureCentral pressureCentral = new PressureCentral(pascalsMock);

        //When
        int quantityOfSensors = pressureCentral.calculatePascals().size();
        //Then
        Assertions.assertEquals(3,quantityOfSensors);

    }
}
