package blog.storage;

import blog.exception.PostNotFoundException;
import blog.model.Post;
import blog.util.FileUtil;

import java.util.List;

public class PostStorageImpl implements PostStorage {

    private List<Post> posts;

    public PostStorageImpl(){
        posts=FileUtil.deserializePostList();
    }

    @Override
    public void add(Post post) {
        posts.add(post);
        FileUtil.serializePostList(posts);
    }

    @Override
    public Post getPostByTitle(String title) throws PostNotFoundException {
        for (Post post : posts) {
            if (post.getTitle().equals(title)) {
                return post;
            }
        }
        throw new PostNotFoundException("Title with " + title + " does not exists");
    }

    @Override
    public void searchPostsByKeyword(String keyword) {
        for (Post post : posts) {
            if (post.getTitle().contains(keyword) || post.getText().contains(keyword)) {
                System.out.println(post);
            }
        }
    }

    @Override
    public void printAllPosts() {
        System.out.println(posts);
    }

    @Override
    public void printPostsByCategory(String category) {
        for (Post post : posts) {
            if (post.getCategory().equals(category)) {
                System.out.println(post);
            }
        }
    }
}
