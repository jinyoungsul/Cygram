package mapper;

import java.util.List;
import java.util.Map;

import vo.Diary;

public interface DiaryMapper {
	public int insert(Diary diary);
	public int update(Diary diary);
	public Diary select(int diaryNo);
	public int delete(int diaryNo);
	
	public List<Diary> selectDiaryList(Map<String, Object> map);
	public List<Diary> selectDiaryFriendList(Map<String, Object> map);
	public List<Diary> selectDiaryPrivateList(Map<String, Object> map);
	
	public int selectDiaryCount(String id);	
	public int selectDiaryFriendCount(String id);
	public int selectDiaryPrivateCount(String id);
}
