/**
 * 
 */
package bubbleSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class BubbleSortM {

	private void bubbleSort(int[] list) {
		int temp = 0;
		boolean flag = false;
//		从第一个到倒数第二个确定了，那么最后一个一定是最大的值
		for(int i=0;i<list.length-1;i++) {
//			每一轮都要重新赋值，来判断这一轮循环是否有交换
			flag = false;
//			从后面往前推小的值
			for(int j=list.length-1;j>i;j--) {
				if(list[j]<list[j-1]) {
					temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
					flag = true;
				}	
			}
//			如果某一轮没有交换发生，则说明是有序的，不用排序
			if(!flag) {
				break;
			}
			System.out.format("第%d趟：\t",i+1);
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
//		生成一个长度为10的随机数组
		int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for(int i=0;i<10;i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		BubbleSortM bubbleSortM = new BubbleSortM();
		System.out.print("排序前：\t");
		bubbleSortM.printAll(array);
		
		bubbleSortM.bubbleSort(array);
		
		System.out.print("排序后：\t");
		bubbleSortM.printAll(array);
	}
}
