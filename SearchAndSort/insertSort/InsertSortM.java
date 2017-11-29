/**
 * 
 */
package insertSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class InsertSortM {

	private void insertSort(int[] list) {
//		打印第一个元素
		System.out.format("i=%d\t",1);
		printPart(list,0,0);
//		第一个元素不需要排序，只有一个
		int j = 0;  //j在这初始化，是为了作用域
		for(int i=1;i<list.length;i++) {
//			temp从索引为1开始来插入
			int temp = list[i];
//			从已有的i个数的最后一个开始判断，如果小于，则继续向前判断，如果大于或者j<0则跳出循环
			for(j=i-1; j>=0 && list[j]>temp; j--) {
//				如果符合条件，将需要插入的地方后面的数据往后移动一个位置
				list[j+1] = list[j];
			}
//			移动后空出来的地方就可以放新增的数据了
			list[j+1] = temp;
			System.out.format("第%d个：\t",i+1);
			printPart(list, 0, i);
		}
	}
	private void printPart(int[] list,int begin,int end) {
		for(int i=0;i<begin;i++) {
			System.out.print("\t");
		}
		for(int i=begin;i<=end;i++) {
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		InsertSortM insertSortM = new InsertSortM();
		int MAX_SIZE = 10;
		Random random = new Random();
		int[] array = new int[MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		
		System.out.print("排序前：\t");
		insertSortM.printPart(array, 0, array.length-1);
		
		insertSortM.insertSort(array);
		
		System.out.print("排序后：\t");
		insertSortM.printPart(array, 0, array.length-1);
		
	}
}
