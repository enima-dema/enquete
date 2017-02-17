package fr.humanbooster.fx.enquetes.test;

import fr.humanbooster.fx.enquetes.dao.EnqueteDao;
import fr.humanbooster.fx.enquetes.dao.impl.EnqueteDaoImpl;

public class Test {

	public static void main(String[] args) {
		
		EnqueteDao ed =new EnqueteDaoImpl();
		ed.openCurrentSessionWithTransaction();
		ed.findAll();
		ed.closeCurrentSessionwithTransaction();
	}

}
