package com.example.book.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.book.model.Book;
import com.example.book.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	// 新增或更新
	public Book save(Book book) {
		if (bookRepository.existsById(book.getJanCd())) {
			book.setUpdateDatetime(LocalDateTime.now());
		}
		return bookRepository.save(book);
	}

	// 查询全部
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	// 根据 JAN_CD 查询
	public Optional<Book> findById(String janCd) {
		return bookRepository.findById(janCd);
	}

	// 删除
	public void deleteById(String janCd) {
		bookRepository.deleteById(janCd);
	}
}
