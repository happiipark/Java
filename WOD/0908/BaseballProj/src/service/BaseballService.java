package service;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import dao.TeamDAO;
import dto.Team;

public class BaseballService {
	
	static int temNumber = 1;
	
	//팀등록 1
	public void regTeam() {
		Connection conn = TeamDAO.getConnection();
		System.out.println("[팀등록]");
		System.out.print("팀명 : ");
		String teamName = sc.nextLine();
		boolean idDoubleCheck = TeamDAO.idDoubleCheck(conn, teamName);
		if(idDoubleCheck == false) {
			TeamDAO.close(conn);
			System.out.println("중복된 팀 명입니다.");
			return;
			
		}
		System.out.print("연고지 : ");
		String local = sc.nextLine();
		TeamDAO.insertTeam(conn, new Team(TeamDAO.selectTeamNumber(), teamName, local));
		TeamDAO.close(conn);

	}
	//특정 팀조회 2
	public void selectTeam() {
		
		Connection conn = TeamDAO.getConnection();
		System.out.println("[어느팀이 궁금하드냐?]");
		System.out.print("팀 명 : ");
		String teamName = sc.nextLine();
		
		Team team = TeamDAO.selectTeam(conn, teamName);
		if(team == null) {
			TeamDAO.close(conn);
			System.err.println("팀명 알아오쇼!");
			return;
		}
		System.out.println(String.format("%s 정보 " ,teamName));
		System.out.println(team);
		TeamDAO.close(conn);
	}
	//팀목록조회(전체조회) 3
	public void allSelectTeam() {
		Connection conn = TeamDAO.getConnection();
		System.out.println("[전체 팀]");
		
		List<Team> teamList = TeamDAO.selectTeamList(conn);
		
		for(Team team : teamList) {
			System.out.println(team);
		}
		
		TeamDAO.close(conn);
		
	}
	
	
	//선수 등록 4
	public void regPlayer() {
		System.out.println("[선수등록]");
		System.out.print("선수명 : ");
		String playerName = sc.nextLine();
		System.out.print("등번호 : ");
		Integer backNum = Integer.parseInt(sc.nextLine());
		System.out.print("팀 선택 : ");
		// 1:SSG랜더스
		// 2:키움히어로즈
		// 3:LG트윈즈
		// 4:KT위즈
		System.out.print("선택 >> ");
		Integer tempNum = Integer.parseInt(sc.nextLine());
	}
	//특정 선수 조회(이름으로 조회) 5
	//특정 선수 조회(등번호로 조회) 6
	//특정 선수 조회 (번호로) 7
	//특정팀 소속 선수 목록 조회 8
	
	Scanner sc = new Scanner(System.in);
	
	public int menu() {
		int sel;
		System.out.println("[야구 팀/선수 등록/조회]");
		System.out.println("1. 팀등록");
		System.out.println("2. 특정 팀조회");
		System.out.println("3. 팀목록 조회");
		System.out.println("------------");
		System.out.println("4. 선수등록");
		System.out.println("5. 특정 선수 조회(이름으로)");
		System.out.println("6. 특정 선수 조회(등번호로)");
		System.out.println("7. 특정 선수 조회(번호로)");
		System.out.println("8. 특정 팀 선수목록 조회");
		System.out.println("0. 종료");
		System.out.print("선택 >> ");
		sel = Integer.parseInt(sc.nextLine());
		return sel;
	}
	
	public void selNumber(int sel) {
		switch(sel) {
		case 1:
			regTeam();
			break;
		case 2:
			selectTeam();
			break;
		case 3:
			allSelectTeam();
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		}
	}
}
