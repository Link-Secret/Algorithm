/**
 * 
 */
package selectionSort;

import java.awt.print.Printable;
import java.util.Random;

/**
 * @author acer
 *
 */
public class SelectionSortM {

	private void selectionSort(int[] list) {
		 for(int i=0; i<list.length-1; i++) {
//			 保存最小值的索引，如果后面没有比其小的值，则自身和自身互换
			 int index = i;
			 
			 int temp = 0;
			 for(int j=i+1; j<list.length; j++) {
//				 后面的值中最小的索引给index
				 if(list[j] < list[index]) {
					 index = j;
				 }
			 }
			 temp = list[index];
			 list[index] = list[i];
			 list[i] = temp;
			 System.out.format("第%d趟:\t",i+1);
			 printPart(list);
		 }
	}
	private void printPart(int[] list) {
		for(int value:list) {
			System.out.print(value+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for(int i = 0; i<MAX_SIZE; i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		
		SelectionSortM m = new SelectionSortM();
		
		System.out.print("排序前：\t");
		m.printPart(array);
		
		m.selectionSort(array);
		
		System.out.print("排序后：\t");
		m.printPart(array);
	}
}
