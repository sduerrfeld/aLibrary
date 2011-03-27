package org.alibrary.backend.dao;

import org.alibrary.backend.model.Buch;

public interface BuchDao {

	Buch speichereBuch(Buch buch);

	Buch ladeBuch(Long id);

}
