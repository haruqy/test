package exam;

import java.text.DecimalFormat;

public class examLoopTest {

	/** ループ数 */
	public static final int LOOP_COUNT = 1000000;

	public static void main(String[] args) {

		System.out.println("----------　ループ内でインスタンス宣言");
		System.gc();
		for (int i = 0; i < LOOP_COUNT; i++) {
			// ループ内文字列
			StringBuffer loopInStr = new StringBuffer();
			loopInStr.append("あいうえおかきくけこ");
		}
		System.out.println(getMemoryInfo());

		System.out.println("----------　ループの外で宣言");
		System.gc();
		// ループ外文字列
		StringBuffer loopOutStr = new StringBuffer();
		for (int i = 0; i < LOOP_COUNT; i++) {
			loopOutStr.setLength(0);
			loopOutStr.append("あいうえおかきくけこ");
		}
		System.out.println(getMemoryInfo());
	}

	/**
	 * Java 仮想マシンのメモリ総容量、使用量、
	 * 使用を試みる最大メモリ容量の情報を返します。
	 * @return Java 仮想マシンのメモリ情報
	 */
	public static String getMemoryInfo() {
		DecimalFormat f1 = new DecimalFormat("#,###KB");
		DecimalFormat f2 = new DecimalFormat("##.#");
		// 残メモリ
		long free = Runtime.getRuntime().freeMemory() / 1024;
		// 総メモリ
		long total = Runtime.getRuntime().totalMemory() / 1024;
		// 最大メモリ
		long max = Runtime.getRuntime().maxMemory() / 1024;
		// 使用メモリ
		long used = total - free;
		// 率
		double ratio = (used * 100 / (double) total);
		String info = "Java メモリ情報 : 合計=" + f1.format(total) + "、" +
				"使用量=" + f1.format(used) + " (" + f2.format(ratio) + "%)、" +
				"使用可能最大=" + f1.format(max);

		//		String info = "Java メモリ情報 : 用量=" + f1.format(used);
		return info;
	}
}
