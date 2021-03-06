package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Team;

/**
 * Teamsテーブルを操作するレポジトリ.
 * 
 * @author oyamadakenji
 *
 */
@Repository
public class TeamRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template; 
	
	private static final RowMapper<Team> TEAM_ROW_MAPPER = (rs,i) ->{
		Team team = new Team();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	}; 

	/**
	 * 全チームの情報を取得する.
	 * 
	 * @return 全チームの情報が入ったリスト
	 */
	public List<Team> findAll() {
		String sql = "SELECT id , league_name, team_name, headquarters, inauguration, history FROM teams ORDER BY inauguration";
		List<Team> teamList = template.query(sql, TEAM_ROW_MAPPER);
		return teamList;
	}
	
//	■質問：ex-emp-managementのAdministratorレポジトリであえて複数検索
//	> Listの要素数いかんによって戻り値を変更する処理を書いたけれども
//	あの処理は「SELECT系」でほぼ実装すべきなのかどうか？
	/**
	 * 1チームの情報を取得する.
	 * 
	 * @param id
	 * @return 1チームの情報が詰まったオブジェクト 
	 */
	public Team load(Integer id) {
		String sql = "SELECT id , league_name, team_name, headquarters, inauguration, history FROM teams WHERE id = :id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Team team = template.queryForObject(sql, param, TEAM_ROW_MAPPER);
		return team;
	}
}
