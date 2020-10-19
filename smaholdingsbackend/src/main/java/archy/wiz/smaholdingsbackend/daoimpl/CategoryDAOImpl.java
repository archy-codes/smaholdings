package archy.wiz.smaholdingsbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import archy.wiz.smaholdingsbackend.dao.CategoryDAO;
import archy.wiz.smaholdingsbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("ENGENEERING");
		category.setDescription("all engeneering work");
		category.setImageUrl("CAT_1.png");
		categories.add(category);
		
		category = new Category();
		category.setId(2);
		category.setName("LOGISTICS");
		category.setDescription("all logistics work");
		category.setImageUrl("CAT_2.png");
		categories.add(category);
		
		category = new Category();
		category.setId(3);
		category.setName("PROJECT PLANNING AND MANAGEMENT");
		category.setDescription("all Electrical engeneering work");
		category.setImageUrl("CAT_3.png");
		categories.add(category);
		
		category = new Category();
		category.setId(4);
		category.setName("CATERING");
		category.setDescription("all Plant hiring");
		category.setImageUrl("CAT_4.png");
		categories.add(category);
		
		category = new Category();
		category.setId(5);
		category.setName("ACCRIDITED TRAINING");
		category.setDescription("all the traning services work");
		category.setImageUrl("CAT_5.png");
		categories.add(category);
		
		category = new Category();
		category.setId(6);
		category.setName("SOCIAL INVESTMENT");
		category.setDescription("all social investing service");
		category.setImageUrl("CAT_6.png");
		categories.add(category);
		
		category = new Category();
		category.setId(7);
		category.setName("EVENTS MANAGEMENTS");
		category.setDescription("all the events work");
		category.setImageUrl("CAT_7.png");
		categories.add(category);
	}
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}
	@Override
	public Category get(int id) {
		for(Category category: categories) {
			if(category.getId() == id) return category;
		}
		return null;
	}

}
