package com.gunzip.member;

public interface MemberDAO {
	MemberDTO login(MemberDTO login);
	int insert(MemberDTO user);
	MemberDTO chkID(String userID);
}
