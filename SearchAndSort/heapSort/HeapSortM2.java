/**
 * 
 */
package heapSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class HeapSortM2 {

	private void heapAdjust(int[] list,int parent,int length) {
//		此length是不包括已经排好序的数的length
		int temp = list[parent];
		int child = parent*2 + 1;
		while(child < length) {
//			先孩子之间比较，从而得到数值较大的那个孩子
			if(child +1 <length && list[child] < list[child+1]) {
				child ++;
			}
//			如果父亲值大于最大的那个孩子值
			if(temp > list[child]) {
				break;
			}
//			否则
//			交换值，并且向下继续
			list[parent] = list[child] ;
			parent = child ;
			child = child * 2 + 1;
		}
//		最后，将父亲的值赋给最后一轮的孩子
		list[parent] = temp;
	}
	private void heapSort(int[] list) {
//		初始化堆,从倒数第二层开始一直到0
//		之所以从list.length/2-1开始，是因为从倒数第二层第一个有子节点的那个开始
		for(int i= list.length/2-1;i>=0;i--) {
			heapAdjust(list, i, list.length);
		}
//		进行n-1次排序
		for(int i = list.length -1 ;i>0;i--) {
			
//			先将第一个元素和最后一个还未排序的元素(注意不是最后一个元素)
			int temp = list[0];
			list[0] = list[i];
			list[i] = temp;
			
//			剩余的元素继续排序
			heapAdjust(list, 0, i);
			System.out.format("第%d趟：\t",list.length-i);
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
		int MAX_SIZE = 10;
		int[] array = new int[MAX_SIZE];
		Random random = new Random();
		for(int i=0; i<MAX_SIZE; i++) {
			array[i] = random.nextInt(MAX_SIZE);
		}
		
		HeapSortM2 heapSortM = new HeapSortM2();
		
		System.out.print("排序前:\t");
		heapSortM.printPart(array, 0, array.length-1);
		
		heapSortM.heapSort(array);
		
		System.out.print("排序后：\t");
		heapSortM.printPart(array, 0, array.length-1);
	}
}
