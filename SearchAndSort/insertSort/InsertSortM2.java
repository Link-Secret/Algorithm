/**
 * 
 */
package insertSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class InsertSortM2 {

	private void insertSort(int[] list) {
//		第一个元素不用排序
		System.out.format("i=%d:\t",1);
		printPart(list, 0, 0);
		
//		从第二个到最后一个开始插入排序
		for(int i=1;i<list.length;i++) {
//			比较大小
			int j = 0;
//			存放需要插入的数
			int temp = list[i];
//			j从需要排序的数的前一个开始往前比较
			for(j=i-1;j>=0 && list[j]>temp; j-- ) {
//				比temp大的元素往后移动一个位置
				list[j+1] = list[j];
			}
//			当j<0时，跳出循环 -- 所以第一个元素是temp,
//			当list[j]<temp跳出循环 -- 所以空出来的位置放temp（由于j最后--了，所以j+1)
			list[j+1] = temp;
			System.out.format("i=%d:\t",i+1);
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
		Random random = new Random();
		int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		for(int i=0;i<MAX_SIZE;i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		InsertSortM2 insertSortM2 = new InsertSortM2();
		System.out.print("插入前：\t");
		insertSortM2.printPart(array, 0, array.length-1);
		
		insertSortM2.insertSort(array);
		
		System.out.print("插入后：\t");
		insertSortM2.printPart(array, 0, array.length-1);
		
	}
}
