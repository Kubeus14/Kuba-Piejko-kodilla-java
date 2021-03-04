package com.kodilla.exception.io;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTestSuite {

    @Test
    void testReadFile(){
        //Given
        FileReader fileReader = new FileReader();
        //When and Then
        assertDoesNotThrow(()->fileReader.readFile());
    }
    @Test
    void whenFileDoesntExistsReadFileShouldThrowException(){
        //Given
        FileReader fileReader = new FileReader();
        String fileName = "nie ma takiego pliku.txt";
        //When and then
        assertThrows(FileReaderException.class,()->fileReader.readFile(fileName));
    }
    @Test
    void testReadFileWithName(){
        //Given
        FileReader fileReader = new FileReader();
        //When and then
        assertAll(
                ()->assertThrows(FileReaderException.class,()->fileReader.readFile("nie ma takiego pliku.txt")),
                ()->assertThrows(FileReaderException.class,()->fileReader.readFile(null)),
                ()->assertDoesNotThrow(()->fileReader.readFile("names.txt"))
        );
    }



}
