package RetailProduct;

public class gnModel {

	public boolean isCellEditable(int row, int column) {
		return column == 1 || column == 2 || column == 5 || column == 6 || column == 7 || column == 10 ? false : true;
	}

	public boolean RateDisable(int row, int column) {
		if (column == 4)

			return false;
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
