/**
 * 
 */
package quickSort;

/**
 * @author acer
 *
 */
public class QuickSortM2 {

	private int division(int[] list, int left, int right) {
//		以最左边的数据为基准值
		int base = list[left];
		while(left < right) {
//			从右边向左边扫描
			while(left < right && list[right] >= base ) {
				right --;
			}
//			当跳出循环时候,1.left=right 2.list[right]<base  ==>将小于base的值放到左侧
			list[left] = list[right];
//			从左边向右扫描
			while(left < right && list[left] <= base) {
				left ++ ;
			}
			list[right] = list[left];
			
		}
//		当left=right,跳出循环，此时可以得到基准值的索引值，以该索引值为界，左边小于base，右边大于base
		list[left] = base;
		return left;
	}
	
	private void quickSort(int[] list,int left,int right) {
		if(left <= right) {
			int base = division(list, left, right);
//			System.out.format("base:= %d:\t",list[base]);
			System.out.print("base:="+ list[base]+"\t");
			printPart(list, left, right);
//			递归调用，来得到基准值
			quickSort(list, left, base-1);
		    quickSort(list, base+1, right);
		}
	}
	
//	该方法输出每一行的数据
	private void printPart(int[] list,int begin,int end) {	
		for(int i=0; i<=begin; i++) {
			System.out.print("\t");
		}
		for(int i=begin; i<=end; i++) {
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] array = {
				2,4,5,7,8,9,6,3,1	
		};
		QuickSortM2 m2 = new QuickSortM2();
		System.out.print("排序前:\t");
		m2.printPart(array, 0, array.length-1);
		m2.quickSort(array, 0, array.length-1);
		System.out.print("排序后：\t");
		m2.printPart(array, 0, array.length-1);
	}
}
