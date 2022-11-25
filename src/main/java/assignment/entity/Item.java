package assignment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "item_table")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long ItemId;
    @Column(name = "item_name",nullable = false)
    private String itemName;
    @Column(name = "item_price",nullable = false)
    private long price;
    @Column(name = "quantity",nullable = false)
    private long quantity;
    @Column(name = "status")
    private String status;

}
