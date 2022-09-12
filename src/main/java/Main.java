import constants.CategoryType;
import facade.InventoryManagementFacade;
import facade.InventorySearchFacade;
import facade.impl.InventoryManagementFacadeImpl;
import facade.impl.InventorySearchFacadeImpl;
import model.Category;
import model.Item;

import java.util.UUID;


public class Main {
    public static void main(String[] args){
        InventorySearchFacade inventorySearchFacade = new InventorySearchFacadeImpl();
        InventoryManagementFacade inventoryManagementFacade = new InventoryManagementFacadeImpl();
        Item item1 = Item.builder().id(UUID.randomUUID().toString())
                .category(Category.builder().categoryType(CategoryType.ELECTRONICS).id("1").name("Mobile").build())
                .title("Redmi Note 8 (Neptune Blue, 4GB RAM, 64GB Storage)")
                .description("Redmi Note 8 (Neptune Blue, 4GB RAM, 64GB Storage)")
                .weightage(0)
                .brand("Redmi")
                .build();
        inventoryManagementFacade.addItem(item1);

        Item item2 = Item.builder().id(UUID.randomUUID().toString())
                .category(Category.builder().categoryType(CategoryType.ELECTRONICS).id("1").name("Mobile").build())
                .title("Sony Note 10 (Neptune Black, 8GB RAM, 64GB Storage)")
                .description("Sony Note 10 (Neptune Black, 8GB RAM, 64GB Storage)")
                .weightage(0)
                .brand("Sony")
                .build();
        inventoryManagementFacade.addItem(item2);

        item1.setTitle("Redmi Note 10 Pro");

        inventoryManagementFacade.modifyItem(item1);

        Item item3 = Item.builder().id(UUID.randomUUID().toString())
                .category(Category.builder().categoryType(CategoryType.APPARELS).id("2").name("Jeans").build())
                .title("Jeans Cotton")
                .description("Blue Jeans in cotton fabric")
                .weightage(0)
                .brand("pepe")
                .build();
        inventoryManagementFacade.addItem(item3);

        inventoryManagementFacade.deleteItem(item3.getId());

        inventoryManagementFacade.setWeightage("Sony","Note 10");

        inventorySearchFacade.search("Note 10");


    }
}
