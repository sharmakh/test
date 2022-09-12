package model;

import constants.CategoryType;
import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
public class Category {

    private String id;

    private String name;

    private CategoryType categoryType;

    public int hashCode(){
        return this.id.hashCode();
    }
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        Category category = (Category)obj;
        if(Objects.equals(category.getCategoryType(),this.getCategoryType())
                && Objects.equals(category.getName(),this.getName())){
            return true;
        }
        return false;
    }

}
