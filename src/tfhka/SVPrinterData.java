package tfhka;

//import org.w3c.dom.ranges.RangeException;


//Actualización: Objeto para obtener la Vesión y el País de las Impresoras Fiscales 
public class SVPrinterData
{
	private String Model;
	private String Country;
        
	private static final String TallyD_1125 = "Tally-1125",
		SRP_270 = "SRP-270",
		SRP_280  = "SRP-280",
		SRP_350  = "SRP-350",
		SRP_812  = "SRP-812",
		Dascom_DT230  = "DT-230",
		PP1F3 = "PP1F3",
		KUBE  = "Kube",
		HSP7000  = "HSP-7000",
		HKA112  = "HKA-112",
		OKI_ML1120  = "ML-1125",
		Unknown  = "Unknown";
        
         private static final String VE = "Venezuela",
		DO = "Republica Dominicana",
		CW = "Curazao",
		UN = "Unknown";
	
	//Nota: Los Datos correspondientes a la versión y al País vienen en la trama?
	public String getModel()
	{
		return Model;
	}

	public void setModel(String model)
	{
		Model = model;
	}

	public String getCountry()
	{
		return Country;
	}

	public void setCountry(String country)
	{
		Country = country;
	}

	public SVPrinterData(String trama)
	{
		 this.Model = Unknown;
		 this.Country = UN;
		 if(trama != null){
			 if(trama.length() > 0){
				 try{
					 String arrayParamater[] = trama.split(String.valueOf((char) 0X0A));
					 if(arrayParamater.length >= 1){                                        
							
							 if (arrayParamater[1].equals("Z6A")){ //TalyDascom 1125
								 Model = TallyD_1125;
								 }							 
                                                         else if (arrayParamater[1].equals("Z1B")){ //SRP_350
								 Model = SRP_350;
								 }								 
                                                         else if (arrayParamater[1].equals("Z6B")){//Dascom DT230
								 Model = Dascom_DT230;
								 }								 
                                                         else if (arrayParamater[1].equals("ZZB")){ //PP1F3
								 Model = PP1F3;
								 }			 
                                                         else if (arrayParamater[1].equals("Z1A")){ //SRP 270
								 Model = SRP_270;
								 }							
							  else if (arrayParamater[1].equals("DLA")){//KUBE
								 Model = KUBE;
								 }							 
							  else if (arrayParamater[1].equals("ZPA")){ //HSP7000
								 Model = HSP7000;
								 }								 
							  else if (arrayParamater[1].equals("Z7A")){//HKA112
								 Model = HKA112;
								 }								 
							  else if (arrayParamater[1].equals("Z1E")){ //SRP 280
								 Model = SRP_280;
								 }								 
							  else if (arrayParamater[1].equals("Z1F")){ //SRP 812
								 Model = SRP_812;
								 }
								
							  else if (arrayParamater[1].equals("Z4A")){ //OKI ML1120
								 Model = OKI_ML1120;
								 }								 
                                                          else{
								Model = Unknown;
								}
						 
						 
						  
						 if (arrayParamater[2].equals("VE")){ //Venezuela
							 Country = VE;
							 }						 
                                                 else if (arrayParamater[2].equals("RD")){ //Republica Dominicana
							 Country = DO;
							 }							 
                                                 else if (arrayParamater[2].equals("DO")){ //Dominicana
							 Country = DO;
							 }						 
						 else if (arrayParamater[2].equals("CW")){//Curazao
							 Country = CW;
							 }
                                                 else{
							Country = UN;
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
	}
}



	