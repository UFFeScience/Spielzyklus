using UnityEngine;
using System.Collections;


public class Main : MonoBehaviour {
	public Histograma histograma;
	public Texture2D originalImage;
	public Texture2D resultImage;
	public GameObject plane2;
	public GUISkin customSkin;
	public int janela = 3;
	public int limite = 500;
	
    public GameObject camera;
	private FiltroMedia filtroMed;	
	private TirandoFundoSub tirandoFundoSu;
	private TirandoFundoIgualaPiso tirandoFundoIqualaPis;
	private string pasta;
	private int janelaFiltroMedia = 3;
	private float limiteSuperior = 0.08f;
	private float limiteInferior = -0.08f;
	
	//public GameObject plane;
	
	

	// Use this for initialization
	void Start () {		
		filtroMed = camera.GetComponent<FiltroMedia>();		
		tirandoFundoSu = camera.GetComponent<TirandoFundoSub>();
	    tirandoFundoIqualaPis = camera.GetComponent<TirandoFundoIgualaPiso>();		
		Debug.Log("inicio");
		
	}
	
	private bool mediaPulo1 = true;
	private bool mediaPuloJanela = false;
	private bool regiaoInteresse = true;
	public void OnGUI()
	{
		
		GUI.skin = customSkin;
		int x = Screen.width/2;
		int y = 20;
		int width = 150;
		int height = 20;
		
	    GUI.Box(new Rect(x-=500, y, width, height), "Equalizacoes");
		if(GUI.Button(new Rect(x, y+=30, width, height), "Global")){		
			
			EqualizacaoGlobal();
		}		
		if(GUI.Button(new Rect(x, y+=30, width, height), "Adaptativa")){
				
			EqualizacaoAdaptativa();
		}
		//janela = GUI.TextField(new Rect(x-100, y, width/2, height), ""+janela);
		
		if(GUI.Button(new Rect(x, y+=30, width, height), "Adaptativa com Limite")){
			
			EqualizacaoAdaptativaComLimite();		
		}
		//limite = GUI.TextField(new Rect(x-100, y, width/2, height), ""+limite);
		
		
		#region Filtro de Media
		GUI.Box(new Rect(x, y+=100, width+70, height), "Subtracao com Filtro de Media");
		
		GUI.Label(new Rect(x,y+=30, 100, 50), "Janela = ");		
		janelaFiltroMedia = int.Parse(GUI.TextField(new Rect(x+80, y, 100, 20), " "+janelaFiltroMedia));
		
		GUI.Label(new Rect(x,y+=30, 100, 50), "Limte Sup = ");		
		limiteSuperior = float.Parse(GUI.TextField(new Rect(x+80, y, 100, 20), " "+limiteSuperior));
		
		GUI.Label(new Rect(x,y+=30, 100, 50), "Limte Inf = ");		
		limiteInferior = float.Parse(GUI.TextField(new Rect(x+80, y, 100, 20), " "+limiteInferior));
		
		GUI.Label(new Rect(x, y+=30, width, height), "PULO");
		if(GUI.Toggle(new Rect(x, y+=30, width-80, height),mediaPulo1, "1"))
		{
			mediaPulo1 = true;
			mediaPuloJanela = false;
		}
		if(GUI.Toggle(new Rect(x, y+=30, width-80, height),mediaPuloJanela, "Janela"))
		{
			mediaPulo1 = false;
			mediaPuloJanela = true;
		}
		
		GUI.Label(new Rect(x+=80, y-=60, width, height), "REGIAO DE INTERESSE");
		if(GUI.Toggle(new Rect(x+=30, y+=30, width-80, height),regiaoInteresse, "Sim"))
		{
			
			regiaoInteresse = true;
		}
		if(GUI.Toggle(new Rect(x, y+=30, width-80, height),!regiaoInteresse, "Nao"))
		{
			regiaoInteresse = false;
		}
		
		
		if(GUI.Button(new Rect(x-=110, y+=30, width, height), "Gerar")){	
			
			int pulo = 0; 
			if(regiaoInteresse)
			{
				pasta = "Textures";
			}else{
				pasta = "Textures2";
			}
			if(!mediaPulo1)
			{
				pulo = 1;
			}
			filtroMed.janela = janelaFiltroMedia;
			filtroMed.iniciar(janela,pasta);
		}
		#endregion
		
	}
	
	
	public void EqualizacaoGlobal(){		
		histograma = new Histograma(originalImage);
		histograma.MontarHistogramaOriginal();
		histograma.MontarHistogramaAcumulado();
		histograma.MontarHistogramaAcumuladoDesejado();
		histograma.MontarHistogramaEqualizado();
		histograma.GeraImagemEqualizada(resultImage, plane2);
	}
	
	public void EqualizacaoAdaptativa(){	
		histograma = new Histograma(originalImage);
		histograma.MontarHistogramaOriginal();
		histograma.MontarHistogramaAcumulado();
		histograma.MontarHistogramaAcumuladoDesejado();
		histograma.MontarHistogramaEqualizado();
		histograma.MontarHistogramaEqualizadoAdaptativo(janela);
		histograma.GeraImagemEqualizadaAdaptativa(resultImage, plane2);
	}
	public void EqualizacaoAdaptativaComLimite(){	
		histograma = new Histograma(originalImage);
		histograma.MontarHistogramaOriginal();
		histograma.MontarHistogramaAcumulado();
		histograma.MontarHistogramaAcumuladoDesejado();
		histograma.MontarHistogramaEqualizado();
		histograma.MontarHistogramaEqualizadoAdaptativo(janela);
		histograma.MontarHistogramaEqualizadoAdaptativoComLimite(limite);
		histograma.GeraImagemEqualizadaAdaptativaComLimite(resultImage, plane2);
	}
	
	
}
