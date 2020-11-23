package com.kodilla.testing.collection;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers){
        List<Integer>oddNumbersList = new ArrayList<>();

        for(int number : numbers){
            if(number%2==0){
                oddNumbersList.add(number);
            }
        }
        return oddNumbersList;
    }
}
