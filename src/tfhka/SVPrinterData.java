package tfhka;

import org.w3c.dom.ranges.RangeException;

//Actualización: Objeto para obtener la Vesión y el País de las Impresoras Fiscales 
public class SVPrinterData
{
	private PModel Model;
	private PCountry Country;
	
	public enum PModel{
		TallyD_1125,
		SRP_270,
		SRP_280,
		SRP_350,
		SRP_812,
		Dascom_DT230,
		PP1F3,
		KUBE,
		HSP7000,
		HKA112,
		OKI_ML1120,
		Unknown
	}
	
	public enum PCountry{
		Venezuela,
		RepDominicana,
		Curazao,
		Unknown
	}
	
	//Nota: Los Datos correspondientes a la versión y al País vienen en la trama?
	public PModel getModel()
	{
		return Model;
	}

	public void setModel(PModel model)
	{
		Model = model;
	}

	public PCountry getCountry()
	{
		return Country;
	}

	public void setCountry(PCountry country)
	{
		Country = country;
	}

	public SVPrinterData(String trama)
	{
		 this.Model = PModel.Unknown;
		 this.Country = PCountry.Unknown;
		 if(trama != null){
			 if(trama.length() > 0){
				 try{
					 String arrayParamater[] = trama.split(String.valueOf((char) 0X0A));
					 if(arrayParamater.length >= 1){
							 switch(arrayParamater[1]){
							 case "Z6A": //TalyDascom 1125
								 Model = PModel.TallyD_1125;
								 break;
							 
							 case "Z1B": //SRP_350
								 Model = PModel.SRP_350;
								 break;
								 
							 case "Z6B": //Dascom DT230
								 Model = PModel.Dascom_DT230;
								 break;
								 
							 case "ZZB": //PP1F3
								 Model = PModel.PP1F3;
								 break;
								 
							 case "Z1A": //SRP 270
								 Model = PModel.SRP_270;
								 break;
							
							 case "DLA": //KUBE
								 Model = PModel.KUBE;
								 break;
							 
							 case "ZPA": //HSP7000
								 Model = PModel.HSP7000;
								 break;
								 
							 case "Z7A": //HKA112
								 Model = PModel.HKA112;
								 break;
								 
							 case "Z1E": //SRP 280
								 Model = PModel.SRP_280;
								 break;
								 
							 case "Z1F": //SRP 812
								 Model = PModel.SRP_812;
								 break;
								
							 case "Z4A": //OKI ML1120
								 Model = PModel.OKI_ML1120;
								 break;
								 
							default:
								Model = PModel.Unknown;
								break;
						 }
						 
						 switch (arrayParamater[2]){
						 case "VE": //Venezuela
							 Country = PCountry.Venezuela;
							 break;
						 
						 case "RD": //Republica Dominicana
							 Country = PCountry.RepDominicana;
							 break;
							 
						 case "DO": //Dominicana
							 Country = PCountry.RepDominicana;
							 break;
						 
						 case "CW": //Curazao
							 Country = PCountry.Curazao;
							 break;
							 
							default:
								Country = PCountry.Unknown;
								break;
						}
					 }
				 
			 }catch(RangeException e){
			 }
		 }
		}
	}
}



	