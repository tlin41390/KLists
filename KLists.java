import java.io.*;
import java.util.*;

public class KLists
{   
    //swaps the values in an array if necessary.
    public void swap(double[] numList, int num1, int num2)
    {
        double temp = numList[num1];
        numList[num1] = numList[num2];
        numList[num2]= temp;
    }
    // finds the smallest index.
    public int findSmallest (double[] numList,int  small)
    {
        int smallest = small;
        //if the next index is smaller than the current one then smallest will be i.
        for (int i =smallest+1;i<numList.length-1;i++)
        {
            if(numList[i]<numList[smallest])
            {
                smallest = i;
            }
        }
        return smallest;
    }
    //void function to sort the array
    public void sort(double [] numList)
    {
        for(int i=0;i<numList.length-1;i++)
        {
            swap(numList,i,findSmallest(numList,i));
        }
    }
    //array that will merge the 2d array to a 1d array.
    public double [] mergeKLists (double [][] outerArray)
    {
        //creates a list to combine all the intergers to one list
        List<Double> numList = new ArrayList<Double>();

        for (int row=0;row<outerArray.length;row++)
        {
            for (int col = 0;col<outerArray[row].length;col++)
            {
                numList.add(outerArray[row][col]);
            }
        }

        double [] mergedArray = new double[numList.size()];
        //put all the values on the list to a double array
        for(int i=0;i<mergedArray.length;i++)
        {
            mergedArray[i]=numList.get(i);
        }
        return mergedArray;
        
    }

    public static void main(String [] args)
    {
        double [][] arrList = new double[][] {{1.1,4,4,5,5},{1.1,3.3,4.4},{2.2, 6.6}};
        KLists mergeArray = new KLists();
        double [] totalArray = mergeArray.mergeKLists(arrList);
        mergeArray.sort(totalArray);
        System.out.println(Arrays.toString(totalArray));
    }
}
