package com.nttdata.inventory.service;

import com.nttdata.inventory.repository.entity.Item;
import jakarta.annotation.PostConstruct;
import jakarta.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Singleton
public class ItemService {

	private List<Item> items = new ArrayList<>();
	private Set<String> ids;


	@PostConstruct
	public void initItems() {
		items.add(new Item("1", "Kubernetes in action", 10, 650));
		items.add(new Item("2", "Amazon web services action", 5, 450));
		items.add(new Item("3", "Clean Architecture", 5, 500));
		items.add(new Item("4", "Mastering Machine Learning with scikit-learn", 2, 750));

		ids = items.stream()
			.map(Item::getId)
			.collect(Collectors.toSet());
	}

	public List<Item> getAllItem() {
		return items;
	}

	public Set<String> getAllItemIds() {
		return ids;
	}

	public String createItem(Item item) {
		ids.add(item.getId());
		items.add(item);
		return item.getId();
	}

	public String updateItem(String id, Item newItem) {
		Item existItem  = getItemById(id);

		if(existItem != null){
			newItem.setId(id);

			items.remove(existItem);

			items.add(newItem);

			return id;
		}

		return null;
	}

	public Item getItemById(String id) {
		if (ids.contains(id)) {
			return items.stream()
				.filter(item -> item.getId().equals(id))
				.findFirst()
				.orElse(null);
		}

		return null;
	}
}
