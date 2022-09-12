package facade.impl;

import dao.InventoryManagementDao;
import dao.impl.InventoryManagementDaoImpl;
import facade.InventoryManagementFacade;
import model.Item;

public class InventoryManagementFacadeImpl implements InventoryManagementFacade {
    private InventoryManagementDao inventoryManagementDao = null;
    public InventoryManagementFacadeImpl(){
        inventoryManagementDao = InventoryManagementDaoImpl.getInstance();
    }
    @Override
    public void addItem(Item item) {
        inventoryManagementDao.addItem(item);
    }

    @Override
    public void modifyItem(Item item) {
        inventoryManagementDao.modifyItem(item);
    }

    @Override
    public void deleteItem(String itemId) {
         inventoryManagementDao.deleteItem(itemId);
    }

    @Override
    public void setWeightage(String brand,String keyword) {
        inventoryManagementDao.setWeightage(brand,keyword);
    }
}
