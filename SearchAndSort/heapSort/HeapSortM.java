/**
 * 
 */
package heapSort;

import java.util.Random;

/**
 * @author acer
 *
 */
public class HeapSortM {

	private void heapAdjust(int[] list,int parent,int length) {
		int temp = list[parent];
		int child = parent*2 + 1;
		while(child < length) {
			if(child+1 < length && list[child] < list[child+1]) {
				child ++;
			}
			
//			如果父亲节点大于子节点的值(此时，子节点的值是比较大的那一个)，则退出
			if(temp >= list[child]) {
				break;
			}
//		        否则
			list[parent] = list[child];
			
//			继续向下筛选
			parent = child;
			child = child*2 + 1;
		}
		list[parent] = temp;
	}
	private void heapSort(int[] list) {
//		循环建立初始化堆
//		从倒数第二层开始(因为有child元素)
		for(int i = list.length/2; i>=0; i--) {
			heapAdjust(list, i, list.length);
		}
//		进行n-1次排序，得到结果
		for(int i=list.length-1;i>0;i--) {
//			最后一个元素和第一个元素交换
			int temp = list[i];
			list[i] = list[0];
			list[0] = temp;
			
//			重新排列除了已经排列的最后一个，每一轮都把最后一个剔除
			heapAdjust(list, 0, i);
			System.out.format("第%d趟：\t",list.length - i);
			printPart(list, 0, i);
		}
	}
	private void printPart(int[] list,int begin,int end) {
		for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
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
		
		HeapSortM heapSortM = new HeapSortM();
		
		System.out.print("排序前:\t");
		heapSortM.printPart(array, 0, array.length-1);
		
		heapSortM.heapSort(array);
		
		System.out.print("排序后：\t");
		heapSortM.printPart(array, 0, array.length-1);
		
	}
}
