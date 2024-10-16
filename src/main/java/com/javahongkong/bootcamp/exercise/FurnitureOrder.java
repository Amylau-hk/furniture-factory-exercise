package com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Set;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
        ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        this.ordersOfFurnitures.put(type, furnitureCount);

    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalCost = 0;
        Set<Furniture> keyList = ordersOfFurnitures.keySet();
        for(Furniture furniture : keyList){
            totalCost += this.getTypeCost(furniture);
 
        }
        // totalCost = this.getTotalOrderQuantity() * this.getTypeCount();
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        return this.ordersOfFurnitures.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        return type.cost() * this.getTypeCount(type);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        int total = 0;
        total = this.ordersOfFurnitures.values()
            .stream().mapToInt(Integer::intValue)
            .sum();
        return total;
    }
}