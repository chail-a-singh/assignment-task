package assignment.controller;

import assignment.model.ProfileRequest;
import assignment.model.ProfileResponse;
import assignment.service.ProfileService;
import assignment.global.validation.MainLevelValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileService profileService;

    @PostMapping("/add")
    public String  saveImage(@Validated(MainLevelValidation.class) ProfileRequest profileDTO){
        return profileService.saveImage(profileDTO);
    }

    @GetMapping("/{id}")
    public ProfileResponse getProfile(@PathVariable("id") Long profileId){return profileService.getProfile(profileId);}
}
