package facade;

import model.Item;

import java.util.List;

public interface InventorySearchFacade {
    List<Item> search(String keyword);
}
