package assignment.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponse {

    private long ItemId;
    private String itemName;
    private long price;
    private long quantity;
    private String status;

}
