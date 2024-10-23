package com.ppk.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Item {
	private String type;
	private String name;

	public Item(String type, String name) {
		this.type = type;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}
}

public class GroupByTypeFormatter {


	public void process(List<Item> itemList) {
		Map<String, List<String>> mappedItems = new HashMap<>();

		for (Item item : itemList) {
			mappedItems.putIfAbsent(item.getType(), new ArrayList<>());
			mappedItems.get(item.getType()).add(item.getName());
		}

		List<String> sortedTypes = new ArrayList<>(mappedItems.keySet());
		Collections.sort(sortedTypes);

		for (String type : mappedItems.keySet()) {
			Collections.sort(mappedItems.get(type));
		}
		for (String type : sortedTypes) {
			System.out.println("-Type=" + type);
			for (String name : mappedItems.get(type)) {
				System.out.println("\t-Name=" + name);
			}
		}
	}
	
    public static void main(String[] args) {
        // Input list of items (Type, Name)
        List<Item> items = new ArrayList<>(Arrays.asList(
                new Item("Fruit", "Orange"),
                new Item("Fruit", "Apple"),
                new Item("Fruit", "Banana"),
                new Item("Animal", "Tiger"),
                new Item("Animal", "Dog"),
                new Item("Vehicle", "Car"),
                new Item("Vehicle", "Boat"),
                new Item("Vehicle", "Plane")
        ));

        // Instantiate the GroupAndSortItems class and call process method
        GroupByTypeFormatter formatter = new GroupByTypeFormatter();
        formatter.process(items);
    }
    
}
