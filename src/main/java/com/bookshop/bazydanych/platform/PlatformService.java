package com.bookshop.bazydanych.platform;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatformService {

    private PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public List<Platform> getAllPlatforms(){
        return platformRepository.findAll();
    }

    public void addPlatform(Platform platform){
        platformRepository.save(platform);
    }

    public Platform getPlatform(Long id){
        return platformRepository.findById(id).get();
    }
}
