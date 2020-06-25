package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class PostStorage {
    PostRepository postRepo;

    public PostStorage(PostRepository postRepo){
        this.postRepo=postRepo;
    }

    public Post findPostByTitle(String title){
        return postRepo.findByTitle(title);
    }

    public Post findByID(long id){
        return postRepo.findById(id).get();
    }

    public void addPost(Post post) {
        postRepo.save(post);
    }
}
