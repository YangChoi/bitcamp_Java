import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

class DrCanvas extends Canvas {	
	private MsPaint msPaint;

	public DrCanvas(MsPaint msPaint){ //MsPaint���� ���� ���´� 
		this.setBackground(new Color(200, 191, 231));

		this.msPaint = msPaint; //MsPaint���� �� �������� 
	}

	@Override
	public void paint(Graphics g){
		// ��ǥ�� ���;��Ѵ�. 
		int x1 = Integer.parseInt(msPaint.getX1T().getText().trim()); //string������ �ޱ� ������ int������ �ٲ�
		// trim() : �յ� ���� ���� 
		// �׷��� ��ǥ���� ������ �ʾҴµ� ������ ����? 
		// setVisible ��¼�� �ϸ鼭 �ٷ� canvas�� ����. 
		// �׷��鼭 paint�� �д´�. 
		// paint�� �ѹ��� �д´�. 
		// �׷��ٺ��� "" �� ���� ���� �о������. 
		// "" �� �⺻���̶� �ش�. 
		int x2 = Integer.parseInt(msPaint.getX2T().getText().trim()); 
		int y1 = Integer.parseInt(msPaint.getY1T().getText().trim()); 
		int y2 = Integer.parseInt(msPaint.getY2T().getText().trim()); 
		int z1 = Integer.parseInt(msPaint.getZ1T().getText().trim()); 
		int z2 = Integer.parseInt(msPaint.getZ2T().getText().trim()); 
		
		// ������ ���;��Ѵ�.
		// �ε��� �� ���´� color �迭�̴ϱ� 
		switch(msPaint.getCombo().getSelectedIndex()){
			// getSelectedItem () > ���� ������ 
			case 0: setColor(new Color(169, 38, 31)); break;//����
			case 1: setColor(new Color(140, 180, 20)); break;//�ʷ�
			case 2: setColor(new Color(51, 68, 149)); break;//�Ķ�
			case 3: setColor(new Color(114, 72, 128)); break;//����
			case 4: setColor(new Color(49, 151, 138)); break;//�ϴ�
		}
		// �׸��� �׸���� �Ѵ�. 
		if(fill ){ // check�� �Ǿ��ִ��� Ȯ�� 
			// fill�� ����(true)
			if(line.isSelected()){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
				g.drawLine(x1, y1, x2, y2);
			}else if(circle.isSelected()){ // ���� ���õǾ����� 
				g.fillOval(x1, y1, width, height);
			}else if(rect.isSelected()) {
				g.fillRect(x1, y1, width, height);
			}else if(roundRect.isSelected()) {
				g.fillRoundRect(x1, y1, width, height, z1, z2);
			}

		} else{
			// �� ����(false)
			if(!(line.isSelected())){ // ������ üũ �Ǿ����� Ȯ��(���� �Ȱ��� �Լ�)
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
