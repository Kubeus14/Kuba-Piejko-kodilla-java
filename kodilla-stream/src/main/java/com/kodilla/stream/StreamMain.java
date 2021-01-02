package com.kodilla.stream;                                                   // [1]

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;
// [2]

public class StreamMain {                                                     // [3]

    public static void main(String[] args) {                                   // [4]
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        //exercise 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifulText = poemBeautifier.beautify("Text to beautify", (text -> text.toUpperCase()));
        System.out.println(beautifulText);

        String beautifulText2 = poemBeautifier.beautify("Text to beautify", (text -> "ABC" + text + "ABC"));
        System.out.println(beautifulText2);

        String beautifulText3 = poemBeautifier.beautify("Text to beautify", (text -> text.replace(" ", "*")));
        System.out.println(beautifulText3);

        String beautifulText4 = poemBeautifier.beautify("Text to beautify", (text -> text.length() + " letters ***" + text + "*** " + text.length() + " letters"));
        System.out.println(beautifulText4);

        String beautifulText5 = poemBeautifier.beautify("Text to beautify", (text -> text.concat(String.valueOf(text.hashCode()))));
        System.out.println(beautifulText5);

        String beautifulText6 = poemBeautifier.beautify("Ble ble ble!!!", (text -> {
            StringBuilder sb = new StringBuilder();
            sb.append("|");
            for (int i = 0; i < text.length(); i++) {
                sb.append(text.charAt(i));
                sb.append("|");
            }
            return sb.toString();
        }));
        System.out.println(beautifulText6);

        String beautifulText7 = poemBeautifier.beautify("Ble ble ble!!!", (text -> text.chars()
                .mapToObj(i -> Character.toString((char) i))
                .collect(Collectors.joining("|"))
        ));
        System.out.println(beautifulText7);

        //exercise 7.2
        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);

        //exercise 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> mapOfForumUsers = forum.getForumUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                .filter(forumUser-> Period.between(forumUser.getBirthdayDate(), LocalDate.now()).getYears()>=20)
                .filter(forumUser -> forumUser.getPostsQty()>=1)
                .collect(Collectors.toMap(ForumUser::getIDNumber, ForumUser -> ForumUser));

        mapOfForumUsers.entrySet().stream()
                .map(entry -> entry.getKey() + ": "+ entry.getValue())
                .forEach(System.out::println);
    }
}




