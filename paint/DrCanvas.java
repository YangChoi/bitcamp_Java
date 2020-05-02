package paint;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

class DrCanvas extends Canvas {
	private MsPaint msPaint;
	
	
	public DrCanvas(MsPaint msPaint){
		this.setBackground(new Color(255,200,255));
		this.msPaint = msPaint;
	}

	@Override
	public void paint(Graphics g){
		int x1, y1, x2, y2, z1, z2;

		
		//복원 - ArrayList에 있는 ShapeDTO를 하나씩 꺼내서 다시 그린다
		for(ShapeDTO dto : msPaint.getList()){
			//좌표
			x1 = dto.getX1();
			y1 = dto.getY1();
			x2 = dto.getX2();
			y2 = dto.getY2();
			z1 = dto.getZ1();
			z2 = dto.getZ2();

			//색
			switch(dto.getCombo()){
			case 0 : g.setColor(new Color(255,0,0)); break;
			case 1 : g.setColor(new Color(0,255,0)); break;
			case 2 : g.setColor(new Color(0,0,255)); break;
			case 3 : g.setColor(new Color(255,0,255)); break;
			case 4 : g.setColor(new Color(0,255,255)); break;
			
			
			}	

			
					
			//도형
			if(dto.getFill()){//채우기
				if(dto.getShape() == Figure.LINE) 
					g.drawLine(x1, y1, x2, y2);
				else if(dto.getShape() == Figure.CIRCLE) 
					g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Figure.RECT) 
					g.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Figure.ROUNDRECT) 
					g.fillRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				else if(dto.getShape() == Figure.PEN)
					g.drawLine(x1, y1, x2, y2);
				
					
			}else { //비어있는 도형
				if(dto.getShape() == Figure.LINE) 
					g.drawLine(x1, y1, x2, y2);
				else if(dto.getShape() == Figure.CIRCLE) 
					g.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Figure.RECT) 
					g.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
				else if(dto.getShape() == Figure.ROUNDRECT) 
					g.drawRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
				else if(dto.getShape() == Figure.PEN)
					g.drawLine(x1, y1, x2, y2);
				
			}

		}//for

		//---------------------
		//좌표
		x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
		y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
		x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
		y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
		z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
		z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());
		
	
		//색
		switch(msPaint.getCombo().getSelectedIndex()){
			//case 0 : this.setForeground(new Color(255,0,0)); break;
			case 0 : g.setColor(new Color(255,0,0)); break;
			case 1 : g.setColor(new Color(0,255,0)); break;
			case 2 : g.setColor(new Color(0,0,255)); break;
			case 3 : g.setColor(new Color(255,0,255)); break;
			case 4 : g.setColor(new Color(0,255,255)); break;
			
		}

		//도형
		if(msPaint.getFill().isSelected()){//채우기
			if(msPaint.getLine().isSelected()) 
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) 
				g.fillOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected()) 
				g.fillRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected()) 
				g.fillRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			else if(msPaint.getPen().isSelected())
				g.drawLine(x1, y1, x2, y2);
				
		}else { //비어있는 도형
			if(msPaint.getLine().isSelected()) 
				g.drawLine(x1, y1, x2, y2);
			else if(msPaint.getCircle().isSelected()) 
				g.drawOval(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRect().isSelected()) 
				g.drawRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1));
			else if(msPaint.getRoundRect().isSelected()) 
				g.drawRoundRect(Math.min(x1,x2), Math.min(y1,y2), Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);	
			else if(msPaint.getPen().isSelected())
				g.drawLine(x1, y1, x2, y2);	
		}
		
	}
}
