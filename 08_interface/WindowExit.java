

class WindowExit implements WindowListener {
	public void windowActivated(WindowEvent e){}
	public void windowClosed(WindowEvent e){}
	public void windowClosing(WindowEvent e){
		System.exit(0); // 창을 꺼버린다. 
	} // x를 누르는 시점 
	public void windowDeactivated(WindowEvent e){} // _ 해제 
	public void windowDeiconified(WindowEvent e){} // _ 누르는 시점 
	public void windowIconified(WindowEvent e){}
	public void windowOpened(WindowEvent e){}

}
