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
			}
		} 

	}

}
