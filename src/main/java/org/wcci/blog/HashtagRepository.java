package org.wcci.blog;

import org.springframework.data.repository.CrudRepository;

public interface HashtagRepository extends CrudRepository<Hashtag, Long> {
    Hashtag findByName(String name);

}
