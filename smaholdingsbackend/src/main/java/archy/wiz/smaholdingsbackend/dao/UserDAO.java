package archy.wiz.smaholdingsbackend.dao;


import java.util.List;

import archy.wiz.smaholdingsbackend.dto.User;

public interface UserDAO {

  List<User> list();
  User get(int id);
  boolean add(User user);
  
}
