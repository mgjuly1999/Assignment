package Servic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public final class Utility {
public static final BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
public static final  int smallest(int[] arr)
{  int i;
   int min = arr[0];
    for (i = 1; i < arr.length; i++)
        if (arr[i] < min)
            min = arr[i];
    return min;
}
}
