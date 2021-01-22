package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {

	@Autowired
	private SqlSession sql;

	// 전체 리스트
	public List<PersonVo> dbList() {

		System.out.println("dao: dbList()");

		List<PersonVo> pList = sql.selectList("phonebook.selectList");// selectList("name", return);

		System.out.println(pList.toString());

		return pList;

	}

	// 저장
	public int dbIsrt(PersonVo pVo) {

		System.out.println("dao: dbIsrt()");

		int count = sql.insert("phonebook.insert", pVo);

		System.out.println(pVo.toString());

		return count;

	}

	// 삭제
	public int dbDle(int person_id) {

		System.out.println("dao: dbDle()");

		int count = sql.delete("phonebook.delete", person_id);

		System.out.println(person_id);

		return count;

	}

	// 특정 리스트 → 수정 폼
	public PersonVo getOne(int person_id) {

		System.out.println("dao: getOne()");

		PersonVo pVo = sql.selectOne("phonebook.getOne", person_id);

		System.out.println(pVo.toString());

		return pVo;

	}

	// 수정
	public int dbUpd(PersonVo pVo) {

		System.out.println("dao: dbUpd()");

		int count = sql.update("phonebook.update", pVo);

		System.out.println(pVo.toString());

		return count;
	}

}
