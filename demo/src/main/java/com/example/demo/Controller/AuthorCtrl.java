package com.example.demo.Controller;

import com.example.demo.DAL.AuthorDB;
import com.example.demo.DAL.IFAuthorDB;
import com.example.demo.Model.Author;
import org.springframework.boot.autoconfigure.condition.ConditionalOnResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AuthorCtrl {

    private IFAuthorDB authorDB = new AuthorDB();

    @GetMapping("/Authors/{Id}")
    public @ResponseBody Author Authors(@PathVariable Integer Id, String firstName, String lastName){
        return authorDB.GetAuthor(new Author(Id, firstName, lastName));
    }

    @GetMapping("/Test")
    public  @ResponseBody String Test(){
        return "YES";
    }
}
