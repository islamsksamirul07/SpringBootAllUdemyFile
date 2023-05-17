package com.example.demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.demo.business.SomeBusinessImpl.DataService;

//etir dara amra mock and InjectMocks ei duti annotation er jonno use kor6i eti sudhu necher method findGreatestFromthreeData re jioon
@ExtendWith(MockitoExtension.class)
class SomeBusinessImplTestMocks {

	@Test
	void findGreatestFromAllData() {
//		fail("Not yet implemented");
		DataService dataServiceMock=mock(DataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn( new int [] {85,1,5,90,0});
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl(dataServiceMock);
		assertEquals(90,someBusinessImpl.findTheGreatestFromAllDta());
		
	}
	
	
	@Test
	void findGreatestFromZeroData() {
//		fail("Not yet implemented");
		DataService dataServiceMock=mock(DataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn( new int [] {});
		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl(dataServiceMock);
		assertEquals(Integer.MIN_VALUE,someBusinessImpl.findTheGreatestFromAllDta());
		
		System.out.println(Integer.MIN_VALUE);
		
	}
	
	
//	mock and InjectMocks ei duti annotation 6arao amra korte pari uporer process onujayi
	@Mock
	private DataService dataServiceMock;
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;
	@Test
	void findGreatestFromThreeData() {
//		fail("Not yet implemented");
//		DataService dataServiceMock=mock(DataService.class);
		when(dataServiceMock.retriveAllData()).thenReturn( new int [] {85,111,5});
//		SomeBusinessImpl someBusinessImpl=new SomeBusinessImpl(dataServiceMock);
		assertEquals(111,someBusinessImpl.findTheGreatestFromAllDta());
		
	}

}
