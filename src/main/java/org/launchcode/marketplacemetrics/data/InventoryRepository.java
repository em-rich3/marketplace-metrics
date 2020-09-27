package org.launchcode.marketplacemetrics.data;

import org.launchcode.marketplacemetrics.models.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

}
