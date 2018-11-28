package com.bookshop.bazydanych.platform;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/platforms")
public class PlatformController {

    private PlatformService platformService;

    public PlatformController(PlatformService platformService) {
        this.platformService = platformService;
    }

    @GetMapping("/all")
    public List<Platform> getAll(){
        return platformService.getAllPlatforms();
    }

    @PostMapping("/add")
    public void addPlatform(@RequestBody Platform platform){
        platformService.addPlatform(platform);
    }

    @GetMapping("/{id}")
    public Platform getPlatform(@PathVariable Long id){
        return platformService.getPlatform(id);
    }
}
