package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {

    @Test
    void testReadFile(){
        //Given
        FileReader fileReader = new FileReader();
        //When and then
        assertDoesNotThrow(()->fileReader.readFile());
    }
    @Test
    void whenFileDoesntExistsReadFileShouldThrowException(){
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "no file";
        //When and then
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
