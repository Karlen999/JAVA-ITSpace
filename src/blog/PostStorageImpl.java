package blog;

import blog.exception.CategoryNotFoundException;
import blog.exception.KeywordNotFoundException;
import blog.exception.PostNotFoundException;
import blog.model.Post;

public class PostStorageImpl implements PostStorage {

    private Post[] posts = new Post[10];
    int size = 0;


    @Override
    public void add(Post post) {
        if (size == posts.length) {
            extend();
        }
        posts[size++] = post;
    }

    private void extend() {
        Post[] newPost = new Post[posts.length + 10];
        System.arraycopy(posts, 0, newPost, 0, posts.length);
        posts = newPost;
    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().equals(title)) {
                return posts[i];
            }
        }
        throw new PostNotFoundException("Title with " + title + " does not exists");
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getTitle().contains(keyword) || posts[i].getText().contains(keyword)) {
                System.out.println(posts[i]);
            }
        }
    }

    @Override
    public void printAllPosts() {
        for (int i = 0; i < size; i++) {
            System.out.println(posts[i]);
        }
    }

    @Override
    public void printPostsByCategory(String category) {
        for (int i = 0; i < size; i++) {
            if (posts[i].getCategory().contains(category)) {
                System.out.println(posts[i]);
            }
        }
    }
}
