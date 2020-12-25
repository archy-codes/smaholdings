package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.ServicesMenu;

public interface ServicesMenuDAO {
	
	ServicesMenu get(int id);
	List<ServicesMenu> getActiveServiceList();
	boolean add(ServicesMenu servicesmenu);
}
