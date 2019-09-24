package com.revature.project2.dao;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

public interface ItemDao {
	public List<Item> getItemById(int id);
}
