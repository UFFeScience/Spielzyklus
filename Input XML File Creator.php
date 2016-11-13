<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Untitled Document</title>
</head>

<body>
<?php
$local = "localhost";
$user = "root";
$pass = "cstudio";
$bdnome = "provenance_db";

$GameSession = 1;
if(!($id = mysql_connect($local, $user, $pass)));
mysql_select_db($bdnome, $id);

$Write = array();
$Writer = new XMLWriter();
	$Writer->openMemory();
	$Writer->startDocument( '1.0' , 'utf-8' ) ;
	$Writer->setIndent(true);
	$Writer->startElement( "provenancedata" ) ;	
	

$resultado = mysql_query("SELECT * FROM agent");
while ($linha = mysql_fetch_array($resultado)) {
$id = $linha["id"];
$name = $linha["name"];
$atributes = $linha["atributes"];
$goals = $linha["goals"];
$location = $linha["location"];

 $Writer->startElement( 'vertex' ) ;
	
	
   $Writer->writeElement ('id' , 'ag'.$id);
   $Writer->writeElement ('type' , 'Agent');
   $Writer->writeElement ('label' , $name);
   $Writer->writeElement ('date' , '0');
    $Writer->writeElement ('importance' , '*');
   $Writer->writeElement ('time' , '*');
   $Writer->writeElement ('gamesession' , '*'); 
   $Writer->startElement('details');
   $Writer->endElement();	
 $Writer->endElement();	
}

$lastid;

$resultado = mysql_query("SELECT * FROM activity");
//echo "aki 11";
while ($linha = mysql_fetch_array($resultado)) {
//	echo "aki 22";
$id = $linha["id"];
$idGameSession = $linha["idGameSession"];
$idAgent = $linha["idAgent"];
$idEntity = $linha["idEntity"];
$idActivity = $linha["idActivityType"];
$time = $linha["time"];

 $Writer->startElement( 'vertex' ) ;	
	
   $Writer->writeElement ('id' , 'ac'.$id);
   $Writer->writeElement ('type' , 'Activity');
   $resultado2 = mysql_query("SELECT * FROM activitytype where id = $idActivity");
	  while ($linha = mysql_fetch_array($resultado2)) {
   	   $Writer->writeElement ('label' , $linha["reason"]);
	  }
	$Writer->writeElement ('date' , '0');	
   
   if(strcmp($idEntity, "NULL" )!= 0)
   {
	   $resultado2 = mysql_query("SELECT * FROM entity where id = $idEntity");
	  while ($linha = mysql_fetch_array($resultado2)) {		 			
			$Writer->writeElement ('importance' , $linha["importance"]);		    	  
	  }
   }else{
	   
	   		if(strcmp($idActivity, "3" )== 0)
   			{
				 $Writer->writeElement ('importance' , 4);
				  	   			
			}else{
				$Writer->writeElement ('importance' , -10);					
				}
	   }
	   
	
	 $Writer->writeElement ('time' , $time);
	 $Writer->writeElement ('gamesession' , $idGameSession);
	$Writer->startElement('details');
    $Writer->endElement();	
	
 $Writer->endElement();	
$lastid = $id; 
}
$lastid++;
$Writer->startElement( 'vertex' ) ;	
	
   $Writer->writeElement ('id' , 'ac'.$lastid);
   $Writer->writeElement ('type' , 'Activity');  
   $Writer->writeElement ('label' , '*');	 
   $Writer->writeElement ('date' , '0');	
   $Writer->writeElement ('importance' , '*');
   $Writer->writeElement ('time' , '*');
   $Writer->writeElement ('gamesession' , '*');
   $Writer->startElement('details');
   $Writer->endElement();	
	
 $Writer->endElement();	

$resultado = mysql_query("SELECT * FROM entity");
while ($linha = mysql_fetch_array($resultado)) {
$id = $linha["id"];
$name = $linha["name"];
$type = $linha["type"];
$importance = $linha["importance"];
$location = $linha["location"];
$attributes = $linha["attributes"];

 $Writer->startElement( 'vertex' ) ;	
	
   $Writer->writeElement ('id' , 'ent'.$id);
   $Writer->writeElement ('type' , 'Entity');
   $Writer->writeElement ('label' , $name);
   $Writer->writeElement ('date' , '0'); 
   $Writer->writeElement ('importance' , $importance);  
   $Writer->writeElement ('time' , '*');
   $Writer->writeElement ('gamesession' , '*');
   $Writer->startElement('details');
   $Writer->endElement();	
 $Writer->endElement();	
}


$resultado = mysql_query("SELECT * FROM activity");

while ($linha = mysql_fetch_array($resultado)) {
$id = $linha["id"];
$idGameSession = $linha["idGameSession"];
$idAgent = $linha["idAgent"];
$idEntity = $linha["idEntity"];
$idActivity = $linha["idActivityType"];
$time = $linha["time"];

 $Writer->startElement( 'edge' ) ;	
	
   $Writer->writeElement ('id' , 'e'.$id);
   $Writer->writeElement ('type' , 'Neutral');
   $Writer->writeElement ('label' , '');
   if(strcmp($idEntity, "NULL" )!= 0)
   {
	   $resultado2 = mysql_query("SELECT * FROM entity where id = $idEntity");
	  while ($linha = mysql_fetch_array($resultado2)) {
   	   $Writer->writeElement ('value' , $linha["importance"]);
	  }
   }else{
	   		if(strcmp($idActivity, "3" )== 0)
   			{
	   			 $Writer->writeElement ('value' , '4');
			}else{
				 $Writer->writeElement ('value' , '-10');
				}
	   }
    $Writer->writeElement ('time' , $time);
	$Writer->writeElement ('gamesession' , $idGameSession);
  
   $Writer->writeElement ('sourceid' , 'ac'.$id);
   $next = $id+1;
   $Writer->writeElement ('targetid' , 'ac'.$next);   
 $Writer->endElement();	
}

//segunda relação
$resultado = mysql_query("SELECT * FROM activity");

while ($linha = mysql_fetch_array($resultado)) {
$id = $linha["id"];
$idGameSession = $linha["idGameSession"];
$idAgent = $linha["idAgent"];
$idEntity = $linha["idEntity"];
$idActivity = $linha["idActivityType"];
$time = $linha["time"];

 $Writer->startElement( 'edge' ) ;	
	
   $Writer->writeElement ('id' , 'e'.$id);
   $Writer->writeElement ('type' , 'Credits');
   $Writer->writeElement ('label' , '');
   
   if(strcmp($idEntity, "NULL" )!= 0)
   {
	   $resultado2 = mysql_query("SELECT * FROM entity where id = $idEntity");
	  while ($linha = mysql_fetch_array($resultado2)) {
   	   $Writer->writeElement ('value' , $linha["importance"]);
	  }
   }else{
	   		if(strcmp($idActivity, "3" )== 0)
   			{
	   			 $Writer->writeElement ('value' , '4');
			}else{
				 $Writer->writeElement ('value' , '-10');
				}
	   }
    $Writer->writeElement ('time' , $time);
	$Writer->writeElement ('gamesession' , $idGameSession);
  
   $Writer->writeElement ('sourceid' , 'ac'.$id); 
   
   if(strcmp($idEntity, "NULL" )!= 0)
   {
   		$Writer->writeElement ('targetid' , 'ent'.$idEntity); 
   }else{
	   		$Writer->writeElement ('targetid' , 'ag'.$idAgent); 
	   }
   
 $Writer->endElement();	
}
	
	$Writer->endElement();
	$Output = $Writer->outputMemory ( true ) ;
	
	$fHandle = fopen ( 'input.xml' , 'w+' ) ;  
	fwrite ( $fHandle , $Output ) ;
	fclose ( $fHandle ) ;
?>
</body>
</html>