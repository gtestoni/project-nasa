package com.challenge.mars.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.mars.exception.MarsException;
import com.challenge.mars.services.MarsService;

@RestController
@RequestMapping("rest/mars")
public class MarsResource {

	@Autowired
	private MarsService service;

	@PostMapping("/{coordinate}")
	public ResponseEntity<String> sendPosition(@PathVariable String coordinate) {
		try {
			return ResponseEntity.ok(service.sendCoordinates(coordinate));
		} catch (MarsException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

}
