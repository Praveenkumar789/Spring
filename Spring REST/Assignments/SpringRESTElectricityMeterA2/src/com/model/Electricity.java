package com.model;


public class Electricity {
	
	private int billId;
	private String customerName;
	private int monthlyConsumedUnits;
	private int costPerUnit;
	private int billAmount;
	private String lastDate;


	public Electricity (int billId, String customerName, int monthlyConsumedUnits,
			int costPerUnit, String lastDate)
	{
		this.billId = billId;
		this.customerName = customerName;
		this.monthlyConsumedUnits = monthlyConsumedUnits;
		this.costPerUnit = costPerUnit;
		this.lastDate = lastDate;
	}
	public int getBillId() {
		return billId;
	}
	
	public void setBillId(int id) {
		this.billId = id;
	}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String name) {
		this.customerName = name;
	}
	public int getMonthlyConsumedUnits() {
		return monthlyConsumedUnits;
	}
	public void setMonthlyConsumedUnits(int monthlyConsumedUnits) {
		this.monthlyConsumedUnits = monthlyConsumedUnits;
	}
	public int getCostPerUnit() {
		return costPerUnit;
	}
	public void setCostPerUnit(int costPerUnit) {
		this.costPerUnit = costPerUnit;
	}

	public int getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}
	
	public String getLastDate() {
		return lastDate;
	}
	public void setTotal_Sal(String lastDate) {
		this.lastDate = lastDate;
	}
	
	
	
	public String toString() {
		String details = " billId : "+this.getBillId()+
				          "\n customerName : " +this.getCustomerName()+
				          "\n monthlyConsumedUnits : "+this.getMonthlyConsumedUnits()+
				          "\n costPerUnit : "+this.getCostPerUnit()+
				          "\n billAmount : "+this.getBillAmount()+
				          "\n lastDate :"+this.getLastDate();
		return details;
	}

}
