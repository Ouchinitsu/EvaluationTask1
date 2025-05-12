package com.example.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.book.model.Book;
import com.example.book.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;

	//メインページへアクセス
	@GetMapping
	public String showBooks(Model model) {
		List<Book> bookList = bookService.findAll();
		model.addAttribute("books", bookList);
		return "book";
	}

	//idが対応する本の修正ページへ移動
	@GetMapping("/edit/{janCd}")
	public String showEditForm(@PathVariable String janCd, Model model) {
		Book book = bookService.findById(janCd)
				.orElseThrow(() -> new IllegalArgumentException("無効な JAN_CD : " + janCd));
		model.addAttribute("book", book);
		return "edit";
	}

	////idが対応する本の修正を保存する
	@PostMapping("/update/{janCd}")
	public String updateBook(@PathVariable String janCd, @ModelAttribute Book book) {
		book.setJanCd(janCd);
		bookService.save(book);
		return "redirect:/book";
	}
}
