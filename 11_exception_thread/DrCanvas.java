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
			case 0: setColor(new Color(169, 38, 31)); break;//빨강
			case 1: setColor(new Color(140, 180, 20)); break;//초록
			case 2: setColor(new Color(51, 68, 149)); break;//파랑
			case 3: setColor(new Color(114, 72, 128)); break;//보라
			case 4: setColor(new Color(49, 151, 138)); break;//하늘
		}
		// 그림을 그리라고 한다. 
		if(fill ){ // check가 되어있는지 확인 
			// fill된 도형(true)
			if(line.isSelected()){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				g.drawLine(x1, y1, x2, y2);
			}else if(circle.isSelected()){ // 원이 선택되었는지 
				g.fillOval(x1, y1, width, height);
			}else if(rect.isSelected()) {
				g.fillRect(x1, y1, width, height);
			}else if(roundRect.isSelected()) {
				g.fillRoundRect(x1, y1, width, height, z1, z2);
			}

		} else{
			// 빈 도형(false)
			if(!(line.isSelected())){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				g.drawLine(x1, y1, x2, y2);
			}else if(!(circle.isSelected())){
				g.fillOval(x1, y1, width, height);
			}else if(!(rect.isSelected())) {
				g.fillRect(x1, y1, width, height);
			}else if(!(roundRect.isSelected())) {
				g.fillRoundRect(x1, y1, width, height, z1, z2);
			}
		}

	}

}
