package com.nttdata.inventory.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Schema(name = "Item")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

	@Schema(required = true, description = "Description of item's id")
	private String id;

	@Schema(required = true, description = "Description of item's name")
	private String name;

	@Schema(required = true, description = "Description of item's quantity")
	private long quantity;

	@Schema(required = true, description = "Description of item's price")
	private long price;

}
