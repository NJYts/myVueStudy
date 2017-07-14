package test;

import java.util.Scanner;

public class BinaryDecimal {
	public static void main(String[] args) {
		System.out.println("请输入一个整型的十进制数：");
        Scanner reader = new Scanner(System.in);
        int num = 0;
        int result = 0;
        num = reader.nextInt();
        System.out.print("转换后的二进制数为：");
       
        int[] twoBit = new int[8];
        int count=0;
        twoBit = toBinary(num,twoBit,count);
        System.out.print("\n");
        // 二进制数据在计算机内是以二进制存储的，要注意一点，计算机在存储某个数据时，是存储的数据的补码，说明一下补码与原码关系，正数补码与原码相同，负数补码是原码减1后取反或者源码取反+1（最高位是符号位，不参与取反）。
        //取反
        for (int i = 1; i < twoBit.length; i++) {
			if(twoBit[i] == 1){
				twoBit[i] = 0;
			}else{
				twoBit[i] = 1;
			}
		}
        //+1
        for (int i = twoBit.length-1; i >= 1 ; i--) {
        	if(twoBit[i] == 1){
            	twoBit[i] = 0;
            }else{
            	twoBit[i] = 1;
            	break;
            }
		}
        //阶乘，Math.pow(double   m,   double  n)  ，m的n次幂，这个是便捷方法，为了练习逻辑没有用。
        if(twoBit[0] ==0 ){
        	for(int i = 1; i < twoBit.length; i++){
        		int a = 1;
        		for(int j = 1;j<8-i;j++){
        			 a=a*2;
        		}
        		System.out.println("result="+result+"+"+twoBit[i]+"*"+a);
        		result = result + twoBit[i]*a;
        		
        	}
        }else{
        	for(int i = 1; i < twoBit.length; i++){
        		int a = 1;
        		for(int j = 0;j<8-i-1;j++){
        			 a=a*2;
        		}
        		System.out.println("result="+result+"+"+twoBit[i]+"*"+a);
        		result = result + twoBit[i]*a;
        	}
        	result = -result;
        }
        System.out.println("补码转成十进制："+result);
        
	}
	
	 //递归函数
	static int[] toBinary( int num,int[] twoBit,int count){
		count++;
		int r;
		r = num%2;//最后一位要输出的，即使参数=1，还是要计算到这里结束，只取出余数就ok了。然后顺次返回上一级主调函数，继续执行剩下的……
		          //如果商 1 / 2 = 0，计算就可以终止了，不需要再算
		if(num>=2){
			 //精华，联系10进制转2进制的算法，每次除以2，取出余数，然后用新的商继续除以2，取出新余数……直到商为0，余数逆序输出即可
			toBinary(num/2,twoBit,count);//把新的商作为参数递归调用
		}
		//在递归语句之后输出，这样就是倒叙输出
       System.out.print(r);
       twoBit[7-(count-1)] = r;
       return twoBit;
	}
}
