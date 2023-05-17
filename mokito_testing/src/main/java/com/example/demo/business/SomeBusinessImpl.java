package com.example.demo.business;

public class SomeBusinessImpl {
	
	public SomeBusinessImpl(DataService dataService) {
		super();
		this.dataService=dataService;
	}
	
	private DataService dataService;
	public int findTheGreatestFromAllDta() {
		int[] data=dataService.retriveAllData();
		int greatestValue=Integer.MIN_VALUE;
		for(int value:data) {
			if(value>greatestValue)
				greatestValue=value;
		}
		return greatestValue;
		
	}




interface DataService{
	int[] retriveAllData();
}
}
