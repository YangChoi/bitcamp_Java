// ���� 1���� ������
// int ������ ������ �˷��ش�. 
enum Figure {
	LINE, CIRCLE, RECT, ROUNDRECT, PEN;
}
class ShapeDTO {
	private int x1, y1, x2, y2, z1, z2;
	private boolean fill; // ä�����ϴ��� �ƴ��� 
	private Figure shape; 
	private int combo; // combo�� �ε������� �������� �ǹǷ� 
}