package com.kodilla.stream.world.array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ArrayOperationsTestSuite {
    @Test
    public void testGetAverage(){
        //Given
        int numbers [] = {2,3,8,5,7,3,5,3,2,1,5,6,4,1};
        double averageExpected = 3.9285714285714284;
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assertions.assertEquals(averageExpected, average, 0.0001);
    }
}
