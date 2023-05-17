package com.example.demo.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.demo.business.SomeBusinessImpl.DataService;

class SomeBussinessImplTest {

	@Test
	void findGreatestFromAllData() {
//		fail("Not yet implemented");
		DataServiceStub dataServiceStub=new DataServiceStub();
		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataServiceStub);
		int result=businessImpl.findTheGreatestFromAllDta();
		assertEquals(88,result);
		}
	
	
//	@Test
//	void findGreatestFromAllData() {
////		fail("Not yet implemented");
//		DataServiceStub dataServiceStub=new DataServiceStub();
//		SomeBusinessImpl businessImpl=new SomeBusinessImpl(dataServiceStub);
//		int result=businessImpl.findTheGreatestFromAllDta();
//		assertEquals(88,result);
//		}
	
	
	
	class DataServiceStub implements DataService{
		@Override
		public int[] retriveAllData() {
			return new int[] {23,4,88,2};
		}
	}

}
