package com.kodilla.stream;                                                   // [1]

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.Executor;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.lambda.Processor;
import com.kodilla.stream.person.People;
import com.kodilla.stream.reference.FunctionalCalculator;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {                                                     // [3]

    public static void main(String[] args) {

        Processor processor = new Processor();
        Executor codeToExecute = ()-> System.out.println("Example text");
        processor.execute(codeToExecute);


        // [4]
        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExpression(3,3,(a,b)->a+b);
        expressionExecutor.executeExpression(3,3,(a,b)->a-b);
        expressionExecutor.executeExpression(3,3,(a,b)->a*b);
        expressionExecutor.executeExpression(3,3,(a,b)->a/b);
        //
        expressionExecutor.executeExpression(4,4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(4,4,FunctionalCalculator::divideAByB);
        expressionExecutor.executeExpression(4,4,FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(4,4,FunctionalCalculator::subAFromB);



        //exercise 7.1
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        String beautifulText1 = poemBeautifier.beautify("Text to beautify",(text->text.toUpperCase()));
        System.out.println(beautifulText1);

        String beautifulText2 = poemBeautifier.beautify("Text to beautify",text -> "ABC"+text+"ABC");
        System.out.println(beautifulText2);

        String beautifulText3 = poemBeautifier.beautify("Text to beautify",text-> text.replace(" ","*"));
        System.out.println(beautifulText3);

        String beautifulText4 = poemBeautifier.beautify("Text to beautify",text -> text.length()+" letters***"+text+ "*** " + text.length() + " letters");
        System.out.println(beautifulText4);

        String beautifulText5 = poemBeautifier.beautify("Text to beautify",text->text.concat(String.valueOf(text.hashCode())));
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
        NumbersGenerator.generateEven(10);


        //exercise 7.3
        Forum forum = new Forum();
        Map<Integer, ForumUser> forumUserMap = forum.getForumUserList().stream()
                .filter(forumUser -> forumUser.getSex()=='M')
                .filter(forumUser -> Period.between(forumUser.getBirthDate(),LocalDate.now()).getYears()>=20)
                .filter(forumUser -> forumUser.getPostsQty()>=1)
                .collect(Collectors.toMap(ForumUser::getIdNumber,ForumUser->ForumUser));
        forumUserMap.entrySet().stream()
                .map(entry->entry.getKey()+" "+entry.getValue())
                .forEach(System.out::println);

        //M 7.3 People
        People.getList().stream()
                .map(String::toUpperCase)
                .filter(s->s.length()>11)
                .map(s->s.substring(0,s.indexOf(' ')+2)+" . ")
                .filter(s->s.substring(0,1).equals("M"))
                .forEach(System.out::println);



        //M 7.3 Book
        BookDirectory bookDirectory = new BookDirectory();
        String bookStr = bookDirectory.getList().stream()
                .filter(book -> book.getYearOfPubblication()>2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));
        System.out.println(bookStr);
    }
}





