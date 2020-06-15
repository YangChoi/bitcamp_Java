package com.jstl;

import com.sun.istack.internal.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor // 모든 매개변수를 다 받겠다 
@RequiredArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonDTO {
	@NotNull 
	private String name; 
	private int age;
}
