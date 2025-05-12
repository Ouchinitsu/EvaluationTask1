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

	//新しい情報に更新
	public Book save(Book book) {
		if (bookRepository.existsById(book.getJanCd())) {
			book.setUpdateDatetime(LocalDateTime.now());
		}
		return bookRepository.save(book);
	}

	//すべてを取得
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	//JAN_CD で検索
	public Optional<Book> findById(String janCd) {
		return bookRepository.findById(janCd);
	}
}
