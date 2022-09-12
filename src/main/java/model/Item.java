package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Item {

    private String id;

    private String title;

    private String description;

    private Category category;

    private int weightage;

    private String brand;

    public int hashCode(){
        return this.id.hashCode();
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        Item item = (Item)obj;
        if(Objects.equals(item.getTitle(),this.getTitle()) && Objects.equals(item.getDescription(),this.getDescription())
            && Objects.equals(item.getCategory(),this.getCategory())){
            return true;
        }
        return false;
    }
}
