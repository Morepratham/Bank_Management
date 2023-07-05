package com.jsp.service;

import com.jsp.dao.PanDao;
import com.jsp.dto.Pan;

public class PanService {
	PanDao panDao= new PanDao();
	public Pan savePanCardDetails(Pan pan) {
		return panDao.savePancardDetail(pan);
	}

}
