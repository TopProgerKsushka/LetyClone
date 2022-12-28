package com.example.springapp.letyclone.repository;

import com.example.springapp.letyclone.model.Item;
import com.example.springapp.letyclone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findAllByUserAndCanBeRefundedAndRefunded(User user, boolean canBeRefunded, boolean refunded);
    List<Item> findAllByUserIdAndShopIdAndShopOrderedItemId(int userId, int shopId, int shopOrderedItem);
}
