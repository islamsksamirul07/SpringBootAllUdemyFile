package com.example.demo.business.mockitoListTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.example.demo.business.SomeBusinessImpl;
//import com.example.demo.business.SomeBusinessImpl.DataService;

class ListTest {

	@Test
	void test() {
//		fail("Not yet implemented");
	}
	@Test
	void findGreatestFromZeroData() {
//		fail("Not yet implemented");
		
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(3);

		assertEquals(3,listMock.size());
		
	}
	
	
	@Test
	void multipleReturn() {
//		fail("Not yet implemented");
		
		List listMock=mock(List.class);
		when(listMock.size()).thenReturn(3).thenReturn(2);

		assertEquals(3,listMock.size());
		assertEquals(2,listMock.size());
		
	}
	
	@Test
	void parameter() {
//		fail("Not yet implemented");
		
		List listMock=mock(List.class);
		when(listMock.get(0)).thenReturn("We transfer the String");

		assertEquals("We transfer the String",listMock.get(0));
		assertEquals(null,listMock.get(1));
		
	}

}
