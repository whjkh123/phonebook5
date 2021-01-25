package com.javaex.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	// 특정 리스트 → 수정 폼2
	public Map<String, Object> getOne2(int person_id) {

		System.out.println("dao: getOne2()");

		Map<String, Object> pMap = sql.selectOne("phonebook.getOne2", person_id);
		
		System.out.println(pMap.toString());		
		
		String name = (String)pMap.get("NAME");
		System.out.println(name);
		
		int id = Integer.parseInt(String.valueOf(pMap.get("PERSON_ID")));
		System.out.println(id);

		return pMap;

	}

	// 수정2
	public void dbUpd2(int person_id, String name, String hp, String company) {

		System.out.println("dao: dbUpd2(): " + person_id + ", " + name + ", " + hp + ", " + company);

		Map<String, Object> pMap = new HashMap<String, Object>();
		pMap.put("id", person_id);
		pMap.put("name", name);
		pMap.put("hp", hp);
		pMap.put("company", company);

		System.out.println(pMap.toString());

		sql.update("phonebook.update2", pMap);
	}

}