package assignment.global.validation;

import assignment.global.validation.LevelOneValidation;
import assignment.global.validation.LevelTwoValidation;
import jakarta.validation.GroupSequence;

@GroupSequence(value = {LevelOneValidation.class, LevelTwoValidation.class})
public interface MainLevelValidation {
}
