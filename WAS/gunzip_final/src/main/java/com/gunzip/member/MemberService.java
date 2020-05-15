package com.gunzip.member;

public interface MemberService {
	MemberDTO login(MemberDTO login);
	int insert(MemberDTO user);
	MemberDTO chkID(String userID);
}
