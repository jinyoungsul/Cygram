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
		System.out.println("다이어리 수정ㄴ");
		System.out.println(diary);
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

	public List<Diary> selectDiaryFriendList(int startRow, int count, String id){
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryFriendList(map);
	}
	
	public List<Diary> selectDiaryPrivateList(int startRow, int count, String id){
		Map<String, Object> map = new HashMap<>();
		map.put("startRow", startRow);
		map.put("count", count);
		map.put("id", id);
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryPrivateList(map);
	}
	
	
	public int selectDiaryCount(String id){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryCount(id);
	}
	
	public int selectDiaryFriendCount(String id){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryFriendCount(id);
	}
	
	public int selectDiaryPrivateCount(String id){
		DiaryMapper mapper = session.getMapper(DiaryMapper.class);
		return mapper.selectDiaryPrivateCount(id);		
	}
	
}
