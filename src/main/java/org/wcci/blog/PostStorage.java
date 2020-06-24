package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class PostStorage {
    PostRepository postRepo;

    public PostStorage(PostRepository postRepo){
        this.postRepo=postRepo;
    }

    public Post findPostByName(String name){
        return postRepo.findByPost(name);
    }

    public Post findByID(long id){
        return postRepo.findById(id).get();
    }
}
