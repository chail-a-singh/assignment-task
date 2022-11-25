package assignment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
public class ProfileRequest {

    private MultipartFile profileName;
//    private String profileType;;
}
