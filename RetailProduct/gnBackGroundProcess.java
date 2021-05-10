package RetailProduct;

import java.beans.PropertyChangeListener;
import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JButton;
// w ww  . j ava 2  s  . c  o m
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;

class gnBackGroundProcess extends SwingWorker<Void, String> {

	public gnBackGroundProcess(JButton mysave, JProgressBar pb) {
		mysave.addPropertyChangeListener(new PropertyChangeListener() {
			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("progress".equalsIgnoreCase(evt.getPropertyName())) {
					pb.setValue(getProgress());
				}
			}
		});
	}

	@Override
	protected void done() {

	}

	@Override
	protected void process(List<String> chunks) {
		for (String text : chunks) {

		}
	}

	@Override
	protected Void doInBackground() throws Exception {
		for (int index = 0; index < 100; index++) {
			publish("Line " + index);
			setProgress(index);
			Thread.sleep(125);
		}
		return null;
	}
}
