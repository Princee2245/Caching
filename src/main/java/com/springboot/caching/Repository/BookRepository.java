package com.springboot.caching.Repository;

import com.springboot.caching.Entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface BookRepository extends JpaRepository<Book,Integer> {

    @Transactional
    @Modifying
    @Query("update book u set u.name=?2 where u.id=?1")
    int updateAddress(int id,String name);
}
