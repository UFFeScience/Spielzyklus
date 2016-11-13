using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using System.IO;
using System;


public class Histograma {
	public int[] histogramaOriginal = new int[256];
	public int[] histogramaAcumulado = new int[256];
	public int[] histogramaAcumuladoDesejado = new int[256];
	public int[] histogramaEqualizado = new int[256];
	public int[] histogramaConversaoEqualizacao = new int[256];
	public int[] histogramaEqualizadoAdaptativo = new int[256];
	public int[] histogramaConversaoEqualizacaoAdaptativa = new int[256];
	public int[] histogramaEqualizadoAdaptativoComLimite = new int[256];
	
	public Texture2D textureOriginal;	
	
	public GUISkin customSkin;
	
	public GameObject plane2;	
	
	public Histograma(Texture2D textureOriginal){
		this.textureOriginal = textureOriginal;
		//this.textureResultado = textureResultado;
	}
	
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
	
	}
	
	public void OnGUI()
	{
		
	}
	
	
	
	public void MontarHistogramaOriginal()
	{	
		for(int i = 0; i < textureOriginal.width ; i++)
		{
			for(int j = 0; j < textureOriginal.height; j++)
			{
				int r = (int)(textureOriginal.GetPixel(i,j).grayscale * 255);	
				histogramaOriginal[r]++;				
			}
		}
		exportHistogramaOriginal();
	}
	
	public void MontarHistogramaAcumulado()
	{
		histogramaAcumulado[0] = histogramaOriginal[0];
		for(int i = 1; i < histogramaAcumulado.Length; i++)
		{			
			histogramaAcumulado[i]= histogramaOriginal[i] + histogramaAcumulado[i-1];			
		}
		exportHistogramaAcumulado();
	}
	public void MontarHistogramaAcumuladoDesejado()
	{	histogramaAcumulado[0] = (textureOriginal.width * textureOriginal.height)/256;
		for(int i = 1; i < histogramaAcumuladoDesejado.Length; i++)
		{
			histogramaAcumuladoDesejado[i]= histogramaAcumuladoDesejado[i-1]+(textureOriginal.width * textureOriginal.height)/256;
			exportHistogramaAcumuladoDesejado();
		}
	}
	
	public void MontarHistogramaEqualizado()
	{	
		
		for(int i = 0; i < histogramaAcumulado.Length; i++)
		{	
			for(int j = 0; j < histogramaAcumuladoDesejado.Length; j++)
			{
				if( histogramaAcumulado[i] == histogramaAcumuladoDesejado[j])
				{
					histogramaConversaoEqualizacao[i] = j;
				}else
				{
					if( histogramaAcumulado[i] > histogramaAcumuladoDesejado[j] && j>0)
					{
						if(histogramaAcumulado[i]- histogramaAcumuladoDesejado[j] < histogramaAcumulado[i]- histogramaAcumuladoDesejado[j-1])
						{							
					    	histogramaConversaoEqualizacao[i] = j;
						}else{
							histogramaConversaoEqualizacao[i] = j-1;
						}
					}
				
				}
			}
		}
		for(int i = 0; i < histogramaEqualizado.Length; i++)
		{
			for(int j = 0; j < histogramaConversaoEqualizacao.Length; j++)
			{
				if(histogramaConversaoEqualizacao[j] == i)
				{
					histogramaEqualizado[i] +=  histogramaOriginal[j];
				}
			}
		}
		exportHistogramaEqualizado();
	}
	
	public void MontarHistogramaEqualizadoAdaptativo(int janela)
	{	
		
		for(int i = janela; i < histogramaAcumulado.Length - janela; i++)
		{	
			for(int j = i-janela; j < i+janela; j++)
			{
				if( histogramaAcumulado[i] == histogramaAcumuladoDesejado[j])
				{
					histogramaConversaoEqualizacaoAdaptativa[i] = j;
				}else
				{
					if( histogramaAcumulado[i] > histogramaAcumuladoDesejado[j] && j>0)
					{
						if(histogramaAcumulado[i]- histogramaAcumuladoDesejado[j] < histogramaAcumulado[i]- histogramaAcumuladoDesejado[j-1])
						{							
					    	histogramaConversaoEqualizacaoAdaptativa[i] = j;
						}else{
							histogramaConversaoEqualizacaoAdaptativa[i] = j-1;
						}
					}
				
				}
			}
		}
		for(int i = 0; i < histogramaEqualizadoAdaptativo.Length; i++)
		{
			for(int j = 0; j < histogramaConversaoEqualizacaoAdaptativa.Length; j++)
			{
				if(histogramaConversaoEqualizacaoAdaptativa[j] == i)
				{
					histogramaEqualizadoAdaptativo[i] +=  histogramaOriginal[j];
				}
			}
		}
		exportHistogramaEqualizadoAdaptativo();
	}
	
	public void MontarHistogramaEqualizadoAdaptativoComLimite(int limite)
	{	
		for(int i = 0; i < histogramaEqualizadoAdaptativoComLimite.Length ; i++)
		{
			histogramaEqualizadoAdaptativoComLimite[i] = histogramaEqualizadoAdaptativo[i];
			
		}
		
		// if(limite < (256*128)/256)
		//	limite = (256*128)/256;
			
		
			bool alterna = false;
	
		
			for(int i = 0; i < histogramaEqualizadoAdaptativoComLimite.Length ; i++)
			{	
				
				if(histogramaEqualizadoAdaptativoComLimite[i]> limite)
				{
					  int quantidade = histogramaEqualizadoAdaptativoComLimite[i] - limite;
					  int cont = 0;
					  while(quantidade > 0)
					  {
						if(alterna)
						{
							if (i-cont>0)
							{
								if(histogramaEqualizadoAdaptativoComLimite[i-cont]+quantidade < limite)
								{
								   histogramaEqualizadoAdaptativoComLimite[i-cont]+=quantidade;
								   histogramaEqualizadoAdaptativoComLimite[i]-=quantidade;
								   quantidade = 0; 
								}else
								{
									if(histogramaEqualizadoAdaptativoComLimite[i-cont] < limite)
									{
										int quantidadePossivel = limite - histogramaEqualizadoAdaptativoComLimite[i-cont];
										
										histogramaEqualizadoAdaptativoComLimite[i-cont]+= quantidadePossivel;
									    histogramaEqualizadoAdaptativoComLimite[i]-=quantidadePossivel;
										quantidade -= quantidadePossivel;
										
									}
								}
								
							}
						  alterna = false;
							
						}else{
							if (i+cont < histogramaEqualizadoAdaptativoComLimite.Length)
							{
							  //Debug.Log ("i = "+ i+ "  cont ="+cont);
								if(histogramaEqualizadoAdaptativoComLimite[i+cont]+quantidade < limite)
								{
								    histogramaEqualizadoAdaptativoComLimite[i+cont]+=quantidade;
								    histogramaEqualizadoAdaptativoComLimite[i]-=quantidade;
									quantidade = 0; 
								}else
								{
									if(histogramaEqualizadoAdaptativoComLimite[i+cont] < limite)
									{
										int quantidadePossivel = limite - histogramaEqualizadoAdaptativoComLimite[i+cont];
										
										histogramaEqualizadoAdaptativoComLimite[i+cont]+= quantidadePossivel;
									    histogramaEqualizadoAdaptativoComLimite[i]-=quantidadePossivel;
										quantidade -= quantidadePossivel;
										
									}
								}
								
							}
						    alterna = true;
							cont++;							
						}
					  	
							
					  }
					  
					  
				}				
			}		
		exportHistogramaEqualizadoAdaptativoComLimite();		
	}
	
	public void GeraImagemEqualizadaAdaptativaComLimite(Texture2D textureResultado, GameObject plano)
	{	
		int[] auxiliar = new int[256];
		for(int i = 0; i < histogramaEqualizadoAdaptativoComLimite.Length ; i++)
		{
			histogramaEqualizadoAdaptativoComLimite[i] = histogramaEqualizadoAdaptativo[i];
			
		}
		Color cor;
		bool alterna = false;
		
		for(int i = 0; i < textureOriginal.width ; i++)
		{
			for(int j = 0; j < textureOriginal.height; j++)
			{
				int valorPixel = (int)(textureOriginal.GetPixel(i,j).grayscale * 255);	
				
				if( auxiliar[valorPixel] < histogramaEqualizadoAdaptativoComLimite[valorPixel])
				{
					auxiliar[valorPixel]++;
					float valorPixelAterado = (float)valorPixel/255;				
					cor = new Color(valorPixelAterado, valorPixelAterado, valorPixelAterado);
					textureResultado.SetPixel(i,j,cor);
				}else
				{					 
					  int cont = 0;
					 
						if(alterna)
						{
							if (i-cont>0)
							{
								if(auxiliar[valorPixel-cont] < histogramaEqualizadoAdaptativoComLimite[valorPixel-cont])
								{
								    auxiliar[valorPixel-cont]++;
									float valorPixelAterado = (float)valorPixel/255;				
									cor = new Color(valorPixelAterado, valorPixelAterado, valorPixelAterado);
									textureResultado.SetPixel(i,j,cor);
								}
								
							}
						  alterna = false;
							
						}else{
							if (i+cont < histogramaEqualizadoAdaptativoComLimite.Length+cont)
							{
								if(auxiliar[valorPixel+cont] < histogramaEqualizadoAdaptativoComLimite[valorPixel+cont])
								{
								    auxiliar[valorPixel+cont]++;
									float valorPixelAterado = (float)valorPixel/255;				
									cor = new Color(valorPixelAterado, valorPixelAterado, valorPixelAterado);
									textureResultado.SetPixel(i,j,cor);
								}
								
							 }
						   
							alterna = true;	
							}
						    
							cont++;							
				}
					  	
					
		    }
		}	
		textureResultado.Apply();	
		plano.renderer.material.mainTexture = textureResultado;				
	}
	
	public void GeraImagemEqualizada(Texture2D textureResultado, GameObject plano)
	{
		Color cor;
		
		for(int i = 0; i < textureOriginal.width ; i++)
		{
			for(int j = 0; j < textureOriginal.height; j++)
			{
				int valorPixel = (int)(textureOriginal.GetPixel(i,j).grayscale * 255);	
				
				valorPixel = histogramaConversaoEqualizacao[valorPixel];					
				float valorPixelAterado = (float)valorPixel/255;
				
				cor = new Color(valorPixelAterado, valorPixelAterado, valorPixelAterado);
				textureResultado.SetPixel(i,j,cor);
			}
		}
		textureResultado.Apply();	
		plano.renderer.material.mainTexture = textureResultado;		
	}
	
	public void GeraImagemEqualizadaAdaptativa(Texture2D textureResultado, GameObject plano)
	{
		Color cor;
		
		for(int i = 0; i < textureOriginal.width ; i++)
		{
			for(int j = 0; j < textureOriginal.height; j++)
			{
				int valorPixel = (int)(textureOriginal.GetPixel(i,j).grayscale * 255);	
				
				valorPixel = histogramaConversaoEqualizacaoAdaptativa[valorPixel];					
				float valorPixelAterado = (float)valorPixel/255;
				
				cor = new Color(valorPixelAterado, valorPixelAterado, valorPixelAterado);
				textureResultado.SetPixel(i,j,cor);
			}
		}
		textureResultado.Apply();	
		plano.renderer.material.mainTexture = textureResultado;		
	}	
	
	
	
	public void exportHistogramaOriginal(){
		
		TextWriter txt = new StreamWriter("histogramaOriginal.csv");
		
		for(int i=0; i<histogramaOriginal.Length; i++)
			txt.WriteLine(histogramaOriginal[i]);
		
		txt.Close();
	}
	public void exportHistogramaAcumulado(){
		
		TextWriter txt = new StreamWriter("histogramaAcumulado.csv");
		
		for(int i=0; i<histogramaAcumulado.Length; i++)
			txt.WriteLine(histogramaAcumulado[i]);
		
		txt.Close();
	}
	public void exportHistogramaAcumuladoDesejado(){
		
		TextWriter txt = new StreamWriter("histogramaAcumuladoDesejado.csv");
		
		for(int i=0; i<histogramaAcumuladoDesejado.Length; i++)
			txt.WriteLine(histogramaAcumuladoDesejado[i]);
		
		txt.Close();
	}
	public void exportHistogramaEqualizado(){
		
		TextWriter txt = new StreamWriter("histogramaEqualizado.csv");
		
		for(int i=0; i<histogramaEqualizado.Length; i++)
			txt.WriteLine(histogramaEqualizado[i]);
		
		txt.Close();
	}
	public void exportHistogramaEqualizadoAdaptativo(){
		
		TextWriter txt = new StreamWriter("histogramaEqualizadoAdaptativo.csv");
		
		for(int i=0; i<histogramaEqualizadoAdaptativo.Length; i++)
			txt.WriteLine(histogramaEqualizadoAdaptativo[i]);
		
		txt.Close();
	}
	public void exportHistogramaEqualizadoAdaptativoComLimite(){
		
		TextWriter txt = new StreamWriter("histogramaEqualizadoAdaptativoComLimite.csv");
		
		for(int i=0; i<histogramaEqualizadoAdaptativoComLimite.Length; i++)
			txt.WriteLine(histogramaEqualizadoAdaptativoComLimite[i]);
		
		txt.Close();
	}
}
