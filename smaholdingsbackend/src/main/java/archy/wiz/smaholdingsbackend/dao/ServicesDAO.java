package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Services;

public interface ServicesDAO {
	Services get(int id);
	List<Services> getActiveServices();
	
	boolean add(Services services);
	boolean update(Services services);
	boolean delete(Services services);
}
