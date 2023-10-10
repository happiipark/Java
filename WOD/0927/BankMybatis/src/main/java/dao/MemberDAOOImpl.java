package dao;

import org.apache.ibatis.session.SqlSession;

import bean.Member;
import util.MybatisSqlSessionFactory;

public class MemberDAOOImpl implements MemberDAO {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();
	
	
	@Override
	public Member idDoubleChk(String id) throws Exception {
		Member member = sqlSession.selectOne("mapper.member.idDoubleChk",id);
		if(member != null) throw new Exception("id 중복");
		return member;
	}

	@Override
	public void insertMember(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember",member);
		sqlSession.commit();
	}

	@Override
	public Member login(String id) throws Exception {
		return sqlSession.selectOne("mapper.member.login",id);
	
	}
}
