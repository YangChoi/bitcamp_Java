

class WindowExit implements WindowListener {
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0); // â�� ��������. 
	} // x�� ������ ���� 
	public void windowDeactivated(WindowEvent e){} // _ ���� 
	public void windowDeiconified(WindowEvent e){} // _ ������ ���� 
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}
