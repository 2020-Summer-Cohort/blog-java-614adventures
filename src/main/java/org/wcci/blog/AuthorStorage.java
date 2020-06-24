package org.wcci.blog;

import org.springframework.stereotype.Service;

@Service
public class AuthorStorage {
    AuthorRepository authorRepo;

    public AuthorStorage(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }

    public Author findAuthorByName(String name) {
        return authorRepo.findByName(name);
    }

    public Iterable<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public void addAuthors(Author authorToAdd) {
        authorRepo.save(authorToAdd);
    }

    public Author findByID(long id) {
        return authorRepo.findById(id).get();
    }
}
