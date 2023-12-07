package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {

    List<Theme> themes = new ArrayList<>();
    @PostMapping("theme") //curl -X POST localhost:8080/theme -H "Content-Type: text/plain" -d Weather
    public ResponseEntity<Void> newTheme(@RequestBody String s){
        themes.add(new Theme(s));
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("theme/{id}") //curl -X DELETE localhost:8080/theme/0
    public ResponseEntity<Void> deleteTheme(@PathVariable("id") Integer id){
        themes.remove((int) id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("theme/{id}") //curl -X PUT localhost:8080/theme/0 -H "Content-Type: text/plain" -d Sunset
    public ResponseEntity<Void> changeTheme(@PathVariable("id") Integer id, @RequestBody String s){
        themes.get(id).setName(s);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("theme") //curl localhost:8080/theme
    public ResponseEntity<List<String>> getThemes(){
        List<String> to_return = new ArrayList<>();
        for(Theme t : themes){
            to_return.add(t.getName());
        }
        return ResponseEntity.ok(to_return);
    }

    @GetMapping("theme/{id}") //curl localhost:8080/theme/0
    public ResponseEntity<String> getTheme(@PathVariable("id") Integer id){
        return ResponseEntity.ok(themes.get(id).getName());
    }

    @GetMapping("count") //curl localhost:8080/count
    public ResponseEntity<Integer> countThemes(){
        return ResponseEntity.ok(themes.size());
    }

    @PostMapping("theme/{id}/comment") //curl -X POST localhost:8080/theme/0/comment -H "Content-Type: text/plain" -d "Weather is good"
    public ResponseEntity<Void> newComment(@PathVariable("id") Integer id, @RequestBody String s){
        themes.get(id).newComment(s);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("theme/{id1}/comment/{id2}") //curl -X DELETE localhost:8080/theme/0/comment/0
    public ResponseEntity<Void> deleteComment(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2){
        themes.get(id1).deleteComment(id2);
        return  ResponseEntity.accepted().build();
    }

    @PutMapping("theme/{id1}/comment/{id2}") //curl -X PUT localhost:8080/theme/0/comment/0 -H "Content-Type: text/plain" -d "Weather is bad"
    public ResponseEntity<Void> changeComment(@PathVariable("id1") Integer id1, @PathVariable("id2") Integer id2, @RequestBody String s){
        themes.get(id1).changeComment(id2, s);
        return  ResponseEntity.accepted().build();
    }

    @GetMapping("theme/{id1}/comment") //curl localhost:8080/theme/0/comment
    public ResponseEntity<List<String>> getComments(@PathVariable("id1") Integer id){
        return ResponseEntity.ok(themes.get(id).getComments());
    }

}