package com.epam.training.jdbc.entity;

public class ReceiptProducts {
	private long productId;
	private int count;

	public ReceiptProducts() {
		// nothing
	}

	public ReceiptProducts(long productId, int count) {
		this.productId = productId;
		this.count = count;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "ReceiptProducts [productId=" + productId + ", count=" + count + "]";
	}
	
}
