package programmers;

public class 스킬트리 {
	static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (String skill_tree : skill_trees) {
			int[] indexes = new int[skill.length()];
			for (int j = 0; j < skill.length(); ++j) {
				indexes[j] = skill_tree.indexOf(skill.substring(j, j + 1));	// 스킬트리에서 각 스킬의 위치를 저장함
			}

			int pre = indexes[0];		// 이전 스킬의 위치
			boolean check = true;		// 스킬트리가 조건에 일치하는지 확인하기 위한 변수
			for (int k = 1; k < indexes.length; ++k) {
				if (pre == -1 && indexes[k] > -1)			// 이전 스킬을 선행하지 않은 경우
					check = false;
				if (indexes[k] != -1 && (pre > indexes[k]))	// 현재 스킬을 선행 스킬보다 먼저 배운 경우
					check = false;

				if (!check)
					break;

				pre = indexes[k];
			}

			if (check)					// 스킬트리가 조건에 맞게 만들어진 경우
				++answer;
		}

		return answer;
	}

	public static void main(String[] args) {

	}
}
