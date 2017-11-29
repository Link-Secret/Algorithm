/**
 * 
 */
package bubbleSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class BubbleSortM2 {

	private void bubbleSort(int[] list) {
	   int temp = 0; 
	   boolean flag = false;
//	   从第二个到最后一个确定了顺序，那么第一个一定是最小的一个
	   for(int i=1;i<list.length;i++) {
		   flag = false;
		   for(int j=0;j<list.length-i;j++) {
			   if(list[j]>list[j+1]) {
				   temp = list[j+1];
				   list[j+1] = list[j];
				   list[j] = temp;
				   flag = true;
			   }
		   }
		   if(!flag) {
			   break;
		   }
		   System.out.format("第%d轮:\t",i);
		   printAll(list);
	   }
	}
	
	private void printAll(int[] list) {
		for(int value : list) {
			System.out.print(value+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for(int i=0;i<MAX_SIZE;i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		BubbleSortM2 bubbleSortM2 = new BubbleSortM2();
		
		System.out.print("排序前：\t");
		bubbleSortM2.printAll(array);
		
		bubbleSortM2.bubbleSort(array);
		
		System.out.print("排序后：\t");
		bubbleSortM2.printAll(array);
	}
}
