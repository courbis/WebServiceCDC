
import Entidad.PreguntaFormulario;
import com.google.gson.Gson;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class clasePrueba {
    
    
     public LinkedList<PreguntaFormulario> separarRespuesta(int idTareaAsignada,String respuesta){
         int i=1;
        LinkedList<PreguntaFormulario> listaRespuesta=new LinkedList<PreguntaFormulario>();
        String delimitador=",";
    StringTokenizer stringTokenizer=new StringTokenizer(respuesta, delimitador);
    while(stringTokenizer.hasMoreTokens()){
        PreguntaFormulario pf=new PreguntaFormulario();
        pf.setRespuesta(stringTokenizer.nextToken());
        pf.setIdPregunta(i++);
        pf.setIdTareaAsignada(idTareaAsignada);
        listaRespuesta.add(pf);
    }
    return listaRespuesta;
     }
    
    
     public static void main(String[]args){
clasePrueba p=new clasePrueba();
Gson gson=new Gson();
for(int i=0;i<p.separarRespuesta(i, "si,si,si,si,si,si,si,si,si").size();i++){
    
}
    
int i=0;
         System.out.println(gson.toJson(p.separarRespuesta(2,"si,si,si,si,si,si,si,si,si")));

    }
    
}
