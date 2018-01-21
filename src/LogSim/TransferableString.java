package LogSim;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class TransferableString implements Transferable {
	
	private String string;
	
	protected static DataFlavor stringFlavor = new DataFlavor(String.class, "A String to Transfer");
	
	protected static DataFlavor[] supportedFlavors = {
		DataFlavor.stringFlavor
	};

	public TransferableString(String string) {
		this.string = string;
	}
	public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
		return string; 
	}

	public DataFlavor[] getTransferDataFlavors() {
		return supportedFlavors;
	}

	public boolean isDataFlavorSupported(DataFlavor flavor) {
		
		if(flavor.equals(DataFlavor.stringFlavor)) 
			return true;
		else
			return false;
	}
}