/**
 * 
 */
package shellSort;

/**
 * @author acer
 *
 */
public class ShellSortM {

	private void shellSort(int[] list) {
	  int gap = list.length / 2;
	  while(gap >= 1) {
		  for(int i=gap;i<list.length;i++) {
			  int temp = list[i];
			  int j = 0;
//			  如果在分组的两个数据中，前面的i-gap>后面的i,则互换数字
			  for(j = i-gap;j>=0 && list[j+gap]<list[j];j-=gap) {
				  list[j+gap] = list[j];
			  }
//			  System.out.print("=="+j);
//			  这时候要将temp的值赋给前面一个的数字,如果不符合for循环，则自己赋值给自己
			  list[j+gap] =temp;
//			  list[i-gap] = temp; X的
		  }
		  System.out.format("gap=%d:\t",gap);
		  printPart(list);
		  gap = gap/2;
	  }
	}
	
	private void printPart(int[] list) {
		for(int value:list) {
			System.out.print(value+"\t");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ShellSortM m = new ShellSortM();
		
		int[] array = {
				4,	1,	2,	5,	7,	9,	8,	6,	3,	5	
		};
		System.out.format("排序前：\t");
		m.printPart(array);
		
		m.shellSort(array);
		
		System.out.print("排序后：\t");
		m.printPart(array);
	}
	
}
