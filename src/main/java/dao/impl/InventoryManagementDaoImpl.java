package dao.impl;

import dao.InventoryManagementDao;
import exception.ItemDoesNotExistException;
import exception.MissingParametersException;
import model.Item;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InventoryManagementDaoImpl implements InventoryManagementDao {
    public static InventoryManagementDaoImpl inventoryManagementDao = null;
    private List<Item> items;

    private InventoryManagementDaoImpl(){
        items = new ArrayList<>();
    }
    public static InventoryManagementDaoImpl getInstance(){
        if(inventoryManagementDao == null){
            inventoryManagementDao = new InventoryManagementDaoImpl();
        }
        return inventoryManagementDao;
    }

    public List<Item> getAllItem(){
        return items;
    }

    @Override
    public void setWeightage(String brand,String keyword) {
        items.forEach(itm ->{
            if(!StringUtils.isEmpty(brand) && brand.equals(itm.getBrand()) &&(itm.getDescription().contains(keyword) || itm.getCategory().getName().contains(keyword)
                    ||itm.getTitle().contains(keyword))){
                itm.setWeightage(itm.getWeightage()+1);
            }
        });
    }

    @Override
    public void addItem(Item item) {
        if(!validateItem(item)){
            throw new MissingParametersException("Parameters are missing in item");
        }
        items.add(item);
    }

    @Override
    public void modifyItem(Item item) {
          if(item == null || StringUtils.isBlank(item.getId())){
              throw new MissingParametersException("Item cannot be null");
          }
         Item exisitingItem  = getExistingItem(item.getId());
          if(exisitingItem == null){
              throw new ItemDoesNotExistException("item does not exist in inventory");
          }
          exisitingItem.setDescription(item.getDescription());
          exisitingItem.setTitle(item.getTitle());
          exisitingItem.setWeightage(item.getWeightage());
          exisitingItem.setCategory(item.getCategory());
    }

    @Override
    public void deleteItem(String itemId) {
        Item exisitingItem  = getExistingItem(itemId);
        if(exisitingItem == null){
            throw new ItemDoesNotExistException("item does not exist in inventory");
        }
        items.remove(exisitingItem);
    }
    private Item getExistingItem(String itemId){
        return items.stream().filter(itm -> itm.getId().equals(itemId)).findFirst().orElse(null);
    }
    private boolean validateItem(Item item){
        return item != null && item.getCategory() != null && !StringUtils.isBlank(item.getCategory().toString()) && !StringUtils.isBlank(item.getDescription()) &&
                !StringUtils.isBlank(item.getTitle());
    }
}
