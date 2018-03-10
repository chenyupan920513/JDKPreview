package jvm.gc;

/**
 * @Author pierre 18-2-28
 */
public class GCPretenureSizeThreadhold {

	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		byte[] alloction;

		alloction = new byte[4 * _1MB];

	}
}
