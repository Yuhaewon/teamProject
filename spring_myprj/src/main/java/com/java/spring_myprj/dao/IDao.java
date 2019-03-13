package com.java.spring_myprj.dao;

import java.util.ArrayList;

import com.java.spring_myprj.dto.VideoDto;
import com.java.spring_myprj.dto.review.ReviewDto;
import com.java.spring_myprj.login_dto.LoginDto;

public interface IDao {

	//비디오 검색
	public ArrayList<VideoDto> selectVideo(String sVideo);
	
	//비디오 리스트
	public ArrayList<VideoDto> vList();

	//비디오 리스트(인기순)
	public ArrayList<VideoDto> vViewH();
	
	//비디오 뷰
	public VideoDto vView(String vNum);
	
	//비디오 리스트
	public ArrayList<VideoDto> mList(String nsrc);

	//비디오 뷰 댓글
	public ArrayList<ReviewDto> vRe(String vNum);

	//비디오 뷰 댓글 쓰기
	public void vWrite(String userId, String reply, String vNum);
	
	//비디오 뷰 댓글 삭제
	public void vrDelete(String rNum);
	
	//비디오 뷰 댓글 수정
	public int vrModify(String revContent,String rNum);
	
	//비디오 뷰 플레이 리스트
	public ArrayList<ReviewDto> ranList(String uI);

	//게시글 총 갯수
	public int totalRowCount();

	//게시물 조회수
	public void upHit(String vNum);

	//마이페이지 회원 정보조회
	public ArrayList<LoginDto> myInfo(String userId);

	//즐겨찾기 동영상 추가
	public void userInVideo(String vNum,String userId, String vImage, String vTilte, String vContent);

	//마이페이지 회원 정보변경
	public void myModify(String userId, String userName, String userNick, String userAddr, String userphone,
			String eMail, String userPw);
	
	//마이페이지 회원 탈퇴
	public void myDelete(String userId);

	//내가 올린 동영상
	public ArrayList<VideoDto> myUploadVideo(String userId, int rowStart, int rowEnd);

	//페이징
	public int selectBoard2Count();

	
}
