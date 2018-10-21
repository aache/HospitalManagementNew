package com.example.demo.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Coin;

@RestController
public class CoinController {
	
	@Autowired
	DataSource ds ; 

	@PostMapping("/api/addCoin")
	//@CrossOrigin(allowedHeaders="*")
	public ResponseEntity<String> addCoin(@RequestBody Coin coin) {
		System.out.println(coin.getCoinName() +" >>> "+ coin.getCoinPrice());
		return new ResponseEntity<String>("\"Success1\"", HttpStatus.OK);
	}
	
	@GetMapping("/api/testDs")
	public void testDatasource() {
		try {
		System.out.println(ds.getConnection().getMetaData());
		}catch(Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
