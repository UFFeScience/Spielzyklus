using UnityEngine;
using System.Collections;
using System.IO;
using System.Collections.Generic;

public class ImageUtilities
{
	private static ImageUtilities instance = null;
	private string imagePath = "c:/Calculated Images/";
	
	/*
	 * Type: 0 - Original, 1 - Added, 2 - Subtracted
	 * */
	public void SaveTextures(List<Texture2D> textures, int type)
	{
		if(type == 0)
			imagePath+="Original/";
		else if(type == 1)
			imagePath+="Added/";
		else if(type == 2)
			imagePath+="Subtracted/";
		else{}
			//Debug.LogError("Invalid Type Parameter");
			
		
		//Debug.Log("Current Data Path: "+imagePath);

		for(int i=0; i<textures.Count; i++)
		{
			byte[] bytes = textures[i].EncodeToPNG();
			string imageName = "result_"+type+"_"+i+".png";			
			//Debug.Log("Save Data Path: "+imagePath+imageName);
			File.WriteAllBytes(imagePath+imageName,bytes);
			//Debug.Log("Save image "+ imageName);
		}
	}
	
	/*
	 * Type: 0 - Original, 1 - Added, 2 - Subtracted
	 * If necessary use intervals like 1-10, 10-20.
	 * */
	public void SaveTextures(List<Texture2D> textures, int type, string interval)
	{
		string newType="";
		
		if(type == 0){
			imagePath+="Original/";
			newType = "Original";
		}
		else if(type == 1)
		{
			imagePath+="Added/";
			newType = "Added";
		}
		else if(type == 2)
		{
			imagePath+="Subtracted";
			newType = "Subtracted";
		}
		else{}
			//Debug.LogError("Invalid Type Parameter");
			
		
		//Debug.Log("Current Data Path: "+imagePath);

		for(int i=0; i<textures.Count; i++)
		{
			byte[] bytes = textures[i].EncodeToPNG();
			string imageName = "result_"+newType+"_"+interval+"_"+(i+1)+".png";			
			//Debug.Log("Save Data Path: "+imagePath+imageName);
			File.WriteAllBytes(imagePath+imageName,bytes);
			//Debug.Log("Save image "+ imageName);
		}
	}
	
	public static ImageUtilities GetInstance()
	{
		if(instance==null)
			instance = new ImageUtilities();
		return instance;
	}
}
