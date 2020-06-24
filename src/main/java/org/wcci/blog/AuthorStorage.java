//package org.wcci.blog;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthorStorage {
//    AuthorRepository authorRepo;
//
//    public AuthorStorage(AuthorRepository authorRepo){
//        this.authorRepo=authorRepo;
//    }
//
//    public Author getAuthorByName(String name){
//        return authorRepo.findByAuthor(name);
//    }
//
//    public Author findByID(long id){
//        return authorRepo.findById(id).get();
//    }
//}
