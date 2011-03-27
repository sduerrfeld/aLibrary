package org.alibrary.backend.model.testsupport;

import org.alibrary.backend.model.Buch;

public class ObjectMother {

	public static Buch createValidBuch() {
		Buch buch = new Buch();
		buch.setISBN("ISBN 0 93028 923 4");
		buch.setTitel("Ein Buch");
		buch.setMarkierung("Markierung");
		buch.setAusleihstatus("Ausleihstatus");
		return buch;
	}

}
