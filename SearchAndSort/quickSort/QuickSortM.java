/**
 * 
 */
package quickSort;

/**
 * @author acer
 *
 */
public class QuickSortM {

//	这个方法返回基准值的索引
	private int division (int[] list , int left, int right) {
//		定义最左边的值为基准值
		int base = list[left];
		
		while(left < right) {
//			先从右边那个right指针开始判断
//			left<right 这个判断要写，因为可能在里面执行的时候会不符合这个条件，而没有跳出内层判断
			while(left < right && list[right] >= base) {
				right --;
			}
			list[left] = list[right];

			
			
			while(left < right && list[left] <= base) {
				left ++;
			}
			list[right] = list[left];

		}
		
//		left和right 最后都重叠在基准值这里，所以list[right] = base也可以
		list[left] = base ;
//		返回基准值的索引
		return left;
	}
	
	private void quickSort(int[] list, int left, int right) {
		if(left < right){
//		获得基准值的索引
		int base = division(list, left, right);
//		格式化输出
		System.out.format("base = %d:\t", list[base]);
//		
		printPart(list, left, right);
		
//		向左递归
		quickSort(list, left, base-1);
//		向右递归
		quickSort(list, base+1, right);
	
		}
	}
	
	private void printPart(int[] list, int begin, int end) {
		for(int i=0;i<begin;i++) {
			System.out.print("\t");
		}
		for(int i=begin; i<= end; i++) {
			System.out.print(list[i]+"\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
//		初始化一个序列
		int[] array = {
				2,4,5,7,8,9,6,3,1
		};
//		调用快排方法
        QuickSortM m = new QuickSortM();
        System.out.print("排序前："+"\t\t");
        m.printPart(array, 0, array.length-1);
        m.quickSort(array, 0, array.length-1);
        System.out.print("排序后："+"\t\t");
        m.printPart(array, 0, array.length-1);
	}
}
