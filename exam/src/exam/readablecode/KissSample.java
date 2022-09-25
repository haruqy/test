package exam.readablecode;

import java.util.Arrays;

public class KissSample {

	private static final boolean 偶数です = true;
	private static final boolean 奇数です = false;
	private static final int[] intArr = { 1, 2, 3, 4, 5, 6 };

	public static void main(String[] arg) {
		System.out.println("###A 偶数の合計は：" + getIntArrSumA(intArr, 偶数です));
		System.out.println("###A 奇数の合計は：" + getIntArrSumA(intArr, 奇数です));
		System.out.println("###B 偶数の合計は：" + getIntArrSumB(intArr, 偶数です));
		System.out.println("###B 奇数の合計は：" + getIntArrSumB(intArr, 奇数です));
	}

	private static Integer getIntArrSumA(int[] intArr, boolean isEven) {
		int retInt = 0;

		for (int arr : intArr) {
			if (isEven) {
				if ((arr % 2) == 0) {
					retInt += arr;
				}
			} else {
				if ((arr % 2) != 0) {
					retInt += arr;
				}
			}
		}
		return retInt;
	}

	private static Integer getIntArrSumB(int[] intArr, boolean isEven) {
		return isEven ? Arrays.stream(intArr).filter(i -> i % 2 == 0).sum()
				: Arrays.stream(intArr).filter(i -> i % 2 != 0).sum();
	}
}
