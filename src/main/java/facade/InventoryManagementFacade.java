package facade;

import model.Item;

public interface InventoryManagementFacade {

     void addItem(Item item);

     void modifyItem(Item item);

     void deleteItem(String itemId);

     void setWeightage(String brand,String keyword);

}
