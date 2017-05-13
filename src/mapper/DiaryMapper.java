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
	public int selectDiaryCount(String id);
	public List<Diary> selectDiaryListFriend(Map<String, Object> map);
	public List<Diary> selectDiaryListNotFriend(Map<String, Object> map);
	public int selectDiaryCountFriend(String id);
	public int selectDiaryCountNotFriend(String id);	
}
