package dao;

import model.Item;

import java.util.List;

public interface InventoryManagementDao {
    void addItem(Item item);

    void modifyItem(Item item);

    void deleteItem(String itemId);

    List<Item> getAllItem();

    void setWeightage(String brand,String keyword);
}
