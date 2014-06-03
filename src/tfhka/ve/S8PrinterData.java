package tfhka.ve;

public class S8PrinterData {
	private String headerLine1;
	private String headerLine2;
	private String headerLine3;
	private String headerLine4;
	private String headerLine5;
	private String headerLine6;
	private String headerLine7;
	private String headerLine8;
	private String footer1;
	private String footer2;
	private String footer3;
	private String footer4;
	private String footer5;
	private String footer6;
	private String footer7;
	private String footer8;
	public S8PrinterData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getHeaderLine1() {
		return headerLine1;
	}
	public void setHeaderLine1(String headerLine1) {
		this.headerLine1 = headerLine1;
	}
	public String getHeaderLine2() {
		return headerLine2;
	}
	public void setHeaderLine2(String headerLine2) {
		this.headerLine2 = headerLine2;
	}
	public String getHeaderLine3() {
		return headerLine3;
	}
	public void setHeaderLine3(String headerLine3) {
		this.headerLine3 = headerLine3;
	}
	public String getHeaderLine4() {
		return headerLine4;
	}
	public void setHeaderLine4(String headerLine4) {
		this.headerLine4 = headerLine4;
	}
	public String getHeaderLine5() {
		return headerLine5;
	}
	public void setHeaderLine5(String headerLine5) {
		this.headerLine5 = headerLine5;
	}
	public String getHeaderLine6() {
		return headerLine6;
	}
	public void setHeaderLine6(String headerLine6) {
		this.headerLine6 = headerLine6;
	}
	public String getHeaderLine7() {
		return headerLine7;
	}
	public void setHeaderLine7(String headerLine7) {
		this.headerLine7 = headerLine7;
	}
	public String getHeaderLine8() {
		return headerLine8;
	}
	public void setHeaderLine8(String headerLine8) {
		this.headerLine8 = headerLine8;
	}
	public String getFooter1() {
		return footer1;
	}
	public void setFooter1(String footer1) {
		this.footer1 = footer1;
	}
	public String getFooter2() {
		return footer2;
	}
	public void setFooter2(String footer2) {
		this.footer2 = footer2;
	}
	public String getFooter3() {
		return footer3;
	}
	public void setFooter3(String footer3) {
		this.footer3 = footer3;
	}
	public String getFooter4() {
		return footer4;
	}
	public void setFooter4(String footer4) {
		this.footer4 = footer4;
	}
	public String getFooter5() {
		return footer5;
	}
	public void setFooter5(String footer5) {
		this.footer5 = footer5;
	}
	public String getFooter6() {
		return footer6;
	}
	public void setFooter6(String footer6) {
		this.footer6 = footer6;
	}
	public String getFooter7() {
		return footer7;
	}
	public void setFooter7(String footer7) {
		this.footer7 = footer7;
	}
	public String getFooter8() {
		return footer8;
	}
	public void setFooter8(String footer8) {
		this.footer8 = footer8;
	}

	public S8PrinterData(String trama) {
		if (trama != null) {
			String[] arrayParameter = trama.split(String.valueOf((char) 0X0A));
			if (arrayParameter.length > 0) {
				this.setFooter1(arrayParameter[0].substring(3));
				this.setFooter2(arrayParameter[1]);
				this.setFooter3(arrayParameter[2]);
				this.setFooter4(arrayParameter[3]);
				this.setFooter5(arrayParameter[4]);
				this.setFooter6(arrayParameter[5]);
				this.setFooter7(arrayParameter[6]);
				this.setFooter8(arrayParameter[7]);
				this.setHeaderLine1(arrayParameter[8]);
				this.setHeaderLine1(arrayParameter[9]);
				this.setHeaderLine1(arrayParameter[10]);
				this.setHeaderLine1(arrayParameter[11]);
				this.setHeaderLine1(arrayParameter[12]);
				this.setHeaderLine1(arrayParameter[13]);
				this.setHeaderLine1(arrayParameter[14]);
				this.setHeaderLine1(arrayParameter[15]);
			}
		}
	}
	

}
