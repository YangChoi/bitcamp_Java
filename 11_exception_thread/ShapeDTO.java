// 도형 1개의 데이터
// int 형으로 도형을 알려준다. 
enum Figure {
	LINE, CIRCLE, RECT, ROUNDRECT, PEN;
}
class ShapeDTO {
	private int x1, y1, x2, y2, z1, z2;
	private boolean fill; // 채워야하는지 아닌지 
	private Figure shape; 
	private int combo; // combo의 인덱스값만 가져오면 되므로 
}