
public void print(int[][] matrix, int left, int up, int right, int down) {
	if (left > right || up > down) return;
	if (left == right) {
		for (int i = up; i <= down; i++) {
			print(matrix[i][left]);
		}
		return;
	}
	if (up == down) {
		for (int i = left; i <= right; i++) {
			print(matrix[up][i]);
		}
		return;
	}
	for (int i = left; i < right; i++) {
		print(matrix[up][i]);
	}
	for (int i = up; i < down; i++) {
		print(matrix[i][right]);
	}
	for (int i = right; i > left; i--) {
		print(matrix[down][i]);
	}
	for (int i = down; i > up; i--) {
		print(matrix[i][left]);
	}
	print(matrix, left + 1, up + 1, right - 1, down - 1);
}
