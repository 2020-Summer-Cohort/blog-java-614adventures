package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class HashtagStorage {
    HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo){
        this.hashtagRepo=hashtagRepo;
    }

    public Hashtag getHashtagByName(String name) {
        return hashtagRepo.findByHashtag(name);
    }

    public Hashtag findByID(long id) {
        return hashtagRepo.findById(id).get();
    }

}
