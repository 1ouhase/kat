package net.iouhase.kat.controller;

import net.iouhase.kat.usecase.CatService;
import org.springframework.web.bind.annotation.GetMapping;

public class CatController {
    private final CatService catService;

    public CatController(CatService catService) {
        this.catService = catService;
    }

    @GetMapping("/cat")
    public String cat() {
        return "cat";
    }
    @GetMapping("/editCat")
    public String editCat() {
        return "editCat";
    }
}
