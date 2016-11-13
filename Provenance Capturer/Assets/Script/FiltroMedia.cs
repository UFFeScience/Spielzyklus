using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class FiltroMedia: MonoBehaviour {	
	public Object[] textures;
	public Texture2D texture1;
	public Texture2D texture2;	
	public Texture2D textureResult;
	public int janela = 4;
	public float limSuper = 0.08f;
	public float limInfe = -0.08f;
	public List<Texture2D> textureSub;
	private ImageUtilities util;
	
	
	// Use this for initialization
	public void iniciar (int i, string pasta) {
		
		util = ImageUtilities.GetInstance();	
		LoadTexture(pasta);	
		iniciarVetor(textureSub);
		if(i == 0)
		{
			filtroMediaPulo1();
		}else{
			filtroMediaComPuloJanela();
		}
		
		
		util.SaveTextures(textureSub,2);
		Debug.Log("fim");
	}
	
	// Update is called once per frame
	void Update () {
	
	}
	
	
	public void filtroMediaComPuloJanela()
	{
		Color cor;
		   texture1 = (Texture2D)textures[0];
			for(int k = 0; k < textures.Length; k++)
			{
				for(int i = 0; i < texture1.width - janela ; i++)
				{	
					texture2 = (Texture2D)textures[k];						
				
					for(int j = 0; j < texture1.height- janela; j+=janela)
					{				
					    float mediaBase = 0;
						float mediaCorrente = 0;
					
						for(int x = i; x < i+janela ; x++)
						{
							for(int y = j; y < j+janela; y++)
							{						   
							    mediaBase += texture1.GetPixel(x,y).grayscale;
							    mediaCorrente += texture2.GetPixel(x,y).grayscale;
							}
						}
					    mediaBase = mediaBase/(janela*janela);
					    mediaCorrente = mediaCorrente/(janela*janela);
					    
					    float r;
						if(mediaBase-mediaCorrente > limSuper || mediaBase-mediaCorrente < limInfe)
						{
							r = 1f;
						}else{
						    r = 0f;
						}
						cor = new Color(r, r, r);
						for(int x = i; x < i+janela ; x++)
						{
							for(int y = j; y < j+janela; y++)
							{
							   textureSub[k].SetPixel(x,y,cor);
							}
						}
						
					}
				}
			texture1 = (Texture2D)textures[k];
			textureSub[k].Apply();	
		}
		
	}
	
	public void filtroMediaPulo1()
	{
		Color cor;
		texture1 = (Texture2D)textures[0];
		for(int k = 0; k < textures.Length; k++)
		{	
			texture2 = (Texture2D)textures[k];	
			for(int i = 0; i < texture1.width - janela ; i++)
			{
				for(int j = 0; j < texture1.height- janela; j++)
				{				
				    float mediaBase = 0;
					float mediaCorrente = 0;
				
					for(int x = i; x < i+janela ; x++)
					{
						for(int y = j; y < j+janela; y++)
						{						   
						    mediaBase += texture1.GetPixel(x,y).grayscale;
						    mediaCorrente += texture2.GetPixel(x,y).grayscale;
						}
					}
				    mediaBase = mediaBase/(janela*janela);
				    mediaCorrente = mediaCorrente/(janela*janela);
				    
				    float r;
					if(mediaBase-mediaCorrente > limSuper || mediaBase-mediaCorrente < limInfe)
					{
						r = 1f;
					}else{
					    r = 0f;
					}
					cor = new Color(r, r, r);
					
					textureSub[k].SetPixel(i,j,cor);					
					
				}
			}
		
			textureSub[k].Apply();	
		}
	}
	
	public void LoadTexture(string pasta)
	{		
		textures = Resources.LoadAll(pasta, typeof(Texture2D));	
	}
	
	public void iniciarVetor(List<Texture2D> lista)
	{
		for(int k = 0; k < lista.Count; k++)
		{
		    lista[k] = new Texture2D(textureResult.width-janela , textureResult.height-janela);			
			
		}
		
	}
	
}
