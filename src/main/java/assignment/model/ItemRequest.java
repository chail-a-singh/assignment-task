package assignment.model;
import assignment.global.validation.LevelOneValidation;
import assignment.global.validation.LevelTwoValidation;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ItemRequest {

    @NotBlank(message = "item name is mandatory",groups = LevelOneValidation.class)
    @Pattern(regexp = "^[a-zA-Z]*$",message = "Only Alphabet character allowed",groups = LevelTwoValidation.class )
    private String itemName;
    @NotNull(message = "Price Can't be empty",groups = LevelOneValidation.class)
    private long price;
    @NotNull(message = "enter number of item",groups = LevelOneValidation.class)
    private long quantity;
}
