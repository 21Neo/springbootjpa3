package com.springbootjpa.service;

import com.springbootjpa.domain.Movie;
import com.springbootjpa.domain.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    /**
     * 利用迭代器进行多条数据的新增
     * @param movies
     * @return
     */
    @Override
    public List<Movie> saveAll(Iterable<Movie> movies) {
        return movieRepository.saveAll(movies);
    }

    /**
     * 利用Examples 进行查询所有，且排序
     * @param movieExample
     * @param sort
     * @return
     */
    @Override
    public List<Movie> findAll(Example<Movie> movieExample, Sort sort) {
        return movieRepository.findAll(movieExample,sort);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }

    @Override
    public List<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public List<Movie> findAll(Sort sort) {
        return movieRepository.findAll(sort);
    }

    @Override
    public Optional<Movie> findById(Integer id) {
        return movieRepository.findById(id);
    }

    // 利用迭代器通过ID查询
    @Override
    public Optional<Movie> findOne(Example<Movie> movieExample) {
        return movieRepository.findOne(movieExample);
    }

    @Override
    public List<Movie> findAllById(Iterable<Integer> id) {
       /* Iterable<Movie> iterable = new HashSet<>();*/
        return movieRepository.findAllById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return movieRepository.existsById(id);
    }

    @Override
    public long count() {
        return movieRepository.count();
    }

    @Override
    public List<Movie> findByMovieName(String name) {
        return movieRepository.findByMovieName(name);
    }

    @Override
    public List<Movie> findByNameLike(String name) {
        return movieRepository.findByNameLike(name);
    }

    @Override
    public List<Movie> findByNameNotLike(String name) {
        return movieRepository.findByNameNotLike(name);
    }

    /*@Override
    public void deleteAll(Iterable<? extends Number> id) {
        movieRepository.deleteAll(id);
    }*/
}
