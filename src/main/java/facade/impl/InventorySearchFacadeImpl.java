package facade.impl;

import dao.InventoryManagementDao;
import dao.impl.InventoryManagementDaoImpl;
import facade.InventorySearchFacade;
import model.Item;

import java.util.ArrayList;
import java.util.List;

public class InventorySearchFacadeImpl implements InventorySearchFacade {
    private InventoryManagementDao inventoryManagementDao = null;
    public InventorySearchFacadeImpl(){
        inventoryManagementDao = InventoryManagementDaoImpl.getInstance();
    }
    @Override
    public List<Item> search(String keyword) {
        List<Item>items = inventoryManagementDao.getAllItem();
        List<Item>resultItems = new ArrayList<>();
        if(items == null || items.isEmpty()){
            return resultItems;
        }
        items.forEach(itm ->{
            if(itm.getDescription().contains(keyword) || itm.getCategory().getName().contains(keyword)
                ||itm.getTitle().contains(keyword)){
                resultItems.add(itm);
            }
        });
            return resultItems;
    }
}
