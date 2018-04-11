package com.springbootjpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 持久层由JPA管理
 */
public interface MovieRepository extends JpaRepository<Movie,Integer>{
    // 查询语言
    @Query(value = "from Movie m where m.name=:name")
    List<Movie> findByMovieName(@Param("name") String name);

    // 模糊查询
    List<Movie> findByNameLike(String name);

    // 模糊查询 not like
    List<Movie> findByNameNotLike(String name);

}
