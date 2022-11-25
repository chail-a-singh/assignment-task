package assignment.service;

import assignment.entity.Item;
import assignment.model.ItemRequest;
import assignment.model.ItemResponse;
import assignment.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    public void addItem(ItemRequest itemRequest) {
        String status=null;
        Item item = Item.builder()
                .itemName(itemRequest.getItemName())
                .price(itemRequest.getPrice())
                .quantity(itemRequest.getQuantity())
                .build();
        item.setStatus("CREATED");
        itemRepository.save(item);
    }
    public List<Item> getAllItem() {
        List<Item> items = new ArrayList<>();
        itemRepository.findAll().forEach(item -> items.add(item));
        return items;
    }
    public void deleteItem(Long itemId) {
//        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Provided item is not available in db"));
        Optional<Item> item = itemRepository.findById(itemId);
        if (!item.isPresent()){
            throw new RuntimeException("Product is not available for given id");
        }
        itemRepository.delete(item.get());
    }
    public ItemResponse getItem(Long itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new RuntimeException("Product is not available for given id"));
        ItemResponse itemResponse = new ItemResponse();
        itemResponse.setItemId(item.getItemId());
        itemResponse.setItemName(item.getItemName());
        itemResponse.setPrice(item.getPrice());
        itemResponse.setQuantity(item.getQuantity());
        itemResponse.setStatus(item.getStatus());
        return itemResponse;
    }
}
