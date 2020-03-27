package com.wy.common.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomUtil {
	//方法1：返回min-max之间的随机整数（包含min和max值），例如返回1-3之间的随机数，那么返回1或2或3都是正确的，返回4就不对。 (5分)
		public static int random(int min, int max){
			/*
			 * nextInt方法生成整数准则是从0开始小于等于给定数
			 * 因此如5到10之间，目标是生成5 6 7 8 9 10
			 * 但是方法中只用一个值且还是从0开始
			 * 因此先相减结果代表可以生成多少个数字
			 * 同时每一个生成的数就是“可变量”
			 * 之所以加一是因为生成的数最大值比给定上线小1
			 * 最后生成的数字与最小值相加，这时最小数就是“不变量”
			 * 不变量+可变量=最终数
			 */
			return new Random().nextInt(max-min+1)+min;
		}
		//方法2：在最小值min与最大值max之间截取subs个不重复的随机数。例如在1-10之间取3个不重复的随机数，那么[2,6,9]是对的，[3,5,5]则不对，因为5重复了。应用场景：在100篇文章中随机取10篇文章，月考可能会使用到。 (8分)
		public static int[] subRandom (int min, int max, int subs){
			//控制个数安全
			if(subs>(max-min)+1){
				throw new RuntimeException("范围异常");
			}
			
			Set<Integer> set=new HashSet<>();
			while(set.size()<subs){
				set.add(random(min, max));
			}
			
			int[] result=new int[subs];
			int index=0;
			for (int i : set) {
				result[index]=i;
				index++;
			}
			
			return result;
		}
		//方法3：返回1个1-9,a-Z之间的随机字符。 (8分)
		public static char randomCharacter (){
			String st="123456789"
					+ "qwertyuiopasdfghjklzxcvbnm"
					+ "QWERTYUIOPASDFGHJKLZXCVBNM";
			int index = random(0, st.length()-1);
			return st.charAt(index);
		}
		//方法4：返回参数length个字符串(5分)，方法内部要调用randomCharacter()方法 (4分)
		public static String randomString(int length){
			StringBuffer sb=new StringBuffer();
			for (int i = 0; i < length; i++) {
				sb.append(randomCharacter());
			}
			return sb.toString();
		}

}
