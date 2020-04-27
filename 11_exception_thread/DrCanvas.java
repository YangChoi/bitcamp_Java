import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class DrCanvas extends Canvas {	
	private MsPaint msPaint;
	
	public DrCanvas(MsPaint msPaint){ //MsPaint에서 값을 얻어온다 
		this.setBackground(new Color(200, 191, 231));

		this.msPaint = msPaint; //MsPaint에서 값 가져오기 
	}

	@Override
	public void paint(Graphics g){
		// 좌표를 얻어와야한다. 
		int x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string값으로 받기 때문에 int값으로 바꿈
		// trim() : 앞뒤 공백 제거 
		// 그런데 좌표값을 넣지도 않았는데 오류가 난다? 
		// setVisible 어쩌고 하면서 바로 canvas를 띄운다. 
		// 그러면서 paint를 읽는다. 
		// paint는 한번만 읽는다. 
		// 그러다보니 "" 인 값을 먼저 읽어버린다. 
		// "" 을 기본값이라도 준다. 
		int x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		int y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		int y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
		// 색깔을 얻어와야한다.
		// 인덱스 값 얻어온다 color 배열이니까 
		switch(msPaint.getCombo().getSelectedIndex()){
			// getSelectedItem () > 글자 가져옴 
			// 혹은 case 0 : this.setForground(new Color(255, 0, 0, )); break;
			case 0: g.setColor(new Color(169, 38, 31)); break;//빨강
			case 1: g.setColor(new Color(140, 180, 20)); break;//초록
			case 2: g.setColor(new Color(51, 68, 149)); break;//파랑
			case 3: g.setColor(new Color(114, 72, 128)); break;//보라
			case 4: g.setColor(new Color(49, 151, 138)); break;//하늘
		}
		
		// 그림을 그리라고 한다. 
		// boolean 결과값이 나올 메서드는 is~~ 로 시작된다. 
		// toggle : 두 가지 기능 중 하나 (ex. 대소문자)
		if(msPaint.getFill().isSelected()){ // check가 되어있는지 확인 
			// fill된 도형(true)
			if(msPaint.getLine().isSelected()){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				g.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){ // 원이 선택되었는지 
				//g.fillOval(x1, y1, x2-x1, y2-y1);
				// 반대로도 그려질 수 있게 절대값을 씌어준다.( 높이와 길이는 절대로 음수가 나올 수 없으므로)
				// x1, y1이 무조건 시작이 되면 안된다. 작은 값이 시작이 되어야한다. 
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
			}else if(msPaint.getRect().isSelected()) {
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}

		} else{
			// 빈 도형(false)
			if(msPaint.getLine().isSelected()){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				g.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){
				g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRect().isSelected()) {
				g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}
		} 

	}

}
