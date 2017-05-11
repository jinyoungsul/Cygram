package mapper;

import java.util.List;
import java.util.Map;

import vo.CommentDiary;
import vo.Diary;

public interface DiaryMapper {
	public int insert(Diary diary);
	public int update(Diary diary);
	public Diary select(int diaryNo);
	public List<Diary> selectDiaryList(Map<String, Object> map);
	public int selectDiaryCount();	
}
