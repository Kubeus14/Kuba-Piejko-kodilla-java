package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.testng.Assert.assertThrows;

class FileReaderTestSuite {

//    @Test
//    void testReadFile(){
//        //Given
//        FileReader fileReader = new FileReader();
//        //When
//        assertDoesNotThrow(()->fileReader.readFile());
//    }
    @Test
    void whenFileDoesntExistsReadFileShouldThrowException(){
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "this_file_not_exists";
        //When
        assertThrows(FileReaderException.class,()->fileReader.readFile(fileName));
    }
    @Test
    public void testReadFileWithName() {
        // given
        FileReader fileReader = new FileReader();
        // when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("nie_ma_takiego_pliku.txt")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }



}
