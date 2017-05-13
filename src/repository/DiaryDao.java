package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mapper.DiaryMapper;
import vo.Diary;

@Component
public class DiaryDao {
	@Autowired
	private SqlSessionTemplate session;
	public void setSession(SqlSessionTemplate session){
		this.session=session;
	}
	//-----------------------------------------------//
	
	public int insert(Diary diary){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.insert(diary);
	}
	
	public int update(Diary diary){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.update(diary);
	}
	
	public Diary select(int diaryNo){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.select(diaryNo);
	}
	
	public List<Diary> selectDiaryList(int startRow, int count, String id ){
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryList(map);
	}
	
	public int selectDiaryCount(String id){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryCount(id);
	}

	public List<Diary> selectDiaryListFriend(int startRow, int count, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryListFriend(map);
	}

	public List<Diary> selectDiaryListNotFriend(int startRow, int count, String id) {
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryListNotFriend(map);
	}

	public int selectDiaryCountFriend(String id) {
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryCountFriend(id);
	}

	public int selectDiaryCountNotFriend(String id) {
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryCountNotFriend(id);
	}
}
