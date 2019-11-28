import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HeapSort 
{
	
	public static void main(String[] args) 
	{
		File f1 = new File("C:/Users/Ahmad/Desktop/CP3 H.W/BinaryTree/src/HeapSorttester.in");
		
		try
		{
			Scanner scan = new Scanner(f1);
			
			int testcases = scan.nextInt();
			for(int i = 0; i < testcases ; i++)
			{
				int test = scan.nextInt();
				int a[] = new int[test];
				
				for(int j = 0 ; j < test ; j++)
				{
					a[j] = scan.nextInt();
				}
				for(int j = 0 ; j < a.length ; j++)
				{
					System.out.print(a[j] + " ");
				}
				sortNumbers(a);
				System.out.println();
				for(int j = 0 ; j < a.length ; j++)
				{
					System.out.print(a[j] + " ");
				}
				System.out.println();
			}
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		
	}
	private static int heapSize;
 
	public static void sortNumbers(int[] A)
	{
		HeapSort(A);
	}
 
	private static void HeapSort(int[] A)
	{
		heapSize = A.length;
		BuildMaxHeap(A);
		for (int i = A.length-1; i>0; i--)
		{
			int temp = A[0];
			A[0] = A[i];
			A[i] = temp;
			heapSize--;
			MaxHeapify(A,0);
		}
	}
 
	private static void BuildMaxHeap(int[] A)
	{
		for(int i = A.length/2-1;i>=0;i--)
		{
			MaxHeapify(A, i);
		}
	}
 
	private static void MaxHeapify(int[] A, int i)
	{
		int l = Left(i);
		int r = Right(i);
		int max;
		if (l < heapSize)
		{
			if (A[l] > A[i])
			{
				max = l;
			}
			else 
			{
				max = i;
			}
		}
		else 
		{
			max = i;
		}
 
		if (r < heapSize)
		{ 
			if(A[r] > A[max])
			{ 
				max = r; 
			}
		}
 
		if (max != i)
		{
			int temp = A[i];
			A[i] = A[max];
			A[max] = temp;
			MaxHeapify(A, max);
		}
	}
	
	private static int Left(int i)
	{
		return 2 * i;
	}
	
	private static int Right(int i)
	{
		return (2 * i) + 1;
	}
}