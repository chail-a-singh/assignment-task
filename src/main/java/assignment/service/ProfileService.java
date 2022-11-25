package assignment.service;

import assignment.entity.Profile;
import assignment.global.constant.Constants;
import assignment.model.ProfileRequest;
import assignment.model.ProfileResponse;
import assignment.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class  ProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    public String saveImage(ProfileRequest profileDTO) {
        Profile profile = new Profile();
        try {
            MultipartFile file = profileDTO.getProfileName();
            if (file != null && file.getSize() > 0){
                profile.setProfileName(file.getOriginalFilename());
            }
        }catch (Exception exception){
            throw new RuntimeException("Error While Saving Profile");
        }
        profileRepository.save(profile);
        return Constants.IMAGE_SAVED;
//        return "File saved successfully";
    }
    public ProfileResponse getProfile(Long profileId) {
        Profile profile=profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile id not available"));
        ProfileResponse profileResponse = new ProfileResponse();
        profileResponse.setProfileId(profile.getProfileId());
        profileResponse.setProfileName(profile.getProfileName());
//        profileResponse.setProfileType(profile.getProfileType());
        return profileResponse;
    }
}
