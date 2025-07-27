package forum.dao;

import forum.model.Post;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class ForumImpl implements Forum{

    private Post[] posts;
    private int size;

    public ForumImpl( int capacity) {
        posts = new Post[capacity];
    }


    @Override
    public boolean addPost(Post post) {
        if(post == null || getPostById(post.getPostId()) != null || size == posts.length)
            return false;
        int index = Arrays.binarySearch(posts, 0, size, post);
        if(index < 0) index = -index -1;
        System.arraycopy(posts, index, posts, index + 1, size - index);
        posts[index] = post;
        size++;
        return true;
    }

    @Override
    public Post removePost(int postId) {
        int index;
        Post victim = null;

        for (int i = 0; i < size; i++) {
            if(posts[i].getPostId() == postId) {
                victim = posts[i];
                System.arraycopy(posts,i + 1,posts,i, size - i - 1);
                posts[--size] = null;
                return victim;
            }
        }
        return null;
    }

    @Override
    public boolean updatePost(int postId, String content) {
        if(getPostById(postId) == null) return false;
        getPostById(postId).setContent(content);
        return true;
    }

    @Override
    public Post getPostById(int postId) {
        for (int i = 0; i < size; i++) {
            if(posts[i].getPostId() == postId) {
                return posts[i];
            }
        }
        return null;
    }

    @Override
    public Post[] getPostByAuthor(String author) {

        Post pattern = new Post(0,null,author,null);

        int from = Arrays.binarySearch(posts, 0, size , pattern);
        while(from >=0) {
            from = Arrays.binarySearch(posts, 0, from, pattern);
        }
        from = -from -1;

        int to = Arrays.binarySearch(posts, from, size , pattern);
        while (to >= 0) {
            to = Arrays.binarySearch(posts, to + 1, size, pattern);
        }
        to = -to - 1;

        return Arrays.copyOfRange(posts,from,to);
    }

    //Стандартный вариант отбора элементов путем перебора массива без пересортировки.
    @Override
    public Post[] getPostByAuthor(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post[] postsByAuthor = getPostByAuthor(author);
        Post[] res = new Post[postsByAuthor.length];
        int j = 0;
        for (int i = 0; i < postsByAuthor.length; i++) {
            if(postsByAuthor[i].getDate().isAfter(dateFrom.atStartOfDay()) &&
            postsByAuthor[i].getDate().isBefore(LocalDateTime.of(dateTo,LocalTime.MAX))) {
                res[j++] = postsByAuthor[i];
            }
        }
        return Arrays.copyOfRange(res, 0, j);
    }

    //Вариант с использованием binarySearch. Искать должен быстро, но требуется пересортировка массива, что затратно само по себе.
    // Думаю, что непригоден
    public Post[] getPostByAuthor1(String author, LocalDate dateFrom, LocalDate dateTo) {
        Post[] postsByAuthor = getPostByAuthor(author);
        Comparator<Post> comparator = Comparator.comparing(Post::getDate);
        Arrays.sort(postsByAuthor, comparator);

        Post pattern = new Post(0,null,null,null);
        pattern.setDate(dateFrom.atStartOfDay());

        int from = Arrays.binarySearch(postsByAuthor, pattern, comparator);
        while(from >=0) {
            from = Arrays.binarySearch(postsByAuthor, 0, from, pattern, comparator);
        }
        from = -from -1;

        pattern.setDate(LocalDateTime.of(dateTo, LocalTime.MAX));
        int to = Arrays.binarySearch(postsByAuthor, from, postsByAuthor.length , pattern, comparator);
        while (to >= 0) {
            to = Arrays.binarySearch(postsByAuthor, to + 1, postsByAuthor.length, pattern, comparator);
        }
        to = -to - 1;

        return Arrays.copyOfRange(postsByAuthor,from,to);
    }

    //Вариант поиском индексов начала и конца искомого интервала перебором.
    // Ценности не имеет, так как требует, как и в варианте с binarySearch, пересортировку массива, что затратно само по себе.
    // Еще и ищет медленно
    public Post[] getPostByAuthor2(String author, LocalDate dateFrom, LocalDate dateTo) {
       Post[] postsByAuthor = getPostByAuthor(author);

       Arrays.sort(postsByAuthor, Comparator.comparing(Post::getDate));

       int from, to, index = 0;

       while (index < postsByAuthor.length && postsByAuthor[index].getDate().isBefore(dateFrom.atStartOfDay())) {
          index++;
       }
       from = index;

       index = postsByAuthor.length - 1;
        while (index >= 0 && postsByAuthor[index].getDate().isAfter(LocalDateTime.of(dateTo, LocalTime.MAX))) {
           index--;
        }
        to = index;
        return Arrays.copyOfRange(postsByAuthor, from, to + 1);
    }



    @Override
    public int size() {
        return size;
    }


//    private Post[] getPostByPredicate(Predicate<Post> predicate) {
//        Post[] res = new Post[size];
//        int j = 0;
//        for (int i = 0; i < size; i++) {
//            if(predicate.test(posts[i])) {
//                res[j++] = posts[i];
//            }
//        }
//        return Arrays.copyOfRange(res, 0, j);
//    }
}
