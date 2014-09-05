package tfhka.ve;

public class S8PPrinterData
{
	private String footer1;
	private String footer2;
	private String footer3;
	private String footer4;
	private String footer5;
	private String footer6;
	private String footer7;
	private String footer8;

	public S8PPrinterData()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFooter1()
	{
		return footer1;
	}

	public void setFooter1(String footer1)
	{
		this.footer1 = footer1;
	}

	public String getFooter2()
	{
		return footer2;
	}

	public void setFooter2(String footer2)
	{
		this.footer2 = footer2;
	}

	public String getFooter3()
	{
		return footer3;
	}

	public void setFooter3(String footer3)
	{
		this.footer3 = footer3;
	}

	public String getFooter4()
	{
		return footer4;
	}

	public void setFooter4(String footer4)
	{
		this.footer4 = footer4;
	}

	public String getFooter5()
	{
		return footer5;
	}

	public void setFooter5(String footer5)
	{
		this.footer5 = footer5;
	}

	public String getFooter6()
	{
		return footer6;
	}

	public void setFooter6(String footer6)
	{
		this.footer6 = footer6;
	}

	public String getFooter7()
	{
		return footer7;
	}

	public void setFooter7(String footer7)
	{
		this.footer7 = footer7;
	}

	public String getFooter8()
	{
		return footer8;
	}

	public void setFooter8(String footer8)
	{
		this.footer8 = footer8;
	}

	public S8PPrinterData(String trama)
	{
            try
            {
		if (trama != null)
		{
			String[] arrayParameter = trama.split(String.valueOf((char) 0X0A));
			if (arrayParameter.length > 0)
			{
				this.setFooter1(arrayParameter[0].replaceAll("S8P", ""));
				this.setFooter2(arrayParameter[1]);
				this.setFooter3(arrayParameter[2]);
				this.setFooter4(arrayParameter[3]);
				this.setFooter5(arrayParameter[4]);
				this.setFooter6(arrayParameter[5]);
				this.setFooter7(arrayParameter[6]);
				this.setFooter8(arrayParameter[7]);
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
