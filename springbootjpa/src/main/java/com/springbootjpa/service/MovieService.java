package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    // 增加 | 修改
    void save(Movie movie);
    // 利用迭代器进行多条数据的增加
    List<Movie> saveAll(Iterable<Movie> movies);
    // 利用迭代器多个ID
    List<Movie> findAll(Example<Movie> movieExample, Sort sort);

    // 删除
    void deleteById(Integer id);

    // 查询所有
    List<Movie> findAll();
    List<Movie> findAll(Sort sort);

    // 根据 ID 查询
    Optional<Movie> findById(Integer id);
    // 利用迭代器Example查询
    Optional<Movie> findOne(Example<Movie> movieExample);
    // 利用迭代器查询多个ID对应的值
    List<Movie> findAllById(Iterable<Integer> id);

    boolean existsById(Integer id);
    long count();

    // 删除多个ID
   /* void deleteAll(Iterable<? extends Number> id);*/

   // 根据剧名查询
    List<Movie> findByMovieName(String name);

    // 模糊查询
    List<Movie> findByNameLike(String name);
    // 模糊查询 not like
    List<Movie> findByNameNotLike(String name);

}
