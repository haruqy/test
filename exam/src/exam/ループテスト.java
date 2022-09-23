package exam;

import java.text.DecimalFormat;

public class ループテスト {

	public static final int ループ数 = 1000000;

	public static void main(String[] 引数) {

		System.out.println("----------　ループ内でインスタンス宣言");
		System.gc();
		for (int 初期値 = 0; 初期値 < ループ数; 初期値++) {
			StringBuffer ループ内文字列 = new StringBuffer();
			ループ内文字列.append("あいうえおかきくけこ");
		}
		System.out.println(メモリ情報取得());

		System.out.println("----------　ループの外でインスタンス宣言");
		System.gc();
		StringBuffer ループ外文字列 = new StringBuffer();
		for (int 初期値 = 0; 初期値 < ループ数; 初期値++) {
			ループ外文字列.setLength(0);
			ループ外文字列.append("あいうえおかきくけこ");
		}
		System.out.println(メモリ情報取得());
	}

	/**
	 * Java 仮想マシンのメモリ総容量、使用量、
	 * 使用を試みる最大メモリ容量の情報を返します。
	 * @return Java 仮想マシンのメモリ情報
	 */
	public static String メモリ情報取得() {
		DecimalFormat フォーマット１ = new DecimalFormat("#,###KB");
		DecimalFormat フォーマット２ = new DecimalFormat("##.#");
		long 残メモリ = Runtime.getRuntime().freeMemory() / 1024;
		long 総メモリ = Runtime.getRuntime().totalMemory() / 1024;
		long 最大メモリ = Runtime.getRuntime().maxMemory() / 1024;
		long 使用メモリ = 総メモリ - 残メモリ;
		double 率 = (使用メモリ * 100 / (double) 総メモリ);
		String メモリ情報 = "Java メモリ情報 : 合計=" + フォーマット１.format(総メモリ) + "、" +
				"使用量=" + フォーマット１.format(使用メモリ) + " (" + フォーマット２.format(率) + "%)、" +
				"使用可能最大=" + フォーマット１.format(最大メモリ);

		//		String info = "Java メモリ情報 : 用量=" + f1.format(used);
		return メモリ情報;
	}
}
