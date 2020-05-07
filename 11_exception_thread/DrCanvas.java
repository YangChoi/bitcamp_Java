import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class DrCanvas extends Canvas {	
	private MsPaint msPaint;
	private Image bufferImg;
	private Graphics bufferG; 

	public DrCanvas(MsPaint msPaint){ //MsPaint���� ���� ���´� 
		this.setBackground(new Color(200, 191, 231));

		this.msPaint = msPaint; //MsPaint���� �� �������� 
	}

	// ĵ���� ������ ���� 
	// update > paint
	@Override
	public void update(Graphics g){
		// �簢������ ���� 
		Dimension d = this.getSize(); // ĵ������ ����� ���´� 
		if(bufferG == null){
			bufferImg = this.createImage(d.width, d.height); // �̹��� ���ο� ��ü ���� 
			bufferG = bufferImg.getGraphics(); // �� �̹��� ��ü���� �׸��� �׸� graphics ���� 

		}
		// ���� ������ ���� ������ (������ �׸��� �����)
		bufferG.setColor(this.getBackground()); // ĵ������ ������ �����´�.  
		// ���´�. 
		bufferG.fillRect(0, 0, d.width, d.height); // ���� ĵ������ ũ�⸸ŭ ���´�. 
		// ���� �� �ٽ� ó������ �����ؼ� �׸��� �׸���. 
		int x1, y1, x2, y2, z1, z2;

			
		// ���Ӱ� �׷����� ���� list �ȿ� ����ִ� ���� �����ͼ� ���� ��������Ѵ�. 
		// ���� : ArrayList �ȿ� �ִ� ShapeDTO�� �ϳ��� ������ �ٽ� �׸���. 
		for(ShapeDTO dto : msPaint.getList()){
			// list�� ������ �ƴ� MsPaint �Ϳ� private
			// ��ǥ
			// ����ߴ� ���� ������ ���̹Ƿ� dto���� ������ �����´�. 
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			// ��
			// bufferG �� �׷��� ���̱� ������ g�� bufferG�� �ٲ۴�. 
			switch(dto.getCombo()){	
				case 0: bufferG.setColor(new Color(169, 38, 31)); break;//����
				case 1: bufferG.setColor(new Color(140, 180, 20)); break;//�ʷ�
				case 2: bufferG.setColor(new Color(51, 68, 149)); break;//�Ķ�
				case 3: bufferG.setColor(new Color(114, 72, 128)); break;//����
				case 4: bufferG.setColor(new Color(49, 151, 138)); break;//�ϴ�
			}

			// ����
			if(dto.getFill()){ 
			// fill�� ����(true)
				if(dto.getShape() == Figure.LINE){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
					bufferG.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){ // ���� ���õǾ����� 
					//g.fillOval(x1, y1, x2-x1, y2-y1);
					// �ݴ�ε� �׷��� �� �ְ� ���밪�� �����ش�.( ���̿� ���̴� ����� ������ ���� �� �����Ƿ�)
					// x1, y1�� ������ ������ �Ǹ� �ȵȴ�. ���� ���� ������ �Ǿ���Ѵ�. 
					bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
				}else if(dto.getShape() == Figure.RECT) {
					bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					bufferG.drawLine(x1, y1, x2, y2);
				}

			} else{
				// �� ����(false)
				if(dto.getShape() == Figure.LINE){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
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
		// ���Ӱ� �׷����� �͵�-------------------
		// ��ǥ�� ���;��Ѵ�. 
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string������ �ޱ� ������ int������ �ٲ�
		// trim() : �յ� ���� ���� 
		// �׷��� ��ǥ���� ������ �ʾҴµ� ������ ����? 
		// setVisible ��¼�� �ϸ鼭 �ٷ� canvas�� ����. 
		// �׷��鼭 paint�� �д´�. 
		// paint�� �ѹ��� �д´�. 
		// �׷��ٺ��� "" �� ���� ���� �о������. 
		// "" �� �⺻���̶� �ش�. 
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
		// ������ ���;��Ѵ�.
		// �ε��� �� ���´� color �迭�̴ϱ� 
		switch(msPaint.getCombo().getSelectedIndex()){
			// getSelectedItem () > ���� ������ 
			// Ȥ�� case 0 : this.setForground(new Color(255, 0, 0, )); break;
			case 0: bufferG.setColor(new Color(169, 38, 31)); break;//����
			case 1: bufferG.setColor(new Color(140, 180, 20)); break;//�ʷ�
			case 2: bufferG.setColor(new Color(51, 68, 149)); break;//�Ķ�
			case 3: bufferG.setColor(new Color(114, 72, 128)); break;//����
			case 4: bufferG.setColor(new Color(49, 151, 138)); break;//�ϴ�
		}
		
		// �׸��� �׸���� �Ѵ�. 
		// boolean ������� ���� �޼���� is~~ �� ���۵ȴ�. 
		// toggle : �� ���� ��� �� �ϳ� (ex. ��ҹ���)
		if(msPaint.getFill().isSelected()){ // check�� �Ǿ��ִ��� Ȯ�� 
			// fill�� ����(true)
			if(msPaint.getLine().isSelected()){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
				bufferG.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){ // ���� ���õǾ����� 
				//g.fillOval(x1, y1, x2-x1, y2-y1);
				// �ݴ�ε� �׷��� �� �ְ� ���밪�� �����ش�.( ���̿� ���̴� ����� ������ ���� �� �����Ƿ�)
				// x1, y1�� ������ ������ �Ǹ� �ȵȴ�. ���� ���� ������ �Ǿ���Ѵ�. 
				bufferG.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
			}else if(msPaint.getRect().isSelected()) {
				bufferG.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				bufferG.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}else if(msPaint.getPen().isSelected()){
				bufferG.drawLine(x1, y1, x2, y2);
			}

		} else{
			// �� ����(false)
			if(msPaint.getLine().isSelected()){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
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

		paint(g); // ����Ʈ�� �ҷ�����.  >> update���� paint�� �Ѿ�� 
	}// update

	@Override
	public void paint(Graphics g){
		g.drawImage(bufferImg, 0, 0, this); // bufferImg�� 0, 0 ���� ������ �׷��޶� 

		/*
		paint�� ��� ���� update�� �ű��. 
		update���� �׸��� paint�� �����Ѵ�. 
		// ���Ӱ� �׷����� ���� list �ȿ� ����ִ� ���� �����ͼ� ���� ��������Ѵ�. 
		// ���� : ArrayList �ȿ� �ִ� ShapeDTO�� �ϳ��� ������ �ٽ� �׸���. 
		for(ShapeDTO dto : msPaint.getList()){
			// list�� ������ �ƴ� MsPaint �Ϳ� private
			// ��ǥ
			// ����ߴ� ���� ������ ���̹Ƿ� dto���� ������ �����´�. 
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();
			// ��
			switch(dto.getCombo()){	
				case 0: g.setColor(new Color(169, 38, 31)); break;//����
				case 1: g.setColor(new Color(140, 180, 20)); break;//�ʷ�
				case 2: g.setColor(new Color(51, 68, 149)); break;//�Ķ�
				case 3: g.setColor(new Color(114, 72, 128)); break;//����
				case 4: g.setColor(new Color(49, 151, 138)); break;//�ϴ�
			}

			// ����
			if(dto.getFill()){ 
			// fill�� ����(true)
				if(dto.getShape() == Figure.LINE){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
					g.drawLine(x1, y1, x2, y2);
				}else if(dto.getShape() == Figure.CIRCLE){ // ���� ���õǾ����� 
					//g.fillOval(x1, y1, x2-x1, y2-y1);
					// �ݴ�ε� �׷��� �� �ְ� ���밪�� �����ش�.( ���̿� ���̴� ����� ������ ���� �� �����Ƿ�)
					// x1, y1�� ������ ������ �Ǹ� �ȵȴ�. ���� ���� ������ �Ǿ���Ѵ�. 
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
				}else if(dto.getShape() == Figure.RECT) {
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
				}else if(dto.getShape() == Figure.ROUNDRECT) {
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				}else if(dto.getShape() == Figure.PEN){
					g.drawLine(x1, y1, x2, y2);
				}

			} else{
				// �� ����(false)
				if(dto.getShape() == Figure.LINE){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
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
		// ���Ӱ� �׷����� �͵�-------------------
		// ��ǥ�� ���;��Ѵ�. 
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string������ �ޱ� ������ int������ �ٲ�
		// trim() : �յ� ���� ���� 
		// �׷��� ��ǥ���� ������ �ʾҴµ� ������ ����? 
		// setVisible ��¼�� �ϸ鼭 �ٷ� canvas�� ����. 
		// �׷��鼭 paint�� �д´�. 
		// paint�� �ѹ��� �д´�. 
		// �׷��ٺ��� "" �� ���� ���� �о������. 
		// "" �� �⺻���̶� �ش�. 
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
		// ������ ���;��Ѵ�.
		// �ε��� �� ���´� color �迭�̴ϱ� 
		switch(msPaint.getCombo().getSelectedIndex()){
			// getSelectedItem () > ���� ������ 
			// Ȥ�� case 0 : this.setForground(new Color(255, 0, 0, )); break;
			case 0: g.setColor(new Color(169, 38, 31)); break;//����
			case 1: g.setColor(new Color(140, 180, 20)); break;//�ʷ�
			case 2: g.setColor(new Color(51, 68, 149)); break;//�Ķ�
			case 3: g.setColor(new Color(114, 72, 128)); break;//����
			case 4: g.setColor(new Color(49, 151, 138)); break;//�ϴ�
		}
		
		// �׸��� �׸���� �Ѵ�. 
		// boolean ������� ���� �޼���� is~~ �� ���۵ȴ�. 
		// toggle : �� ���� ��� �� �ϳ� (ex. ��ҹ���)
		if(msPaint.getFill().isSelected()){ // check�� �Ǿ��ִ��� Ȯ�� 
			// fill�� ����(true)
			if(msPaint.getLine().isSelected()){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
				g.drawLine(x1, y1, x2, y2);
			}else if(msPaint.getCircle().isSelected()){ // ���� ���õǾ����� 
				//g.fillOval(x1, y1, x2-x1, y2-y1);
				// �ݴ�ε� �׷��� �� �ְ� ���밪�� �����ش�.( ���̿� ���̴� ����� ������ ���� �� �����Ƿ�)
				// x1, y1�� ������ ������ �Ǹ� �ȵȴ�. ���� ���� ������ �Ǿ���Ѵ�. 
				g.fillOval(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));	
			}else if(msPaint.getRect().isSelected()) {
				g.fillRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1));
			}else if(msPaint.getRoundRect().isSelected()) {
				g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}else if(msPaint.getPen().isSelected()){
				g.drawLine(x1, y1, x2, y2);
			}

		} else{
			// �� ����(false)
			if(msPaint.getLine().isSelected()){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
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
