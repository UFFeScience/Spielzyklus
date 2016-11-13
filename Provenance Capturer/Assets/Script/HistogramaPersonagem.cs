using UnityEngine;
using System.Collections;
using System.Collections.Generic;
using System.IO;



public class HistogramaPersonagem : MonoBehaviour {
	
	[System.Serializable]
    public class HPersonagem
    {
		public int[] hPersonagem = new int[256];
		public int[] hPersonagemR = new int[256];
		public int[] hPersonagemG = new int[256];
		public int[] hPersonagemB = new int[256];
	}	
	
	[System.Serializable]
    public class VerificadoY
    {
		public int[] y = new int[288];
	}	
	
	public Object[] textures;
	public Texture2D texture1;
	public List<Texture2D> textureSub;
	public List<Texture2D> personagensTexture;
	public List<HPersonagem> histogramas;	
	private ImageUtilities util;
	
	
	public int[] margemAceit = new int[7];
	public int[] percentual = new int[7];
	public int quantPixelPerso =0;
	public List<VerificadoY> verificadoX;
	public int imgCorrente;
	
	private bool process = false;
	private bool imprime = false;
	private int pixelValue;
	private int[] histAtual;
	private Color cor;
	private int contido;
	private int cont;
	private int contR;
	private int contG;
	private int contB;
	
	
	// Use this for initialization
	void Start () {
		util = ImageUtilities.GetInstance();
		
		for(int i = 0; i < textures.Length; i++)
		{				
			textureSub[i]= new Texture2D(texture1.width , texture1.height);
		}
		
		LoadTexture();
		loadHist();		
		
		process = true;
		
				
	}
	
	// Update is called once per frame
	void Update () {
		if(process)
		{
			for(int i = 0; i < textures.Length; i++)
			{								
				textureSub[i]= (Texture2D)textures[i];	
				texture1 = 	textureSub[i];
				imgCorrente = i;
				//exportHistPersonagem();		
				existePersonagem();
			}				
			process = false;
			imprime = true;
			
		}
		if (imprime)
		{	
			int Wtempo = (int)Time.realtimeSinceStartup;
			int horas = (int)(Wtempo / 3600);
			int minutos = (int)((Wtempo - (horas * 3600)) / 60);
			int segundos = Wtempo - (horas * 3600) - (minutos * 60);
			
			
			Debug.Log(horas+":"+minutos+":"+segundos);
			imprime = false;
			util.SaveTextures(textureSub,2);
		}
	}
	
	public void limpaVerificado()
	{
		for(int i = 0; i < verificadoX.Count ; i++) 
		{
			for(int j = 0; j < verificadoX[0].y.Length ; j++)
			{
				verificadoX[i].y[j]=0; 
			}
		}			
	}
	
	public void loadHist(){
		
		for(int k = 0; k < personagensTexture.Count ; k++)
		{			
			for(int i = 0; i < personagensTexture[0].width ; i++)
			{
				for(int j = 0; j < personagensTexture[0].height; j++)
				{
					pixelValue = (int)(personagensTexture[k].GetPixel(i,j).grayscale * 255);						
					histogramas[k].hPersonagem[pixelValue]++;
					
					pixelValue = (int)(personagensTexture[k].GetPixel(i,j).r * 255);						
					histogramas[k].hPersonagemR[pixelValue]++;
					
					pixelValue = (int)(personagensTexture[k].GetPixel(i,j).g * 255);						
					histogramas[k].hPersonagemG[pixelValue]++;
					
					pixelValue = (int)(personagensTexture[k].GetPixel(i,j).b * 255);						
					histogramas[k].hPersonagemB[pixelValue]++;
				}
			}
		}
	}
		
	
	public void existePersonagem(){
		
		
		for(int k = 0; k < 1; k++)//personagensTexture.Count
		{	
			limpaVerificado();	
			quantPixelPerso = quantDifZero(histogramas[k].hPersonagem);	
			
			switch(k)
			{
				case 0:
					cor = new Color(0,0,0f);
				break;
				case 1:
					cor = new Color(0.78f,0.66f,0.3f);
				break;
				case 2:
					cor = new Color(0.97f,0.96f,0.2f);
				break;
				case 3:
					cor = new Color(0.66f,0.19f,0.05f);
				break;
				case 4:
					cor = new Color(0.33f,0.5f,0.13f);
				break;
				case 5:
					cor = new Color(0.68f,0.04f,0.02f);
				break;
				case 6:
					cor = new Color(0,1,0);
				break;				
				
			}			
			
			for(int i = 112; i < 240 ; i+=2) //240
			{
				for(int j = 38; j < 198 ; j+=2) //156
				{
					if(verificadoX[i].y[j]==0 && verificadoX[i+personagensTexture[0].width].y[j]==0 && verificadoX[i].y[j+personagensTexture[0].height]==0 && verificadoX[i+personagensTexture[0].width].y[j+personagensTexture[0].height]==0)
					{
						carregahistAtual(i,j);
						
						contido = contemhist(histAtual, k);
						
						if(contido > quantPixelPerso * percentual[k]/100)
						{					
							confirmaR(k);
							if(contR > quantPixelPerso * percentual[k]/100)
							{
								confirmaG(k);
								if(contG > quantPixelPerso * percentual[k]/100)
								{
									confirmaB(k);
									if(contB > quantPixelPerso * percentual[k]/100)
									{
										pintaRetangulo(i,j,cor);
										quadroVerificado(i,j);
									}
								}
							}
							
						}
						if(contido < quantPixelPerso * 10/100)
						{					
							quadroVerificado(i,j);
							j+=personagensTexture[0].width;
						}
					}else{
						j+=personagensTexture[0].width;
					}
					
				}
			}
		}//end for k
		
	}
	
	public void quadroVerificado(int i, int j)
	{
		for(int ii = i; ii < i+ personagensTexture[0].width ; ii++) 
		{
			for(int jj = j; jj < j+ personagensTexture[0].height ; jj++) 
			{
				verificadoX[ii].y[jj] = 1;
			}
		}
	}
	
	public void pintaRetangulo(int i, int j, Color cor)
	{		
		for(int ii = i; ii < i+personagensTexture[0].width ; ii++)
		{
			textureSub[imgCorrente].SetPixel(ii,j,cor);
			textureSub[imgCorrente].SetPixel(ii,j+personagensTexture[0].height,cor);
		}
		for(int jj = j; jj < j+personagensTexture[0].height; jj++)
		{
			textureSub[imgCorrente].SetPixel(i,jj,cor);
			textureSub[imgCorrente].SetPixel(i+personagensTexture[0].width,jj,cor);
		}
		textureSub[0].Apply();
	}
		
	public void pintaRetangulo2(int i, int j, Color cor)
	{		
		for(int ii = i; ii < i+personagensTexture[0].width ; ii++)
		{
			for(int jj = j; jj < j+personagensTexture[0].height; jj++)
			{
					textureSub[0].SetPixel(ii,jj,cor);
			}
		}
		textureSub[0].Apply();
	}
	
	public int contemhist(int[] atual, int k)
	{			
		cont = 0;
		for(int i = 0; i < histogramas[0].hPersonagem.Length ; i++)
		{		
			if(histogramas[k].hPersonagem[i]>0)
			{
				if(atual[i] > histogramas[k].hPersonagem[i] - margemAceit[k] )
				cont++;
			}
			
		}
		
		return cont;	
		
	}	
	
	
	public bool confirma(int i, int j)
	{		
		int preto = 0;
		int branco = 0;
		for(int ii = i + 13; ii < i+25 ; ii++)
		{
			for(int jj = j+17; jj < j+25; jj++)
			{
				if(textureSub[imgCorrente].GetPixel(ii,jj).grayscale * 255<20)
					preto++;
				if(textureSub[imgCorrente].GetPixel(ii,jj).grayscale * 255>200)
					branco++;
			}
		}
		if(preto >= 4 && branco >= 4)
		{
			return true;
		}else{
			return false;
		}
	}
	
	public void confirmaR(int k)
	{		
		contR = 0;		
		for(int ii = 0; ii < histogramas[0].hPersonagem.Length ; ii++)
		{		
			if(histogramas[k].hPersonagemR[ii]>0)
			{
				if(histAtual[ii] > histogramas[k].hPersonagemR[ii] - margemAceit[k] )
				contR++;
			}			
		}		
		
	}
	public void confirmaG(int k)
	{		
		contG = 0;		
		for(int ii = 0; ii < histogramas[0].hPersonagem.Length ; ii++)
		{		
			if(histogramas[k].hPersonagemG[ii]>0)
			{
				if(histAtual[ii] > histogramas[k].hPersonagemG[ii] - margemAceit[k] )
				contG++;
			}			
		}		
		
	}
	public void confirmaB(int k)
	{		
		contB = 0;		
		for(int ii = 0; ii < histogramas[0].hPersonagem.Length ; ii++)
		{		
			if(histogramas[k].hPersonagemB[ii]>0)
			{
				if(histAtual[ii] > histogramas[k].hPersonagemB[ii] - margemAceit[k] )
				contB++;
			}			
		}		
		
	}
	
	
	public void carregahistAtual(int i, int j)
	{
		
		histAtual = new int[256];
		for(int ii = i; ii < i+personagensTexture[0].width ; ii++)
		{
			for(int jj = j; jj < j+personagensTexture[0].height; jj++)
			{
				pixelValue = (int)(texture1.GetPixel(ii,jj).grayscale * 255);	
				
				//if(histAtual[r]<20)
				histAtual[pixelValue]++;					
								
			}
		}		
		
	}
	
	public void exportHistPersonagem(){
		Debug.Log("estive aki");
		for(int k = 0; k < personagensTexture.Count ; k++) 
		{
			TextWriter txt = new StreamWriter("histPersonagem_"+k+".csv");
			
			for(int i=0; i<histogramas[k].hPersonagem.Length; i++)
				txt.WriteLine(histogramas[k].hPersonagem[i]);
			
			txt.Close();
		}
	}
	
	public int quantDifZero( int[] vetor)
	{
		cont = 0;
		for(int i = 0; i < 255 ; i++) 
		{
			if(vetor[i]>0)
				cont++;
		}
		return cont;
	}
	
	public int somaVetor(int[] vetor)
	{
		int soma = 0;
		for(int i = 0; i < vetor.Length ; i++) 
		{
			soma+=vetor[i]*i;
		}
		return soma;
	}
	
	public void LoadTexture()
	{		
		textures = Resources.LoadAll("Textures", typeof(Texture2D));	
	}
	

		
		
}
