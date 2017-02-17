package fr.humanbooster.fx.enquetes.test;

import java.sql.Date;
import java.util.Calendar;

import fr.humanbooster.fx.enquetes.dao.EnqueteDao;
import fr.humanbooster.fx.enquetes.dao.impl.EnqueteDaoImpl;

public class Test {

	public static void main(String[] args) {

		EnqueteDao ed = new EnqueteDaoImpl();
		ed.openCurrentSessionWithTransaction();
		ed.findAll();
		String name = "castor";
		System.out.println("by name : " + ed.findByName(name));
		Calendar cal = Calendar.getInstance();
		cal.set(2017, 0, 3);
		Date date1 = new Date(cal.getTimeInMillis());
		cal.set(2017, 6, 23);
		Date date2 = new Date(cal.getTimeInMillis());
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(cal);

		System.out.println(date1);
		System.out.println("by date : " + ed.findByDate(date1, date2));
		ed.closeCurrentSessionwithTransaction();
	}

}
