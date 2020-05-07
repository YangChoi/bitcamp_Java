import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class DrCanvas extends Canvas {	
	private MsPaint msPaint;
	private Image bufferImg;
	private Graphics bufferG; 

	public DrCanvas(MsPaint msPaint){ //MsPaint에서 값을 얻어온다 
		this.setBackground(new Color(200, 191, 231));

		this.msPaint = msPaint; //MsPaint에서 값 가져오기 
	}

	// 캔버스 깜빡임 개선 
	// update > paint
	@Override
	public void update(Graphics g){
		// 사각영역의 정보 
		Dimension d = this.getSize(); // 캔버스의 사이즈를 얻어온다 
		if(bufferG == null){
			bufferImg = this.createImage(d.width, d.height); // 이미지 새로운 객체 생성 
			bufferG = bufferImg.getGraphics(); // 그 이미지 객체에서 그림을 그릴 graphics 생성 

		}
		// 같은 색으로 덮어 버리자 (기존의 그림을 지운다)
		bufferG.setColor(this.getBackground()); // 캔버스의 배경색을 가져온다.  
		// 덮는다. 
		bufferG.fillRect(0, 0, d.width, d.height); // 현재 캔버스의 크기만큼 덮는다. 
		// 지운 후 다시 처음부터 복원해서 그림을 그린다. 
		int x1, y1, x2, y2, z1, z2;

			
		// 새롭게 그려지기 전에 list 안에 담겨있는 것을 꺼내와서 복원 시켜줘야한다. 
		// 복원 : ArrayList 안에 있는 ShapeDTO를 하나씩 꺼내서 다시 그린다. 
		for(ShapeDTO dto : msPaint.getList()){
			// list는 내것이 아닌 MsPaint 것에 private
			// 좌표
			// 기억했던 것을 꺼내는 것이므로 dto안의 값들을 꺼내온다. 
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			// 색
			// bufferG 에 그려질 것이기 때문에 g를 bufferG로 바꾼다. 
			switch(dto.getCombo()){	
				case 0: bufferG.setColor(new Color(169, 38, 31)); break;//빨강
				case 1: bufferG.setColor(new Color(140, 180, 20)); break;//초록
				case 2: bufferG.setColor(new Color(51, 68, 149)); break;//파랑
				case 3: bufferG.setColor(new Color(114, 72, 128)); break;//보라
				case 4: bufferG.setColor(new Color(49, 151, 138)); break;//하늘
			}

			// 도형
			if(dto.getFill()){ 
			// fill된 도형(true)
				if(dto.getShape() == Figure.LINE){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){ // 원이 선택되었는지 
					//g.fillOval(x1, y1, x2-x1, y2-y1);
					// 반대로도 그려질 수 있게 절대값을 씌어준다.( 높이와 길이는 절대로 음수가 나올 수 없으므로)
					// x1, y1이 무조건 시작이 되면 안된다. 작은 값이 시작이 되어야한다. 
					bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					bufferG.drawLine(x1, y1, x2, y2);
				}

			} else{
				// 빈 도형(false)
				if(dto.getShape() == Figure.LINE){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){
					bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					bufferG.drawLine(x1, y1, x2, y2);
				}
			}
		}// for
		// 새롭게 그려지는 것들-------------------
		// 좌표를 얻어와야한다. 
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string값으로 받기 때문에 int값으로 바꿈
		// trim() : 앞뒤 공백 제거 
		// 그런데 좌표값을 넣지도 않았는데 오류가 난다? 
		// setVisible 어쩌고 하면서 바로 canvas를 띄운다. 
		// 그러면서 paint를 읽는다. 
		// paint는 한번만 읽는다. 
		// 그러다보니 "" 인 값을 먼저 읽어버린다. 
		// "" 을 기본값이라도 준다. 
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
		// 색깔을 얻어와야한다.
		// 인덱스 값 얻어온다 color 배열이니까 
		switch(msPaint.getCombo().getSelectedIndex()){
			// getSelectedItem () > 글자 가져옴 
			// 혹은 case 0 : this.setForground(new Color(255, 0, 0, )); break;
			case 0: bufferG.setColor(new Color(169, 38, 31)); break;//빨강
			case 1: bufferG.setColor(new Color(140, 180, 20)); break;//초록
			case 2: bufferG.setColor(new Color(51, 68, 149)); break;//파랑
			case 3: bufferG.setColor(new Color(114, 72, 128)); break;//보라
			case 4: bufferG.setColor(new Color(49, 151, 138)); break;//하늘
		}
		
		// 그림을 그리라고 한다. 
		// boolean 결과값이 나올 메서드는 is~~ 로 시작된다. 
		// toggle : 두 가지 기능 중 하나 (ex. 대소문자)
		if(msPaint.getFill().isSelected()){ // check가 되어있는지 확인 
			// fill된 도형(true)
			if(msPaint.getLine().isSelected()){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){ // 원이 선택되었는지 
				//g.fillOval(x1, y1, x2-x1, y2-y1);
				// 반대로도 그려질 수 있게 절대값을 씌어준다.( 높이와 길이는 절대로 음수가 나올 수 없으므로)
				// x1, y1이 무조건 시작이 되면 안된다. 작은 값이 시작이 되어야한다. 
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
			}else if(msPaint.getRect().isSelected()) {
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}else if(msPaint.getPen().isSelected()){
				bufferG.drawLine(x1, y1, x2, y2);
			}

		} else{
			// 빈 도형(false)
			if(msPaint.getLine().isSelected()){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){
				bufferG.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRect().isSelected()) {
				bufferG.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				bufferG.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}else if(msPaint.getPen().isSelected()){
				bufferG.drawLine(x1, y1, x2, y2);
			}
		} 

		paint(g); // 페인트를 불러낸다.  >> update에서 paint로 넘어간다 
	}// update

	@Override
	public void paint(Graphics g){
		g.drawImage(bufferImg, 0, 0, this); // bufferImg를 0, 0 부터 나에게 그려달라 

		/*
		paint의 모든 것을 update로 옮긴다. 
		update에서 그리고 paint로 전달한다. 
		// 새롭게 그려지기 전에 list 안에 담겨있는 것을 꺼내와서 복원 시켜줘야한다. 
		// 복원 : ArrayList 안에 있는 ShapeDTO를 하나씩 꺼내서 다시 그린다. 
		for(ShapeDTO dto : msPaint.getList()){
			// list는 내것이 아닌 MsPaint 것에 private
			// 좌표
			// 기억했던 것을 꺼내는 것이므로 dto안의 값들을 꺼내온다. 
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			// 색
			switch(dto.getCombo()){	
				case 0: g.setColor(new Color(169, 38, 31)); break;//빨강
				case 1: g.setColor(new Color(140, 180, 20)); break;//초록
				case 2: g.setColor(new Color(51, 68, 149)); break;//파랑
				case 3: g.setColor(new Color(114, 72, 128)); break;//보라
				case 4: g.setColor(new Color(49, 151, 138)); break;//하늘
			}

			// 도형
			if(dto.getFill()){ 
			// fill된 도형(true)
				if(dto.getShape() == Figure.LINE){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
					g.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){ // 원이 선택되었는지 
					//g.fillOval(x1, y1, x2-x1, y2-y1);
					// 반대로도 그려질 수 있게 절대값을 씌어준다.( 높이와 길이는 절대로 음수가 나올 수 없으므로)
					// x1, y1이 무조건 시작이 되면 안된다. 작은 값이 시작이 되어야한다. 
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
				}else if(dto.getShape() == Figure.RECT) {
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					g.drawLine(x1, y1, x2, y2);
				}

			} else{
				// 빈 도형(false)
				if(dto.getShape() == Figure.LINE){ // 라인이 체크 되었는지 확인(위와 똑같은 함수)
					g.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.RECT) {
					g.drawRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					g.drawLine(x1, y1, x2, y2);
				}
			}
		}// for
		// 새롭게 그려지는 것들-------------------
		// 좌표를 얻어와야한다. 
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string값으로 받기 때문에 int값으로 바꿈
		// trim() : 앞뒤 공백 제거 
		// 그런데 좌표값을 넣지도 않았는데 오류가 난다? 
		// setVisible 어쩌고 하면서 바로 canvas를 띄운다. 
		// 그러면서 paint를 읽는다. 
		// paint는 한번만 읽는다. 
		// 그러다보니 "" 인 값을 먼저 읽어버린다. 
		// "" 을 기본값이라도 준다. 
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
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
			}else if(msPaint.getPen().isSelected()){
				g.drawLine(x1, y1, x2, y2);
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
			}else if(msPaint.getPen().isSelected()){
				g.drawLine(x1, y1, x2, y2);
			}
		} 
		*/
	} // paint

}
