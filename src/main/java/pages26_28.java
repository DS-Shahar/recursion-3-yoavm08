package recursya;
import java.util.Scanner;
public class pages26_28 {
	Scanner input = new Scanner(System.in);
	public static Scanner reader = new Scanner(System.in);
	
	
	public static int q1(int n) //n סכום מהספרים מ1 עד
	{
		if(n == 1)
			return 1;
		return n + q1(n-1);
	}
	
	
	public static int q2(int n) //n מחזיר עצרת של
	{
		if(n == 1)
			return 1;
		return n * q2(n-1);
	}
	
	
	public static int q3(int n) //n מכפלת המספרים אי זוגים מ1 עד
	{
		if(n == 1)
			return 1;
		if(n%2 == 1)
			return n * q3(n-1);
		return q3(n-1);
	}
	
	
	public static int q4(int n) // מחזיר מספר ספרות
	{
		if(n == 0)
			return 0;
		return 1 + q4(n/10);
	}
	
	
	public static int q5(int n, int m) //במקום חילוק
	{
		if(n < m)
			return 0;
		return 1 + q5(n-m, m);
	}
	
	
	public static int q6(int n, int m) // במקום מודולו
	{
		if(n < m)
			return n;
		return q6(n-m, m);
	}
	
	
	public static boolean q7(int x, int y) // y כפולה של x
	{
		if(x == 0)
			return true;
		if(x < y)
			return false;
		return q7(x-y, y);
	}
	
	
	public static boolean q8(int x) // בודק אם המספר ראשוני
	{
		if(x==2)
			return true;
		if(x%2 == 0 || x <= 1)
			return false;
		return q8A(x, 3);
	}
	
	public static boolean q8A(int x, int a)
	{
		if(a*a > x)
			return true;
		if(x%a == 0)
			return false;
		return q8A(x, a+2);
	}
	
	
	public static boolean q9(int x) // ספרות המספר ז. או א.ז
	{
		if(x%2 == 0)
			return q9A(x);
		return q9B(x);	
	}
	
	public static boolean q9A(int x)
	{
		if(x == 0)
			return true;
		if(x%2 == 1)
			return false;
		return q9A(x/10);
	}
	
	public static boolean q9B(int x)
	{
		if(x == 0)
			return true;
		if(x%2 == 0)
			return false;
		return q9B(x/10);
	}
	
	
	public static int q13a(int x) // מחזיר את המספר במיקום בסדרת פיבונצי כפל
	{
		if(x==1)
			return 0;
		if(x==2)
			return 1;
		return q13a(x-1)*q13a(x-1) + q13a(x-2)*q13a(x-2);
	}
	
	public static int q13b(int x) // x מחזיר את סכום המספרים בסדרה מ1 עד 
	{
		if(x==1)
			return 0;
		if(x==2)
			return 1;
		return q13a(x) + q13b(x-1);
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	// רקורסיה על מערכים
	
	
	public static int q14(int[] a, int i) // i סכום האיברים במערך מהמיקום 0 עד
	{
		if(i==0)
			return a[i];
		return a[i] + q14(a, i-1);
	}
	
	
	public static int q15(int[] a, int i) // מספר האיברים החיובים עד המציין
	{
		if(a[i] > 0)
		{
			if(i==0)
				return a[i];
			return a[i] + q15(a, i-1);
		}
		return q15(a, i-1);
	}
	
	
	public static int q16(int[] a, int i, int x) // מיקום של מספר במערך
	{
		if(a[i]==x)
			return i;
		if(i==0)
			return -1;
		return q16(a, i-1, x);
	}
	
	
	public static boolean q17(int[] a, int i) // בודק אם המערך ממוין בסדר עולה
	{
		if(a[i-1] < a[i])
		{
			if(i==1)
				return true;
			return q17(a, i-1);
		}
		return false;
	}
	
	
	public static boolean q18(int[] a, int i) // בודק אם אין במערך מספר ראשוני
	{
		if(q8(a[i]) == false)
		{
			if(i==0)
				return true;
			return q18(a, i-1);
		}
		return false;
	}
	
	
	public static boolean q20(int[] a) // בודק אם פולינדרום ממציין למציין
	{
		int x = (int)(Math.random()*(a.length));
		int y = (int)(Math.random()*(a.length));
		if(x < y)
			return q20A(a, x, y);
		return q20A(a, y, x);
	}
	
	public static boolean q20A(int[] a, int x, int y)
	{
		if(a[x] == a[y])
		{
			if(x==y || x==y-1)
				return true;
			return q20A(a, x+1, y-1);
		}
		return false;
	}
	
	public static int q21(char[] a, int i, String x, int j) // בודק כמה אותיות קטנות יש במחרוזת
	{
		String z1 = "" + a[i];
		String z2 = "" + x.charAt(j);
		if(z1.equals(z2))
			return 1 + q21(a, a.length-1, x, j-1);
		if(i==0)
		{
			if(j==0)
				return 0;
			return q21(a, a.length-1, x, j-1);
		}
		return q21(a, i-1, x, j);
	}
	
	
	public static void q25(int x, int y) // מקבל חצי מהמספר y
	{
		if(y>0)
		{	
			if(x%y==0)
				System.out.println(y);
			q25(x, y-1);
		}
	}
	
	
	public static boolean q31(int[] a, int count) 
	{
		if(count == 0)
			return true;
		if(a[count]>a[count-1]) 
			return q31(a,count-1);
		return false;
	}

	 
	
	public static void q32(int[] a, int i) // מדפיס אם המספרים העוקב לו גדול ממנו
	{
		if(i > 0)
		{
			if(a[i-1] > a[i])
				System.out.println(a[i]);
			q32(a, i-1);
		}
	}
	
	
	
	
	public static boolean ascending(int num)
	{
		if(num/10 == 0)
			return true;
		int x = num%10;
		int y = (num/10)%10;
		if(y>=x)
			return false;
		return ascending(num/10);
	}
	
	
	public static int number_appear(int [] a, int count, int num)
	{
		if(count == -1)
			return 0;
		if(a[count] == num)
			return number_appear(a,count-1,num) + 1;
		return number_appear(a,count-1,num);
	}
	
	
	


}
