package sorts;

import static org.junit.Assert.*;

import org.junit.Test;

public class SortsTest {

	@Test
	public void mergeTest() {
		Integer[] arr = { 1, 2, 6, 8, 3, 9, 4, 7, 5, 0 };
		Integer[] sorted = Sorts.mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			assertEquals((int) sorted[i], i);
		}
	}

}
