package com.billboard.model;

import java.util.List;

public interface BillboardDAO_interface {
	public void insert(BillboardVO billboardVO);
	public void update(BillboardVO billboardVO);
	public void delete(int bill_id);
	public BillboardVO findByPrimaryKey(int bill_id);
	public List<BillboardVO> getAll();
}
