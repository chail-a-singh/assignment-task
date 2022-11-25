package assignment.controller;
import assignment.entity.Item;
import assignment.global.constant.Constants;
import assignment.model.ItemRequest;
import assignment.model.ItemResponse;
import assignment.service.ItemService;
import assignment.global.validation.LevelOneValidation;
import assignment.global.validation.MainLevelValidation;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@Validated(MainLevelValidation.class)
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/add")
    public String  addItem(@Validated(MainLevelValidation.class) @RequestBody ItemRequest itemRequest){
        itemService.addItem(itemRequest);
        return Constants.PRODUCT_ADDED;
//        return "Product Added Successfully!";
    }

    @GetMapping("/all")
    public List<Item> getAllItem(){
        return itemService.getAllItem();
    }

    @GetMapping("/{id}")
    public ItemResponse getStock(@NotNull(message = "Please Enter Item Id",groups = LevelOneValidation.class)  @PathVariable("id") Long itemId){
        return itemService.getItem(itemId);
    }

    @DeleteMapping("/{id}")
    public String deleteItem(@NotNull(message = "Please Enter Item Id",groups = LevelOneValidation.class) @PathVariable("id") Long itemId){
        itemService.deleteItem(itemId);
        return Constants.PRODUCT_DELETED;
//        return "Item Deleted Successfully";
    }
}
