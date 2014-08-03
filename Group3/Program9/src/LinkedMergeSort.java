import java.util.Comparator;

public class LinkedMergeSort {
	public static <T> void mergeSort(MyLinkedList<T> list, Comparator<T> comp) {
		if (list.size() > 1) {
			// merge sort the second half
			MyLinkedList<T> secondHalf = list.split(list.size()/2);
			mergeSort(secondHalf, comp);
			
			// merge sort the first half
			mergeSort(list, comp);
			
			list = MyLinkedList.mergeSortedLists(list, secondHalf, comp);
		}
	}
}
