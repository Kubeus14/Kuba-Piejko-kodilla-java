package com.kodilla.testing.forum;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ForumUser {
    private String name;
    private String realName;
    private int pesel;
    private List<ForumPost> posts = new ArrayList<>();
    private List<ForumComment> comments = new LinkedList<>();

    public ForumUser(String mrsmith, String john_smith) {
    }

    public boolean equals(Object o){
        ForumUser fu = (ForumUser) o;
        return (name.equals(fu.name))&&
                (realName.equals(fu.realName))&&
                (pesel== fu.pesel);
    }
//    public int hashCode(){
//      return Objects.hash(name,realName);
//    }

    @Override
    public int hashCode() {
        return Objects.hash(name, realName,pesel);
    }

    public ForumUser(String name, String realName,int pesel) {
        //name visible on forum
        this.name = name;
        //real name of the user
        this.realName = realName;
        this.pesel=pesel;
    }

    public void addPost(String author, String postBody) {
        ForumPost thePost = new ForumPost(postBody, author);
        posts.add(thePost);
    }

    public void addComment(ForumPost thePost, String author, String commentBody) {
        ForumComment theComment = new ForumComment(thePost, commentBody, author);
        comments.add(theComment);
    }

    public int getPostsQuantity() {
        return posts.size();
    }

    public int getCommentsQuantity() {
        return comments.size();
    }

    public ForumPost getPost(int postNumber) {
        if (postNumber >= 0 && postNumber < posts.size()) {
            return posts.get(postNumber);
        }
        return null;
    }

    public ForumComment getComment(int commentNumber) {
        ForumComment theComment = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComment = comments.get(commentNumber);
        }
        return theComment;
    }

    public boolean removePost(ForumPost thePost) {
        boolean result = false;
        if (posts.contains(thePost)) {
            posts.remove(thePost);
            result = true;
        }
        return result;
    }

    public boolean removeComment(ForumComment theComment) {
        boolean result = false;
        if (comments.contains(theComment)) {
            comments.remove(theComment);
            result = true;
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
