package models;

import javafx.geometry.Pos;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PostTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        Post.clearAllPosts();
    }

    @Test
    public void AllPostsAreCorrectlyReturned_true() {
        Post post = setNewPost();
        Post otherPost = setNewOtherPost();
        assertEquals(2, Post.getAll().size());
    }

    @Test
    public void AllPostsCOntainsAllPosts_tru() {
        Post post = setNewPost();
        Post otherPost = setNewOtherPost();
        assertTrue(Post.getAll().contains(post));
        assertTrue(Post.getAll().contains(otherPost));
    }

    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Post post = setNewPost();
        assertEquals(true, post instanceof Post);
    }

    @Test
    public void PostInstantiatesWithContent_true() throws Exception {
        Post post = setNewPost();
        assertEquals("Day 1: Intro", post.getContent());
    }

    @Test
    public void getPublished_isFalseAfterInstantition_false() throws Exception {
        Post post = setNewPost();
        assertEquals(false, post.getPublished());
    }

    @Test
    public void getCreatedAt_intantiatesWithCurrentTime_today() throws Exception {
        Post post = setNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(), post.getCreatedAt().getDayOfWeek());
    }

    @Test
    public void getId_postsInstantiateWithAnID_1() throws Exception {
        Post.clearAllPosts();
        Post post = setNewPost();
        assertEquals(1, post.getId());
    }

    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = setNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }

    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = setNewPost();
        Post otherpost = setNewOtherPost();
        assertEquals(2, Post.findById(otherpost.getId()).getId());
    }

    public static Post setNewPost() {
        return new Post("Day 1: Intro");
    }

    public static Post setNewOtherPost() {
        return new Post("How to pair successfully");
    }
}