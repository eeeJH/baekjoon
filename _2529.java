package code;

import java.io.IOException;
import java.util.*;

public class _2529 {

	// �ε�ȣ ���� ����
	static int k;

	// ����� ���ڸ� boolean �� �Ǵ�
	// ��������� true, ���� ������� �ʾ����� false
	static boolean number[] = new boolean[10];

	// �ε�ȣ
	static char[] arr = new char[10];
	static ArrayList<String> answers = new ArrayList<String>();

	public static void main(String arg[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		k = sc.nextInt();

		for (int i = 0; i < k; i++) {
			arr[i] = sc.next().toCharArray()[0];
		}

		go("", 0);

		Collections.sort(answers);

		System.out.println();
		System.out.println(answers.get(answers.size() - 1));
		System.out.println(answers.get(0));

		sc.close();
	}

	public static void go(String num, int count) {
		if (count == k + 1) {
			answers.add(num);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (number[i])
				continue;
			if (count == 0 || ck(num.charAt(count - 1), (char) (i + '0'), arr[count - 1])) {
				number[i] = true;
				go(num + i, count + 1);
				number[i] = false;
			}
		}

	}

	public static boolean ck(char a, char b, char c) {
		if (c == '<') {
			if (a > b)
				return false;
		} else if (c == '>') {
			if (a < b)
				return false;
		}
		return true;
	}

}
