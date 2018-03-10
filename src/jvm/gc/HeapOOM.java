package jvm.gc;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author pierre 18-2-26
 */
public class HeapOOM {

	static class OOMObject {

	}

	public static void main(String[] args) {
		List<OOMObject> list = new ArrayList<>();
		while (true) {
			list.add(new OOMObject());
		}
	}

}
