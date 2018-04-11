package com.springbootjpa;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.service.MovieService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  @Autowired
  private MovieService movieService;

  /**
   * 修改 | 新增
   */
  @Test
  public void save(){
    Movie movie = new Movie();
    movie.setId(10);
    movie.setName("海上钢琴师");
    movie.setPrice(80d);
    movie.setActionTime(new Date());
    movieService.save(movie);
  }

  /**
   * 通过迭代器进行多条数据的新增 | 修改
   */
  @Test
  public void saveAll(){
    List<Movie> movies = new ArrayList<>();
    Movie movie = new Movie();
    movie.setId(10);
    movie.setName("速1");
    movie.setPrice(30d);
    movie.setActionTime(new Date());

    Movie movie1 = new Movie();
    movie1.setName("速2");
    movie1.setActionTime(new Date());
    movie1.setPrice(30d);

    Movie movie2 = new Movie();
    movie2.setName("速3");
    movie2.setActionTime(new Date());
    movie2.setPrice(30d);
    movies.add(movie);
    movies.add(movie1);
    movies.add(movie2);
    movieService.saveAll(movies);
  }

  /**
   * 删除
   */
  @Test
  public void remove(){
    movieService.deleteById(9);
  }

  /**
   * 查询所有
   */
  @Test
  public void findAll(){
    List<Movie> movies = movieService.findAll();
    for(Movie movie:movies){
      System.out.println(movie.getName());
    }
    System.out.println("------"+movieService.findById(10));
  }

  /**
   * 通过排序查询所有
   */
  @Test
  public void findAllSort(){
    Sort sort = new Sort(Sort.Direction.DESC,"id");
    List<Movie> movies = movieService.findAll(sort);
    for(Movie movie:movies){
      System.out.println(movie.getName());
    }
    System.out.println("------"+movieService.findById(10));
  }

  @Test
  public void findOneIte(){
    Movie movies = new Movie();
    movies.setId(10);
    List<Movie> movies1 = new ArrayList<>();
    movies1.add(movies);
    Example<Movie> example = Example.of(movies);
    Sort sort = new Sort(Sort.Direction.ASC,"id");
    List<Movie> movie = movieService.findAll(example,sort);
    for(Movie movie1:movie){
      System.out.println(movie1.getName());
    }
  }

  /**
   * 通过迭代器查询ID对应的值
   */
  @Test
  public void findOne(){
    Movie movies = new Movie();
    movies.setId(10);
    Example<Movie> example = Example.of(movies);
    Optional<Movie> movie = movieService.findOne(example);
    System.out.println(movie);
  }

  /**
   * 利用迭代器进行对多个指定ID的查询
   */
  @Test
  public void findIte(){
    List<Integer> ids = new ArrayList<>();
    ids.add(10);
    ids.add(11);
    List<Movie> movies = movieService.findAllById(ids);
    for(Movie movie:movies){
      System.out.println(movie.getName()+" "+movie.getActionTime());
    }
  }

  @Test
  public void findCount(){
    Boolean b = movieService.existsById(9);
    System.out.println("b = "+b);
    System.out.println("长度 = "+movieService.count());;
  }

  @Test
  public void findByName(){
    List<Movie> movies = movieService.findByMovieName("后来");
    for(Movie movie:movies){
      System.out.println(movie.getName());
    }
  }

  @Test
  public void findByParam(){
    List<Movie> movies = movieService.findByNameNotLike("%后%");
    for(Movie movie:movies){
      System.out.println(movie.getName());
    }
  }

}
