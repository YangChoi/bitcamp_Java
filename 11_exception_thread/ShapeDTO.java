// 도형 1개의 데이터
// int 형으로 도형을 알려준다. 
enum Figure {
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
	// 상수 나열하거 세미콜론 안찍는다. 
}
class ShapeDTO {
	private int x1, y1, x2, y2, z1, z2;
	private boolean fill; // 채워야하는지 아닌지 
	private Figure shape; 
	private int combo; // combo의 인덱스값만 가져오면 되므로 
	

	// setter
	public void setX1(int x1){
		this.x1 = x1;
	}
	public void setX2(int x2){
		this.x2 = x2;
	}
	public void setY1(int y1){
		this.y1 = y1;
	}
	public void setY2(int y2){
		this.y2 = y2;
	}
	public void setZ1(int z1){
		this.z1 = z1;
	}
	public void setZ2(int x2){
		this.z2 = z2;
	}
	public void setFill(boolean fill){
		this.fill = fill;
	}
	public void setShape(Figure shape){
		this.shape = shape;
	}
	public void setCombo(int combo){
		this.combo = combo;
	}

	public int getX1(){
		return x1;
	}
	public int getX2(){
		return x2;
	}
	public int getY1(){
		return y1;
	}
	public int getY2(){
		return y2;
	}
	public int getZ1(){
		return z1;
	}
	public int getZ2(){
		return z2;
	}

	public boolean getFill(){
		return fill;
	}

	public Figure getShape(){
		return shape;
	}

	public int getCombo(){
		return combo;
	}

}
