package org.launchcode.marketplacemetrics.data;

import org.launchcode.marketplacemetrics.models.CashFlow;
import org.launchcode.marketplacemetrics.models.Inventory;
import org.launchcode.marketplacemetrics.models.InventoryCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

    @Query("SELECT i FROM Inventory i WHERE i.category = :category")
    List<Inventory> findByCategory (@Param("category") InventoryCategory category);

    @Query(value = "select (sold.total - bought.total) as cashFlow, bought.total as totalBought, sold.total as totalSold from (" +
            "select SUM(i.price) as total, 1 as id from Inventory i group by i.category having i.category = 0) bought inner join " +
            "(select SUM(i.price) as total, 1 as id from Inventory i group by i.category having i.category = 1) sold on bought.id = sold.id", nativeQuery = true)
    List<Object[]> getCashFlow();



}
