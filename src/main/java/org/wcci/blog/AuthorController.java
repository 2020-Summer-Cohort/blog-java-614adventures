package org.wcci.blog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {
    AuthorStorage authorStorage;

    public AuthorController(AuthorStorage authorStorage){
        this.authorStorage=authorStorage;
    }

    @GetMapping("authors/{author}")
    public String showSingleAuthor(@PathVariable String author, Model model) {
        model.addAttribute("author", authorStorage.findAuthorByName(author));
        model.addAttribute("authors", authorStorage.getAllAuthors());
        return "author-template";
    }


}
