package codegym.controller;

import codegym.entity.Song;
import codegym.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;


@Controller
@RequestMapping("/song")
@Transactional

public class SongController {
    @Autowired
    SongRepository songRepository;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("songs", songRepository.getList());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("song", new Song());
        return "create";
    }

    @PostMapping("/save")
    public String save(Song song) {
        song.setId(songRepository.getList().size() + 1);
        System.out.println(song.getId());
        System.out.println(song.getLink());
        System.out.println(song.getName());
        System.out.println(song.getSinger());
        System.out.println(song.getType());
        System.out.println(song.getId());
        songRepository.createSong(song);
        return "list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("song", songRepository.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Song song) {
        songRepository.updateSong(song);
        return "redirect:/song";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("song", songRepository.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String remove(Song song, RedirectAttributes redirect) {
        songRepository.deleteSong(song.getId());
        return "redirect:/song";
    }
    @GetMapping("/{id}/view")
    public  String view(@PathVariable int id,Model model){
        model.addAttribute("song",songRepository.findById(id));
        return "/view";
    }
}
