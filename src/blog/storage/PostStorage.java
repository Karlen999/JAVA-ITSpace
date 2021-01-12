package blog.storage;

import blog.exception.CategoryNotFoundException;
import blog.exception.KeywordNotFoundException;
import blog.exception.PostNotFoundException;
import blog.model.Post;

public interface PostStorage {

    void add(Post post);

    Post getPostByTitle(String title) throws PostNotFoundException;

    void searchPostsByKeyword(String keyword) throws KeywordNotFoundException;

    void printAllPosts();

    void printPostsByCategory(String category) throws CategoryNotFoundException;


}
