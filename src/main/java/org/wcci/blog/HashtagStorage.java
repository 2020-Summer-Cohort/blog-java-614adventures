package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class HashtagStorage {
    HashtagRepository hashtagRepo;

    public HashtagStorage(HashtagRepository hashtagRepo) {
        this.hashtagRepo = hashtagRepo;
    }

    public Hashtag findHashtagByName(String name) {
        return hashtagRepo.findByName(name);
    }

    public Iterable<Hashtag> getAllHashtags() {
        return hashtagRepo.findAll();
    }

    public void addHashtags(Hashtag hashtagToAdd) {
        hashtagRepo.save(hashtagToAdd);
    }

    public Hashtag findByID(long id) {
        return hashtagRepo.findById(id).get();
    }

}
