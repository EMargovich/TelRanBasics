package forum.tests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import forum.dao.Forum;
import forum.dao.ForumImpl;
import forum.model.Post;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ForumTest {

    Forum forum;
    Post[] posts = new Post[6];
    LocalDateTime now = LocalDateTime.now();

    @BeforeEach
    void setUp() {
        forum = new ForumImpl(7);
        posts[0] = new Post(1, "title1", "author1",
                "content1" );
        posts[1] = new Post(2, "title2", "author2",
                "content2" );
        posts[2] = new Post(3, "title3", "author3",
                "content3" );
        posts[3] = new Post(4, "title4", "author3",
                "content4" );
        posts[4] = new Post(5, "title5", "author3",
                "content5" );
        posts[5] = new Post(6, "title6", "author1",
                "content6" );
        for (int i = 0; i < posts.length-1; i++) {
            forum.addPost(posts[i]);
        }
    }

    @Test
    void testAddPost() {
        assertTrue(forum.addPost(posts[5]));
        assertEquals(posts[5], forum.getPostById(6));
        assertFalse(forum.addPost(posts[5]));
        assertFalse(forum.addPost(null));
        assertEquals(6, forum.size());

        assertTrue(forum.addPost(new Post(7, "title6", "author1",
                "content6" )));
        assertFalse(forum.addPost(new Post(8, "title6", "author1",
                "content6" )));
    }

    @Test
    void testRemovePost() {
        assertEquals(posts[3],forum.removePost(4));
        assertNull(forum.removePost(7));
        assertNull(forum.removePost(4));
        assertEquals(4,forum.size());
    }

    @Test
    void testUpdatePost() {
        Post expected = new Post(2, "title2", "author2",
                "New content" );
        assertTrue(forum.updatePost(2,"New content"));
        assertEquals(expected,forum.getPostById(2));
    }

    @Test
    void testGetPostById() {
        assertEquals(posts[2], forum.getPostById(3));
        assertNull(forum.getPostById(8));
    }

    @Test
    void testGetPostByAuthor() {
        Post[] expected = {posts[2], posts[3], posts[4]};
        Post[] actual = forum.getPostByAuthor("author3");
        Arrays.sort(actual, (a , b) -> a.getPostId() - b.getPostId());
        assertArrayEquals(expected,actual);
        expected = forum.getPostByAuthor("author5");
        assertArrayEquals(new Post[0], expected );
    }

    @Test
    void testGetPostByAuthor2() {
        posts[2].setDate(now.minusDays(3));
        posts[3].setDate(now.minusDays(5));
        posts[4].setDate(now.minusDays(8));
        Post[] expected = {posts[3]};

        forum.getPostById(3).setDate(now.minusDays(3));
        forum.getPostById(4).setDate(now.minusDays(5));
        forum.getPostById(5).setDate(now.minusDays(8));
        Post[] actual = forum.getPostByAuthor("author3",now.toLocalDate().minusDays(7),now.toLocalDate().minusDays(4));
        Arrays.sort(actual, (a , b) -> a.getPostId() - b.getPostId());
        assertArrayEquals(expected,actual);
        expected = forum.getPostByAuthor("author3",now.toLocalDate().minusDays(50),now.toLocalDate().minusDays(55));
        assertArrayEquals(new Post[0], expected);
    }

    @Test
    void testSize() {
        assertEquals(5, forum.size());
    }
}