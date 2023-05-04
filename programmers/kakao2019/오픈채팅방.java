package programmers.kakao2019;

import java.util.*;

public class 오픈채팅방 {
	static String[] solution(String[] record) {
		Map<String, String> information = new HashMap<>();
		information.put("Enter", "님이 들어왔습니다.");
		information.put("Leave", "님이 나갔습니다.");

		Map<String, String> users = new HashMap<>();		// 사용자 id와 name 정보를 저장
		List<UserRecord> userRecords = new ArrayList<>();	// 채팅 기록을 저장

		for (String s : record) {
			String[] recordSplit = s.split(" ");

			if (!recordSplit[0].equals("Leave")) {
				users.put(recordSplit[1], recordSplit[2]);
			}

			if (!recordSplit[0].equals("Change")) {
				UserRecord userRecord = new UserRecord(recordSplit[1], recordSplit[0]);
				userRecords.add(userRecord);
			}
		}

		String[] answer = new String[userRecords.size()];

		for (int i = 0; i < userRecords.size(); ++i) {
			UserRecord userRecord = userRecords.get(i);
			String s = users.get(userRecord.id) + information.get(userRecord.action);
			answer[i] = s;
		}

		return answer;
	}

	static class UserRecord {

		String id;

		String action;

		public UserRecord(String id, String action) {
			this.id = id;
			this.action = action;
		}
	}

	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234","Enter uid1234 Prodo",
				"Change uid4567 Ryan"
		};

		solution(record);
	}
}
