package com.boost.springboostupex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boost.springboostupex.dao.MemberDao;
import com.boost.springboostupex.dto.Member;
@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public void insert(Member member) {
        memberDao.insert(member);
    }

    public void update(Member member) {
        memberDao.update(member);
    }

    public void delete(int id) {
        memberDao.delete(id);
    }

    public List<Member> selectAll() {
        return memberDao.selectAll();
    }

    public Member findById(int id) {
        return memberDao.findById(id);
    }
}
