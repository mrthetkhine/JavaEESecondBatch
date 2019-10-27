package com.example.demo.service.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.dto.UserSearchDto;
import com.example.demo.entity.User;


public class UserSpecification {
	public static Specification<User> getUserByNameOrEmail(UserSearchDto search)
	{
		return new Specification<User>() {

			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				Predicate name = criteriaBuilder.equal(root.get("name"), search.getName());
				Predicate email = criteriaBuilder.equal(root.get("email"), search.getEmail());
				
				return criteriaBuilder.or(name , email);
			}

			
		    };
		
	}

}
