package archy.wiz.smaholdingsbackend.dao;

import java.util.List;

import archy.wiz.smaholdingsbackend.dto.Category;

public interface CategoryDAO {
   List<Category> list();
   Category get(int id);
}
