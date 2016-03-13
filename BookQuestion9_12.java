package 幫忙解題;

import java.util.Scanner;

public class BookQuestion9_12 {
	
	/*斜率公式 a = y1-y2/x1-x2*/
    public static double getSlope(double x1,double y1,double x2 ,double y2){
    		if(x1-x2==0)
    			return 0;
    		else
    			return ((y1-y2)/(x1-x2));
    }
    /*取得直線方程的截距 b= y1 - ax1*/
    public static double getConstant(double x1,double y1,double slope){
    	return y1-x1*slope;
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* 
		 * 線性方程公式 y = ax +b
		 * 斜率a=y1-y2/x1-x2
		 * 常數b=y1-ax1
		 * y=ax+b,ax+by=c
		 * 
		 */
		
		
		//Step0 創建輸入用物件
		Scanner input = new Scanner(System.in);
		//Step1 將值存入陣列
		double [][] array= new double[4][2];
		for(int i = 1 ;    i<= 4 ; i ++ ){
			for(int j = 1; j<= 2 ; j ++ )
			{
				if(j == 1)
					System.out.printf("請輸入第%d組的X座標:",i);
				else
					System.out.printf("請輸入第%d組的Y座標:",i);
					array[i-1][j-1] = input.nextDouble();
			}
		}
		//Step2 檢查陣列是否正確
		for (double[] a : array){
			System.out.printf("座標X＝%f  座標Y＝%f \n",a[0],a[1]);
		}
		
		//Step3 分別取得Slope、Constant
		double firstSlope  = getSlope(array[0][0],array[0][1],array[1][0],array[1][1]);
		System.out.println("第一線段的斜率："+firstSlope);
		double secondSlope = getSlope(array[2][0],array[2][1],array[3][0],array[3][1]);
		System.out.println("第二線段的斜率："+secondSlope);
		double firstConstant = getConstant(array[0][0],array[0][1],firstSlope);
		System.out.println(firstConstant);
		double secondConstant = getConstant(array[2][0],array[2][1],secondSlope);
		System.out.println(secondConstant);
		
		//y=ax+b -->  -b = ax -y --> b =-ax +y  -->  -ax+y = b
		
		LinearEquation LE = new LinearEquation(firstSlope,1.0,secondSlope,1.0,firstConstant,secondConstant);
		
	
	
	
	}

}




class LinearEquation{
	private double a,b,c,d,e,f; //常數
	LinearEquation(double a, double b, double c, double d, double e, double f){
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
		this.e = e;
		this.f = f;
		if(isSolvable()!=false)
		{  
			System.out.println("關於X的座標等於"+getX());
		    System.out.println("關於Y的座標等於"+getY());
		}
		else
			System.out.println("the equation has no solution");
	}

	public double getter(char select){
		if(select == 'a')
			return this.a;
		else if(select == 'b')
			return this.b;
		else if(select == 'c')
			return this.c;
		else if(select == 'd')
			return this.d;
		else if(select == 'e')
			return this.e;
		else if(select == 'f')
			return this.f;
		else
			return 0.0;
	}
	public boolean isSolvable(){
		if(a*d-b*c != 0)
			return true;
		else 
			return false;
	}
	
	private double getX(){
		return (e*d-b*f)/(a*d-b*c);
	}
	private double getY(){
		return (a*f-e*c)/(a*d-b*c);
	}
	
	
	
}
