package tfhka.ar;

public class S8EPrinterData
{
	private String headerLine1;
	private String headerLine2;
	private String headerLine3;
	private String headerLine4;
	private String headerLine5;
	private String headerLine6;
	private String headerLine7;
	private String headerLine8;

	public S8EPrinterData()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getHeaderLine1()
	{
		return headerLine1;
	}

	public void setHeaderLine1(String headerLine1)
	{
		this.headerLine1 = headerLine1;
	}

	public String getHeaderLine2()
	{
		return headerLine2;
	}

	public void setHeaderLine2(String headerLine2)
	{
		this.headerLine2 = headerLine2;
	}

	public String getHeaderLine3()
	{
		return headerLine3;
	}

	public void setHeaderLine3(String headerLine3)
	{
		this.headerLine3 = headerLine3;
	}

	public String getHeaderLine4()
	{
		return headerLine4;
	}

	public void setHeaderLine4(String headerLine4)
	{
		this.headerLine4 = headerLine4;
	}

	public String getHeaderLine5()
	{
		return headerLine5;
	}

	public void setHeaderLine5(String headerLine5)
	{
		this.headerLine5 = headerLine5;
	}

	public String getHeaderLine6()
	{
		return headerLine6;
	}

	public void setHeaderLine6(String headerLine6)
	{
		this.headerLine6 = headerLine6;
	}

	public String getHeaderLine7()
	{
		return headerLine7;
	}

	public void setHeaderLine7(String headerLine7)
	{
		this.headerLine7 = headerLine7;
	}

	public String getHeaderLine8()
	{
		return headerLine8;
	}

	public void setHeaderLine8(String headerLine8)
	{
		this.headerLine8 = headerLine8;
	}

	public S8EPrinterData (String trama){
            try
            {
		if(trama != null){
			String[] arrayParameter = trama.split(String.valueOf((char) 0X0A));
			if(arrayParameter.length > 0){
				this.setHeaderLine1(arrayParameter[0].replaceAll("S8E", ""));
				this.setHeaderLine2(arrayParameter[1]);
				this.setHeaderLine3(arrayParameter[2]);
				this.setHeaderLine4(arrayParameter[3]);
				this.setHeaderLine5(arrayParameter[4]);
				this.setHeaderLine6(arrayParameter[5]);
				this.setHeaderLine7(arrayParameter[6]);
				this.setHeaderLine8(arrayParameter[7]);
			}
		}	
            }catch(ArrayIndexOutOfBoundsException are)
	                    {
	                        return;
	                    }catch (NumberFormatException nfexp)
	                    {
	                        return;
	                    }catch (StringIndexOutOfBoundsException sfexp)
	                    {
	                        return;
	                    }
	}
}
