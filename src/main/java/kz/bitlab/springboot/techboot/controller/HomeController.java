package kz.bitlab.springboot.techboot.controller;

import kz.bitlab.springboot.techboot.db.DBManager;
import kz.bitlab.springboot.techboot.db.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String indexPage(Model model) {
        ArrayList<Student> students = DBManager.getStudents();
        model.addAttribute("students", students);
        return "index";
    }

    @GetMapping(value = "/add-student")
    public String addStudent() {
        return "add-student";
    }

    //
    @PostMapping(value = "/add-student")
    public String addStudent(Student student) {
        DBManager.addStudent(student);
        return "redirect:/";
    }
//
//    @PostMapping(value = "/add-music-v2")
//    public String addMusicV2(
//            @RequestParam(name = "music-name") String name,
//            @RequestParam(name = "music-author") String author,
//            @RequestParam(name = "music-duration") int duration
//    ){
//        Music music = new Music();
//        music.setName(name);
//        music.setAuthor(author);
//        music.setDuration(duration);
//        DBManager.addMusic(music);
//        return "redirect:/";
//    }
//
//    @GetMapping(value = "/music-details")
//    public String getMusic(@RequestParam(name = "musicId") int id, Model model){
//        Music music = DBManager.getMusic(id);
//        model.addAttribute("muzyka",music);
//        return "details";
//    }
//
//    @GetMapping(value = "/details/{musicId}")
//    public String musicDetails(@PathVariable(name = "musicId") int id, Model model){
//        Music music = DBManager.getMusic(id);
//        model.addAttribute("muzyka",music);
//        return "details";
//    }
}
